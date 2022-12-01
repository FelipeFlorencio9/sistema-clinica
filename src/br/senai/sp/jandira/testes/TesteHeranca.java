
package br.senai.sp.jandira.testes;

import br.senai.sp.jandira.model.Gênero;
import br.senai.sp.jandira.model.Medico;
import br.senai.sp.jandira.model.Paciente;
import br.senai.sp.jandira.model.Pessoa;

public class TesteHeranca {
    
    public static void main(String[] args) {
        Medico m = new Medico();
        m.setCrm("aquele lá");
        m.setNome("Fabiano");
                
        Paciente p = new Paciente();
        p.setGenero(Gênero.FEMININO);
        p.setTipoSanguineo("O.a");
        p.setNome("Fabiana");
        
        m.cumprimentar();
        p.cumprimentar(); 
    }
}
