/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.PlanoDeSaudeDAO;
import br.senai.sp.jandira.model.PlanoDeSaude;
import br.senai.sp.jandira.model.TipoOperacao;
import javax.swing.JOptionPane;

public class DialogPlanosDeSaude extends javax.swing.JDialog {

    private TipoOperacao tipoOperacao;
    private PlanoDeSaude planoDeSaude;

    public DialogPlanosDeSaude(
            java.awt.Frame parent,
            boolean modal,
            TipoOperacao tipoOperacao,
            PlanoDeSaude planoDeSaude) {
        super(parent, modal);
        initComponents();
        this.tipoOperacao = tipoOperacao;
        this.planoDeSaude = planoDeSaude;
        
        //Preencher os campos , caso o tipo de operação for ALTERAR
        if(tipoOperacao == TipoOperacao.ALTERAR){
            preencherFormulario();
        }
    }
    private void preencherFormulario(){
        textFieldCodigo.setText(planoDeSaude.getCodigo().toString());
        textFieldTipoDaOperadora.setText(planoDeSaude.getOperadora());
        textFieldTipoDoPlano.setText(planoDeSaude.getTipoDoPlano());
        labelHome.setText("Planos de Saúde - " + tipoOperacao);
        labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/editar.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelApp = new javax.swing.JPanel();
        labelIcon = new javax.swing.JLabel();
        labelHome = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        labelTipoDoPlano = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        labelTipoDaOperadora = new javax.swing.JLabel();
        textFieldTipoDoPlano = new javax.swing.JTextField();
        textFieldCodigo = new javax.swing.JTextField();
        textFieldTipoDaOperadora = new javax.swing.JTextField();
        buttonCancelar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        panelApp.setBackground(new java.awt.Color(255, 255, 255));
        panelApp.setToolTipText("");
        panelApp.setLayout(null);

        labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/add.png"))); // NOI18N
        panelApp.add(labelIcon);
        labelIcon.setBounds(50, 0, 40, 90);

        labelHome.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        labelHome.setForeground(new java.awt.Color(51, 153, 255));
        labelHome.setText("Planos de Saúde - Adicionar");
        panelApp.add(labelHome);
        labelHome.setBounds(110, 20, 510, 60);

        getContentPane().add(panelApp);
        panelApp.setBounds(0, 0, 660, 90);

        panelHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelHome.setLayout(null);

        labelTipoDoPlano.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        labelTipoDoPlano.setForeground(new java.awt.Color(51, 153, 255));
        labelTipoDoPlano.setText("Tipo do plano");
        panelHome.add(labelTipoDoPlano);
        labelTipoDoPlano.setBounds(60, 220, 250, 30);

        labelCodigo.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        labelCodigo.setForeground(new java.awt.Color(51, 153, 255));
        labelCodigo.setText("Código");
        panelHome.add(labelCodigo);
        labelCodigo.setBounds(60, 40, 250, 30);

        labelTipoDaOperadora.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        labelTipoDaOperadora.setForeground(new java.awt.Color(51, 153, 255));
        labelTipoDaOperadora.setText("Tipo da operadora");
        panelHome.add(labelTipoDaOperadora);
        labelTipoDaOperadora.setBounds(60, 130, 250, 30);

        textFieldTipoDoPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTipoDoPlanoActionPerformed(evt);
            }
        });
        panelHome.add(textFieldTipoDoPlano);
        textFieldTipoDoPlano.setBounds(70, 250, 240, 30);

        textFieldCodigo.setEditable(false);
        textFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCodigoActionPerformed(evt);
            }
        });
        panelHome.add(textFieldCodigo);
        textFieldCodigo.setBounds(70, 70, 100, 30);

        textFieldTipoDaOperadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTipoDaOperadoraActionPerformed(evt);
            }
        });
        panelHome.add(textFieldTipoDaOperadora);
        textFieldTipoDaOperadora.setBounds(70, 160, 240, 30);

        buttonCancelar.setBackground(new java.awt.Color(153, 204, 255));
        buttonCancelar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/saida.png"))); // NOI18N
        buttonCancelar.setText("Voltar");
        buttonCancelar.setToolTipText("Voltar á tela anterior.");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        panelHome.add(buttonCancelar);
        buttonCancelar.setBounds(470, 330, 130, 45);

        buttonSalvar.setBackground(new java.awt.Color(153, 204, 255));
        buttonSalvar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/pasta.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.setToolTipText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        panelHome.add(buttonSalvar);
        buttonSalvar.setBounds(340, 330, 120, 45);

        getContentPane().add(panelHome);
        panelHome.setBounds(20, 100, 620, 390);

        setBounds(0, 0, 678, 558);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldTipoDoPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTipoDoPlanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTipoDoPlanoActionPerformed

    private void textFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCodigoActionPerformed

    private void textFieldTipoDaOperadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTipoDaOperadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTipoDaOperadoraActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        if (tipoOperacao == TipoOperacao.ADICIONAR){
            gravar();
        } else {
            atualizar();
        }

    }//GEN-LAST:event_buttonSalvarActionPerformed
    private void atualizar(){
        planoDeSaude.setOperadora(textFieldTipoDaOperadora.getText());
        planoDeSaude.setTipoDoPlano(textFieldTipoDoPlano.getText());
        if(validarCadastro()){
            PlanoDeSaudeDAO.atualizar(planoDeSaude);
            JOptionPane.showMessageDialog(
                null, 
                "Plano de Saúde atualizado com sucesso.",
                "Plano de Saúde",
                JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        
    }
    
    private void gravar(){
    PlanoDeSaude planoDeSaude = new PlanoDeSaude();
        planoDeSaude.setOperadora(textFieldTipoDaOperadora.getText());
        planoDeSaude.setTipoDoPlano(textFieldTipoDoPlano.getText());

        if (validarCadastro()) {

            PlanoDeSaudeDAO.inserirPlanoDeSaude(planoDeSaude);

            JOptionPane.showMessageDialog(
                    this,
                    "Plano de Saúde gravado com sucesso",
                    "Plano De Saúde",
                    JOptionPane.INFORMATION_MESSAGE);

            dispose();
        }
}
    private boolean validarCadastro() {
        if (textFieldTipoDaOperadora.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha o nome da operadora.",
                    "Plano de Saúde",
                    JOptionPane.ERROR_MESSAGE);

            textFieldTipoDaOperadora.requestFocus();
            return false;

        } else if (textFieldTipoDoPlano.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha o tipo do plano.",
                    "Plano de Saúde",
                    JOptionPane.ERROR_MESSAGE);

            textFieldTipoDoPlano.requestFocus();
            return false;

        } else if (textFieldTipoDaOperadora.getText().isEmpty() && textFieldTipoDoPlano.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha todos os dados.",
                    "Plano de Saúde",
                    JOptionPane.ERROR_MESSAGE);

            textFieldTipoDaOperadora.requestFocus();
            return false;
        }
        return true;

    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelHome;
    private javax.swing.JLabel labelIcon;
    private javax.swing.JLabel labelTipoDaOperadora;
    private javax.swing.JLabel labelTipoDoPlano;
    private javax.swing.JPanel panelApp;
    private javax.swing.JPanel panelHome;
    private javax.swing.JTextField textFieldCodigo;
    private javax.swing.JTextField textFieldTipoDaOperadora;
    private javax.swing.JTextField textFieldTipoDoPlano;
    // End of variables declaration//GEN-END:variables
}
