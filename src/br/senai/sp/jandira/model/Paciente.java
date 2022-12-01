package br.senai.sp.jandira.model;

public class Paciente extends Pessoa {

    private Gênero genero;
    private String tipoSanguineo;
    private PlanoDeSaude planoDeSaude;

    public Paciente() {

    }

    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }
    

    public Gênero getGenero() {
        return genero;
    }

    public void setGenero(Gênero genero) {
        this.genero = genero;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

}
