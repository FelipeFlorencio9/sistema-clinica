package br.senai.sp.jandira.model;

public class Especialidade {

    private static int contador = 0;
    private Integer codigo;
    private String nome;
    private String descricao;

    public Especialidade() {
        atualizarCodigo();
    }

    public Especialidade(String nome) {
        this.nome = nome;
        atualizarCodigo();
    }

    public Especialidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        atualizarCodigo();
    }
    public Especialidade (Integer codigo,String nome, String descricao){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.contador = this.codigo++;
    }

    private void atualizarCodigo() {
        this.codigo = contador;
        contador++;
    }
    //Métodos de acesso getters e setters

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }
    
    public String getEspecialidadeSeparadoPorPontoEVirgula(){
        return this.codigo + ";" + this.nome + ";" + this.descricao;
    }
    public String getEspecialidadeComCodigoENome(){
         return this.codigo + " - " + this.nome;
    }

}
