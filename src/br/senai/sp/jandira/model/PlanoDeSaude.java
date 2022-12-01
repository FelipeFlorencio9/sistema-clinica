package br.senai.sp.jandira.model;

import java.time.LocalDate;

public class PlanoDeSaude {

    private static int contador = 100;
    private Integer codigo;
    private String operadora;
    private String tipoDoPlano;
//    private LocalDate validade;

    // Métodos de acesso
    // Contrutores da classe
    public PlanoDeSaude() {
        atualizarCodigo();

    }

    public PlanoDeSaude(String operadora) {
        this.operadora = operadora;
        atualizarCodigo();
    }

    public PlanoDeSaude(String operadora, String tipoDoPlano) {
        this.operadora = operadora;
        this.tipoDoPlano = tipoDoPlano;
        atualizarCodigo();

    }
    public PlanoDeSaude(Integer codigo, String operadora, String tipoDoPlano){
        this.codigo = codigo;
        this.operadora = operadora;
        this.tipoDoPlano = tipoDoPlano;
        PlanoDeSaude.contador = this.codigo++;
    }

    private void atualizarCodigo() {
        contador++;
        this.codigo = contador;
    }

    // Metodos de acesso
    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getOperadora() {
        return this.operadora;
    }

    public void setTipoDoPlano(String tipoDoPlano) {
        this.tipoDoPlano = tipoDoPlano;
    }

    public String getTipoDoPlano() {
        return this.tipoDoPlano;
    }

    public String getDadosDoPlano() {
        return "Plano: " + this.operadora + ", " + this.tipoDoPlano;

    }

    public Integer getCodigo() {
        return codigo;
    }
    
    public String getPlanoDeSaudeSeparadoPorPontoEVirgula(){
        String planoDeSaudeStr = this.codigo + ";" + this.operadora + ";" + this.tipoDoPlano;
        return planoDeSaudeStr;
    }

//    public LocalDate getValidade() {
//        return validade;
//    }
//
//    public void setValidade(LocalDate validade) {
//        this.validade = validade;
//    }
    
}
