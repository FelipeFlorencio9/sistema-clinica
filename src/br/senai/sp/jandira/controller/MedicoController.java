package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.services.MedicoService;
import br.senai.sp.jandira.model.Medico;
import br.senai.sp.jandira.model.Medico;
import br.senai.sp.jandira.model.TipoOperacao;
import br.senai.sp.jandira.view.DialogMedicos;

public class MedicoController implements IController {

    private Medico medico;
    private DialogMedicos dialog;

    public void executa(Object view) {
        dialog = (DialogMedicos) view;
        medico = new Medico();
        medico.setCrm(dialog.getTextFieldCRM());
        medico.setNome(dialog.getTextFieldCRM());
        medico.setTelefone(dialog.getTextFieldTelefone());
        medico.setDataDeNascimento(dialog.getTextFieldDataDeNascimento());
        medico.setEspecialidades(dialog.getEspecialidadesSelecionadas());
                
    }
}
