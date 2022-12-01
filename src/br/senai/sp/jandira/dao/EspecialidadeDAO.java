package br.senai.sp.jandira.dao;

import br.senai.sp.jandira.model.Especialidade;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EspecialidadeDAO {
    
    //MEU BANCO DE DADOS
    private static ArrayList<Especialidade> dataBaseEspecialidades = new ArrayList<>();
    
//    private final static String ARQUIVO = "C:\\Users\\22282108\\Documents\\NetBeansProjects\\clinica-java\\src\\br\\senai\\sp\\jandira\\repositorios\\especialidade.txt";
//    private final static Path PATH = Paths.get(ARQUIVO);
//    private final static String ARQUIVO_TEMP = "C:\\Users\\22282108\\Documents\\NetBeansProjects\\clinica-java\\src\\br\\senai\\sp\\jandira\\repositorios\\especialidade_temp.txt";
//    private final static Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);
    
    private final static String ARQUIVO = 
           "/home/felipedeoliveiraflorencio/Documentos/sistema-clinica/src/br/senai/sp/jandira/repositorios/especialidade.txt";
    private final static Path PATH = Paths.get(ARQUIVO);
    private final static String ARQUIVO_TEMP = 
           "/home/felipedeoliveiraflorencio/Documentos/sistema-clinica/src/br/senai/sp/jandira/repositorios/especialidade_temp.txt";
    private final static Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);
    
    //ARQUIVO é o caminho e o PATH é o caminho convertido
    public EspecialidadeDAO() {

    }

    public EspecialidadeDAO(Especialidade especialidade) {
    }

    public static void gravar(Especialidade especialidade) {
        dataBaseEspecialidades.add(especialidade);
        try {
            BufferedWriter bw = Files.newBufferedWriter(
                    PATH,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);
            
            String novaEspecialidade = especialidade.getEspecialidadeSeparadoPorPontoEVirgula();
            bw.write(novaEspecialidade);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro ao gravar.\n\n Entre em contato com o suporte.",
                    "Erro de Gravação",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<Especialidade> listarTodos() {
        return dataBaseEspecialidades;
    }

    public void setEspecialidade(Especialidade especialidade) {
    }

    public static void getListaDeEspecialidades() {
        try {
            
            BufferedReader br = Files.newBufferedReader(PATH);
 
            String linha = br.readLine();
            
            while(linha != null && !linha.isEmpty()){

                String[] linhaVetor = linha.split(";");
                
                Especialidade novaEspecialidade = new Especialidade(
                        Integer.valueOf(linhaVetor[0]),
                         linhaVetor[1],
                         linhaVetor[2]);

                dataBaseEspecialidades.add(novaEspecialidade);
 
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

    public static DefaultTableModel getTableModel() {

        Object[][] dados = new Object[dataBaseEspecialidades.size()][3];

        int i = 0;
        for (Especialidade e : dataBaseEspecialidades) {
            dados[i][0] = e.getCodigo();
            dados[i][1] = e.getNome();
            dados[i][2] = e.getDescricao();
            i++;
        }

        String[] titulos = {"Código", "Nome da Especialidade", "Descrição"};

        DefaultTableModel tableModelEspecialidade = new DefaultTableModel(dados, titulos);

        return tableModelEspecialidade;
    }

    public static boolean excluir(Integer codigo) {

        for (Especialidade e : dataBaseEspecialidades) {
            if (e.getCodigo().equals(codigo)) {
                dataBaseEspecialidades.remove(e);
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
            for (Especialidade e : dataBaseEspecialidades){
                bwTemp.write(e.getEspecialidadeSeparadoPorPontoEVirgula());
                bwTemp.newLine();
            }
            //Fechar o arquivo temporário
            bwTemp.close();
            
            //Excluir o arquivo atual - plano_de_saude.txt
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
        
        return false;
    }
   
     public static ArrayList<String> getListaNomesDeEspecialidades() {
        ArrayList<String> dados = new ArrayList<>();
        for (Especialidade e : dataBaseEspecialidades) {
            dados.add(e.getNome());
        }
         DefaultListModel<String> ListaModel = new DefaultListModel<>();
        
        ListaModel.addAll(dados);
        
        return dados;

        }
    
    public static Especialidade getEspecialidade(Integer codigo) {

        for (Especialidade e : dataBaseEspecialidades) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }

        return null;
    }

    public static void atualizar(Especialidade especialidade) {
        for (Especialidade e : dataBaseEspecialidades) {
            if (e.getCodigo().equals(especialidade.getCodigo())) {
                dataBaseEspecialidades.set(dataBaseEspecialidades.indexOf(e), especialidade);
                break;
            }
        }

    }
//    public static String[] getListaNomeDasEspecialidades(){
//      
//        String[] nomeDasEspecialidades = new String[especialidades.size()];
//        int i = 0;
//        for(Especialidade e : especialidades){
//            if(i < especialidades.size()){
//                String nomeDaEspecialidade = e.getNome();
//                nomeDasEspecialidades[i] = nomeDaEspecialidade;
//                i++;
//                
//            }
//            else{
//                break;
//            }
//       
//        }
//         return nomeDasEspecialidades;
//    }
}
