package br.senai.sp.jandira;

import br.senai.sp.jandira.dao.EspecialidadeDAO;
import br.senai.sp.jandira.view.HomeFrame;

public class ClinicaApp {
    
    public static void main(String[] args) {
        HomeFrame home = new HomeFrame();
        home.setResizable(false);
        home.setVisible(true);
    }
    
}
