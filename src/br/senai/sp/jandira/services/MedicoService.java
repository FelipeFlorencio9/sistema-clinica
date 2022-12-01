
package br.senai.sp.jandira.services;

import br.senai.sp.jandira.dao.MedicoDAO;
import br.senai.sp.jandira.model.Medico;

public class MedicoService {
 
    private MedicoDAO dao;
    
    public MedicoService() {
          this.dao = new MedicoDAO();
      }
    
//    public void salvar(Medico medico) {
//          dao.salvar(medico);
//      }
}
