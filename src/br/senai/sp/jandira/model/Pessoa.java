
package br.senai.sp.jandira.model;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String telefone;
    private String email;
    private String dataDeNascimento;
    
    public Pessoa(){
        
    }
    public Pessoa(String nome, String telefone, String email, String dataDeNascimento){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    
    public void cumprimentar(){
        System.out.printf("Olá tudo bem? Eu sou %s\n", this.nome);
    }
    
    
    public String getSeparadoPorPontoEVirgula(){
        String  strPessoa = 
                this.nome + ";" +
                this.telefone + ";" +
                 this.email + ";" +
                 this.dataDeNascimento + ";";
        return strPessoa;
    }
    
    
}
