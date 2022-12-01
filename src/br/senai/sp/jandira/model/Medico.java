package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;

public class Medico extends Pessoa {

    private static int contador = 000;
    private Integer codigo;
    private String crm;
    private ArrayList<Especialidade> especialidades;
   

    public Medico() {
        atualizarCodigo();
    }

    public Medico(Integer codigo, String crm) {
        this.codigo = codigo;
        this.crm = crm;

    }

    public Medico(
            Integer codigo,
            String crm,
            String nome,
            String telefone,
            String email,
            String dataDeNascimento,
            ArrayList<Especialidade> especialidades) {

        super(nome, telefone, email, dataDeNascimento);
        this.codigo = codigo;
        this.crm = crm;
        this.especialidades = especialidades;
        super.setNome(nome);
        super.setTelefone(telefone);
        super.setEmail(email);
        super.setDataDeNascimento(dataDeNascimento);
        
       
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public ArrayList<Especialidade> getEspecialidades() {
        return especialidades;
    }
    
    public ArrayList<String> getEspecialidadesPorNome(){
        ArrayList<String> especialidades = new ArrayList<>();
        int i = 0;
        while(i <= especialidades.size()){
            Especialidade e = this.especialidades.get(i);
            especialidades.add(e.getNome());
        }
        return especialidades;
    }    
    public void setEspecialidades(ArrayList<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public void cumprimentar() {
        System.out.printf("Olá, eu sou o Médico %s, tudo bem?\n", super.getNome());
    }

    public String getStringMedicoForPanel() {
        String medicoStr = this.codigo + ";" + this.crm + ";" + this.especialidades;
        return medicoStr;
    }

    private void atualizarCodigo() {
        contador++;
        this.codigo = contador;
    }
    
     public String getInformacoesMedicoComPontoVirgula() {
        String codigoEspecialidades = "";
        for(Especialidade e : especialidades){    
        codigoEspecialidades += e.getCodigo() + ";";
        }
    
        return this.codigo + ";" + this.crm + ";" + getNome() + ";" + getTelefone() + ";" + getEmail() + ";" + getDataDeNascimento() + ";" + codigoEspecialidades ;
    
}
//    public ArrayList<Especialidade> getListaDeEspecialidadesDoMedico() {
////        ArrayList<Especialidade> dados = new ArrayList<>();
////        for (Especialidade e : especialidades) {
////            dados.add(e.getNome());
////        }
////        DefaultListModel<String> ListaModel = new DefaultListModel<>();
////        
////        ListaModel.addAll(dados);
////        
////        return dados;
////
////    
//    }
}
