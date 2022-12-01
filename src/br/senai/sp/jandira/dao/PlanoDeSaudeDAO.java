package br.senai.sp.jandira.dao;

import java.util.ArrayList;
import br.senai.sp.jandira.model.PlanoDeSaude;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PlanoDeSaudeDAO { //simular nosso banco de dados
    //MEU BANCO DE DADOS
    private static ArrayList<PlanoDeSaude> dataBasePlanosDeSaude = new ArrayList<>();

    //CAMINHOS
    
    //WINDOWNS
//    private static final String ARQUIVO = "C:\\Users\\22282108\\Documents\\NetBeansProjects\\clinica-java\\src\\br\\senai\\sp\\jandira\\repositorios\\plano_de_saude.txt";
//    private static final String ARQUIVO_TEMP = "C:\\Users\\22282108\\Documents\\NetBeansProjects\\clinica-java\\src\\br\\senai\\sp\\jandira\\repositorios\\plano_de_saude_temp.txt";
//    private static final Path PATH = Paths.get(ARQUIVO);
//    private static final Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);
    
    private static final String ARQUIVO = "/home/felipedeoliveiraflorencio/Documentos/sistema-clinica/src/br/senai/sp/jandira/repositorios/plano_de_saude.txt";
    private static final String ARQUIVO_TEMP = "/home/felipedeoliveiraflorencio/Documentos/sistema-clinica/src/br/senai/sp/jandira/repositorios/plano_de_saude_temp.txt";
    private static final Path PATH = Paths.get(ARQUIVO);
    private static final Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);

    //Construtor
    public PlanoDeSaudeDAO() {

    }

    public PlanoDeSaudeDAO(PlanoDeSaude planoDeSaude) {
    }

    public static void inserirPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        dataBasePlanosDeSaude.add(planoDeSaude);
    
        //Gravar plano de saúde no arquivo
        
        try {
            BufferedWriter bw = Files.newBufferedWriter(
                    PATH,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

            String novoPlanoDeSaude = planoDeSaude.getPlanoDeSaudeSeparadoPorPontoEVirgula() ;
            
            bw.write(novoPlanoDeSaude);
            bw.newLine();
            bw.close();

        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(
                    null,
                    "Houve um problema ao tentar abrir o arquivo.",
                    "Erro ao gravar.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public static ArrayList<PlanoDeSaude> listarTodos() {
        return dataBasePlanosDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
    }

    public static void getListaPlanosDeSaude() {
        try {
            //Abrir o arquivo para leitura
            BufferedReader br = Files.newBufferedReader(PATH);

            //Ler a linha inteira 
            String linha = br.readLine();
            
            //Fazer um loop com mais de uma linha. O while
            // A linha é diferença de null?
            while(linha != null && !linha.isEmpty()){
                //linha vetor representa os espaços do objeto contidos no vetor
                String[] linhaVetor = linha.split(";");
                
                //Adicionar um objeto apartir de um construtor com todos os atributos, convertendo se necessário de String para o tipo necessário.
                PlanoDeSaude novoPlanoDeSaude = new PlanoDeSaude(
                        Integer.valueOf(linhaVetor[0]),
                         linhaVetor[1],
                         linhaVetor[2]);
                //Adiciona novo plano da lista de exibição
                dataBasePlanosDeSaude.add(novoPlanoDeSaude);
                //Ler a próxima linha
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
        //Matriz que receberá os planos de saúde que serão utilizados na Tabela JTable
        Object[][] dados = new Object[dataBasePlanosDeSaude.size()][3];

        //For Each para extrair cada objeto plano de saúde do array list planos e separar cada dado na matriz dados;
        int i = 0;
        for (PlanoDeSaude p : dataBasePlanosDeSaude) {
            dados[i][0] = p.getCodigo();
            dados[i][1] = p.getOperadora();
            dados[i][2] = p.getTipoDoPlano();
//                dados[i][3] = p.getValidade();
            i++;
        }
        
        // Definir um nome com as colunas da tabela
        String[] titulos = {"Código", "Nome da operadora", "Tipo do plano"};

        //Criar o modelo que será utilizado pela JTable
        //para exibir os dados dos planos
        DefaultTableModel tableModel = new DefaultTableModel(dados, titulos);

        return tableModel;
    }

    public static boolean excluir(Integer codigo) {

        for (PlanoDeSaude p : dataBasePlanosDeSaude) {
            if (p.getCodigo().equals(codigo)) {
                dataBasePlanosDeSaude.remove(p);
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
            for (PlanoDeSaude p :dataBasePlanosDeSaude){
                bwTemp.write(p.getPlanoDeSaudeSeparadoPorPontoEVirgula());
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

    public static PlanoDeSaude getPlanoDeSaude(Integer codigo) {

        for (PlanoDeSaude p : dataBasePlanosDeSaude) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }

        return null;
    }

    public static void atualizar(PlanoDeSaude planoDeSaude) {
        for (PlanoDeSaude p : dataBasePlanosDeSaude) {
            if (p.getCodigo().equals(planoDeSaude.getCodigo())) {
                dataBasePlanosDeSaude.set(dataBasePlanosDeSaude.indexOf(p), planoDeSaude);
                break;
            }
            atualizarArquivo();
        }
        
    }
    
    public static void  atualizarArquivo(){
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
            for (PlanoDeSaude p :dataBasePlanosDeSaude){
                bwTemp.write(p.getPlanoDeSaudeSeparadoPorPontoEVirgula());
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
        
        
    }

}
