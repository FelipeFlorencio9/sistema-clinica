package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.EspecialidadeDAO;
import br.senai.sp.jandira.dao.MedicoDAO;
import br.senai.sp.jandira.dao.PlanoDeSaudeDAO;
import br.senai.sp.jandira.model.Medico;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HomeFrame extends javax.swing.JFrame {

    //Atributos da classe
    PanelPlanosDeSaude panelPlanosDeSaude;
    PanelEspecialidade panelEspecialidade;
    PanelMedico panelMedico;
    private JButton lastButton = null;
    private JButton previousButton = null;
//  private JPanel lastPanel;
    private JPanel previousPanel = null;

    //Constantes da classe
    private final int X_POSITION = 20;
    private final int Y_POSITION = 170;
    private final int LARGE = 900;
    private final int ALTURA = 410;

    //Cores 
    java.awt.Color corPadrao = new java.awt.Color(153, 204, 255);
    java.awt.Color corDeSelecao = new java.awt.Color(153, 255, 153);

    public HomeFrame() {
        initComponents();
        initModelTables();
        initPanels();
        passHomeToDefault();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelApp = new javax.swing.JPanel();
        labelIcon = new javax.swing.JLabel();
        labelHome = new javax.swing.JLabel();
        panelFunctions = new javax.swing.JPanel();
        buttonSaida = new javax.swing.JButton();
        buttonMedicos = new javax.swing.JButton();
        buttonPacientes = new javax.swing.JButton();
        buttonAgenda = new javax.swing.JButton();
        buttonPlanosDeSaude1 = new javax.swing.JButton();
        buttonHome = new javax.swing.JButton();
        buttonEspecialidade1 = new javax.swing.JButton();
        panelHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panelApp.setBackground(new java.awt.Color(255, 255, 255));
        panelApp.setToolTipText("");
        panelApp.setLayout(null);

        labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/notebook (1).png"))); // NOI18N
        panelApp.add(labelIcon);
        labelIcon.setBounds(100, 0, 40, 90);

        labelHome.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        labelHome.setForeground(new java.awt.Color(51, 153, 255));
        labelHome.setText("Sistema para Agendamento de Consultas");
        panelApp.add(labelHome);
        labelHome.setBounds(180, 20, 730, 60);

        getContentPane().add(panelApp);
        panelApp.setBounds(0, 0, 940, 90);

        panelFunctions.setLayout(null);

        buttonSaida.setBackground(new java.awt.Color(153, 204, 255));
        buttonSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/saida.png"))); // NOI18N
        buttonSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaidaActionPerformed(evt);
            }
        });
        panelFunctions.add(buttonSaida);
        buttonSaida.setBounds(870, 10, 60, 45);

        buttonMedicos.setBackground(new java.awt.Color(153, 204, 255));
        buttonMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/medico.png"))); // NOI18N
        buttonMedicos.setText("Médicos");
        buttonMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMedicosActionPerformed(evt);
            }
        });
        panelFunctions.add(buttonMedicos);
        buttonMedicos.setBounds(350, 10, 140, 45);

        buttonPacientes.setBackground(new java.awt.Color(153, 204, 255));
        buttonPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/lista.png"))); // NOI18N
        buttonPacientes.setText("Pacientes");
        buttonPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPacientesActionPerformed(evt);
            }
        });
        panelFunctions.add(buttonPacientes);
        buttonPacientes.setBounds(210, 10, 130, 45);

        buttonAgenda.setBackground(new java.awt.Color(153, 204, 255));
        buttonAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/notebook (1).png"))); // NOI18N
        buttonAgenda.setText("Agenda");
        buttonAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgendaActionPerformed(evt);
            }
        });
        panelFunctions.add(buttonAgenda);
        buttonAgenda.setBounds(80, 10, 120, 45);

        buttonPlanosDeSaude1.setBackground(new java.awt.Color(153, 204, 255));
        buttonPlanosDeSaude1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/listaPlanos.png"))); // NOI18N
        buttonPlanosDeSaude1.setText("Planos de Saúde");
        buttonPlanosDeSaude1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlanosDeSaude1ActionPerformed(evt);
            }
        });
        panelFunctions.add(buttonPlanosDeSaude1);
        buttonPlanosDeSaude1.setBounds(680, 10, 180, 45);

        buttonHome.setBackground(new java.awt.Color(153, 204, 255));
        buttonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/botao-home.png"))); // NOI18N
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });
        panelFunctions.add(buttonHome);
        buttonHome.setBounds(10, 10, 60, 45);

        buttonEspecialidade1.setBackground(new java.awt.Color(153, 204, 255));
        buttonEspecialidade1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/lista.png"))); // NOI18N
        buttonEspecialidade1.setText("Especialidade");
        buttonEspecialidade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEspecialidade1ActionPerformed(evt);
            }
        });
        panelFunctions.add(buttonEspecialidade1);
        buttonEspecialidade1.setBounds(500, 10, 170, 45);

        getContentPane().add(panelFunctions);
        panelFunctions.setBounds(0, 100, 940, 70);

        panelHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelHome.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("Contato");
        panelHome.add(jLabel1);
        jLabel1.setBounds(40, 190, 250, 30);

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("Site: www.sisacon.com.br");
        panelHome.add(jLabel2);
        jLabel2.setBounds(40, 270, 400, 20);

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("SISACON");
        panelHome.add(jLabel3);
        jLabel3.setBounds(40, 50, 250, 60);

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel4.setText("Sistema para Agendamento de Consultas");
        panelHome.add(jLabel4);
        jLabel4.setBounds(40, 110, 400, 26);

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel5.setText("Email: maisasilva@gmail.com");
        panelHome.add(jLabel5);
        jLabel5.setBounds(40, 220, 400, 20);

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel6.setText("Telefone: (11) 4002-8922");
        panelHome.add(jLabel6);
        jLabel6.setBounds(40, 242, 400, 20);

        getContentPane().add(panelHome);
        panelHome.setBounds(20, 170, 900, 410);

        setBounds(0, 0, 956, 633);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaidaActionPerformed
        previousButton.setBackground(corPadrao);
        buttonSaida.setBackground(corDeSelecao);
        int confirmacaoDeSaida
                = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja encerrar a aplicação?",
                        "Saída",
                        JOptionPane.YES_OPTION,
                        JOptionPane.YES_OPTION);
        if (confirmacaoDeSaida == 0) {
            dispose();
        } else {
            buttonSaida.setBackground(corPadrao);
            previousButton.setBackground(corDeSelecao);
        }
    }//GEN-LAST:event_buttonSaidaActionPerformed

    private void buttonMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMedicosActionPerformed
        trocarCorDosBotoes(evt);
        previousPanel.setVisible(false);
        panelMedico.setVisible(true);
        previousPanel = panelMedico;
    }//GEN-LAST:event_buttonMedicosActionPerformed

    private void buttonPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPacientesActionPerformed

    }//GEN-LAST:event_buttonPacientesActionPerformed

    private void buttonAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgendaActionPerformed

    }//GEN-LAST:event_buttonAgendaActionPerformed

    private void buttonPlanosDeSaude1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlanosDeSaude1ActionPerformed
        trocarCorDosBotoes(evt);
        previousPanel.setVisible(false);
        panelPlanosDeSaude.setVisible(true);
        previousPanel = panelPlanosDeSaude;
    }//GEN-LAST:event_buttonPlanosDeSaude1ActionPerformed

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        trocarCorDosBotoes(evt);
        previousPanel.setVisible(false);
        panelHome.setVisible(true);
        previousPanel = panelHome;
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonEspecialidade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEspecialidade1ActionPerformed
        trocarCorDosBotoes(evt);
        previousPanel.setVisible(false);
        panelEspecialidade.setVisible(true);
        previousPanel = panelEspecialidade;
    }//GEN-LAST:event_buttonEspecialidade1ActionPerformed
    
    private void initModelTables() {
        PlanoDeSaudeDAO.getListaPlanosDeSaude();
        EspecialidadeDAO.getListaDeEspecialidades();
        MedicoDAO.getListaDeMedicosNoArquivo();
    }

    private void passHomeToDefault() {
        buttonHome.setBackground(corDeSelecao);
        previousPanel = panelHome;
        previousButton = buttonHome;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgenda;
    private javax.swing.JButton buttonEspecialidade1;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonMedicos;
    private javax.swing.JButton buttonPacientes;
    private javax.swing.JButton buttonPlanosDeSaude1;
    private javax.swing.JButton buttonSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelHome;
    private javax.swing.JLabel labelIcon;
    private javax.swing.JPanel panelApp;
    private javax.swing.JPanel panelFunctions;
    private javax.swing.JPanel panelHome;
    // End of variables declaration//GEN-END:variables

    private void initPanels() {
        panelHome.setBounds(
                X_POSITION,
                Y_POSITION,
                LARGE,
                ALTURA);
        getContentPane().add(panelHome);
        panelHome.setVisible(true);

        panelPlanosDeSaude = new PanelPlanosDeSaude();
        panelPlanosDeSaude.setBounds(
                X_POSITION,
                Y_POSITION,
                LARGE,
                ALTURA);
        getContentPane().add(panelPlanosDeSaude);
        panelPlanosDeSaude.setVisible(false);

        panelEspecialidade = new PanelEspecialidade();
        panelEspecialidade.setBounds(
                X_POSITION,
                Y_POSITION,
                LARGE,
                ALTURA);
        getContentPane().add(panelEspecialidade);
        panelEspecialidade.setVisible(false);
        panelMedico = new PanelMedico();
        panelMedico.setBounds(
                X_POSITION,
                Y_POSITION,
                LARGE,
                ALTURA);
        getContentPane().add(panelMedico);
        panelMedico.setVisible(false);
    }

    public void trocarCorDosBotoes(ActionEvent evt) {
        previousButton.setBackground(corPadrao);
        lastButton = (JButton) evt.getSource();
        lastButton.setBackground(corDeSelecao);
        previousButton = lastButton;
    }

}

//  Outro método para o button PlanoDeSaude(){
//      ocultarTodosOsPaineis();
//      pintarBotoesParaCorPadrao();
//      panelPlanosDeSaude.setVisible(true);
//      buttonPlanosDeSaude1.setBackground(corDeSelecao);
//  }
//  Possível método futuro para "troca"DePainel"(){
//      lastPanel = algumaCoisa.pegarUltimoPanelExibido;
//      lastPanel.setVisible(false);
//      previousPanel = panelPlanosDeSaude;
//  }
