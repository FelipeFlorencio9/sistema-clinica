package br.senai.sp.jandira.dao;

import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.model.Medico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MedicoDAO {

    //MEU BANCO DE DADOS
    private static final ArrayList<Medico> dataBaseMedicos = new ArrayList<>();

    //PARA WINDOWNS
//    private static final String ARQUIVO = "C:\\Users\\22282108\\Documents\\NetBeansProjects\\clinica-java\\src\\br\\senai\\sp\\jandira\\repositorios\\medico.txt";
//    private static final String ARQUIVO_TEMP = "C:\\Users\\22282108\\Documents\\NetBeansProjects\\clinica-java\\src\\br\\senai\\sp\\jandira\\repositorios\\medico_temp.txt";
//    private static final Path PATH = Paths.get(ARQUIVO);
//    private static final Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);
    //PARA LINUX
    private static final ArrayList<Medico> medicos = new ArrayList<>();
    private static final String ARQUIVO = "/home/felipedeoliveiraflorencio/Documentos/sistema-clinica/src/br/senai/sp/jandira/repositorios/medico.txt";
    private static final String ARQUIVO_TEMP = "/home/felipedeoliveiraflorencio/Documentos/sistema-clinica/src/br/senai/sp/jandira/repositorios/medico__temp.txt";
    private static final Path PATH = Paths.get(ARQUIVO);
    private static final Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);

    public MedicoDAO() {
    }

    public static void getListaDeMedicos() {
        try {

            BufferedReader br = Files.newBufferedReader(PATH);
            String linha = br.readLine();

            while (linha != null && !linha.isEmpty()) {

                String[] linhaVetor = linha.split(";");
                ArrayList<Especialidade> medicoEspecialidades = new ArrayList<>();

                String[] codigoDasEspecialidades = linhaVetor[6].split("&");
                for (String codigo : codigoDasEspecialidades) {
                    medicoEspecialidades.add(EspecialidadeDAO.getEspecialidade(Integer.valueOf(codigo)));
                }
                Medico novoMedico = new Medico(
                        Integer.valueOf(linhaVetor[0]),
                        linhaVetor[1],
                        linhaVetor[2],
                        linhaVetor[3],
                        linhaVetor[4],
                        linhaVetor[5],
                        medicoEspecialidades);

                medicos.add(novoMedico);
                linha = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro ao abrir o arquivo.",
                    "Erro de leitura",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static Medico getMedico(Integer codigo) {
        for (Medico m : dataBaseMedicos) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }

        return null;
    }

    public static void inserir(Medico medico) {
        medicos.add(medico);
        try {
            BufferedWriter bw = Files.newBufferedWriter(
                    PATH,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

            String novoMedico = medico.getSeparadoPorPontoEVirgula();
            bw.write(novoMedico);
            bw.newLine();
            bw.close();

        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(
                    null,
                    "Houve um problema ao tentar abrir o arquivo.",
                    "Erro de Gravação",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void remover(Integer id) {

        for (Medico m : medicos) {
            if (m.getCodigo().equals(id)) {
                medicos.remove(m);
                break;
            }

        }

        //Reconstruir um arquivo atualizado, ou seja, 
        //sem o plano que foi removido
        //PASSO 01 - Criar uma representação dos arquivos que serão manipulados
        File arquivoAtual = new File(ARQUIVO);
        File arquivoTemp = new File(ARQUIVO_TEMP);

        try {
            //Criar o arquivo temporário
            arquivoTemp.createNewFile();

            //Abrir o arquivo temporário para escrita
            BufferedWriter bwTemp = Files.newBufferedWriter(
                    PATH_TEMP,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

            //Iterar a lista para adicionar os planos no arquivo temporário
            for (Medico m : medicos) {
                bwTemp.write(m.getStringMedicoForPanel());
                bwTemp.newLine();
            }

            bwTemp.close();

            arquivoAtual.delete();

            //Renomear o arquivo temporário para o nome do arquivo atual
            arquivoTemp.renameTo(arquivoAtual);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro ao criar o arquivo!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void atualizar(Medico medico) {
        for (Medico m : medicos) {
            if (m.getCodigo().equals(medico.getCodigo())) {
                medicos.set(medicos.indexOf(m), medico);
                break;
            }
            atualizarArquivo();
        }

    }

    public static DefaultTableModel getTableModel() {

        Object[][] dados = new Object[medicos.size()][4];

        int i = 0;
        for (Medico m : medicos) {
            dados[i][0] = m.getCodigo().toString();
            dados[i][1] = m.getCrm();
            dados[i][2] = m.getNome();
            dados[i][3] = m.getTelefone();
//          dados[i][3] = m.getEspecialidadesPorNome();;
            i++;
        }

        String[] titulos = {"Código", "CRM", "Nome do(a) Médico(a)", "Telefone para Contato"};

        DefaultTableModel tableModelMedico = new DefaultTableModel(dados, titulos);

        return tableModelMedico;
    }

    public static void atualizarArquivo() {

        File arquivoAtual = new File(ARQUIVO);
        File arquivoTemp = new File(ARQUIVO_TEMP);

        try {
            arquivoTemp.createNewFile();

            BufferedWriter bwTemp = Files.newBufferedWriter(
                    PATH_TEMP,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

            for (Medico m : medicos) {
                bwTemp.write(m.getSeparadoPorPontoEVirgula());
                bwTemp.newLine();
            }
            bwTemp.close();
            arquivoAtual.delete();
            arquivoTemp.renameTo(arquivoAtual);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro ao criar o arquivo!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static String[] getEspecialidadesDoMedico(Integer codigo) {

        for (Medico m : medicos) {
            if (m.getCodigo().equals(codigo)) {
                break;
            }
        }
        ArrayList<String> especialidadesDoMedico = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(PATH);

            String linha = br.readLine();

            while (linha != null && !linha.isEmpty()) {

                String[] linhaVetor = linha.split(";");

                if (linhaVetor[6] != null) {
                    String[] especialidades = linhaVetor[6].split("&");

                    especialidadesDoMedico.addAll(Arrays.asList(especialidades));
                } else {
                    especialidadesDoMedico.add("Sem especialidade.");
                }

            }
            br.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro ao abrir o arquivo.",
                    "Erro de leitura",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }
;

}
