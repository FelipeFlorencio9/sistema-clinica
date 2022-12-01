/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.EspecialidadeDAO;
import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.model.TipoOperacao;

import javax.swing.JOptionPane;
/**
 *
 * @author 22282108
 */
public class DialogEspecialidade extends javax.swing.JDialog {
    
    private TipoOperacao tipoOperacao;
    private Especialidade especialidade;
    
    public DialogEspecialidade(
            java.awt.Frame parent,
            boolean modal,
            TipoOperacao tipoOperacao,
            Especialidade especialidade) {
        super(parent, modal);
        initComponents();
        
        this.tipoOperacao = tipoOperacao;
        this.especialidade = especialidade;
        
        if(tipoOperacao == TipoOperacao.ALTERAR){
            preencherFormulario();
        }
    }
    private void preencherFormulario(){
        textFieldCodigo.setText(especialidade.getCodigo().toString());
        textFieldNomeDaEspecialidade.setText(especialidade.getNome());
        textFieldDescricao.setText(especialidade.getDescricao());
        
        labelHome.setText("Especialidade - " + tipoOperacao);
        labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/editar.png")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelApp = new javax.swing.JPanel();
        labelIcon = new javax.swing.JLabel();
        labelHome = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        labelDescricao = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        labelNomeDaEspecialidade = new javax.swing.JLabel();
        textFieldDescricao = new javax.swing.JTextField();
        textFieldCodigo = new javax.swing.JTextField();
        textFieldNomeDaEspecialidade = new javax.swing.JTextField();
        buttonCancelar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        panelApp.setBackground(new java.awt.Color(255, 255, 255));
        panelApp.setToolTipText("");
        panelApp.setLayout(null);

        labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/add.png"))); // NOI18N
        panelApp.add(labelIcon);
        labelIcon.setBounds(50, 0, 40, 90);

        labelHome.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        labelHome.setForeground(new java.awt.Color(51, 153, 255));
        labelHome.setText("Especialidade - Adicionar");
        panelApp.add(labelHome);
        labelHome.setBounds(110, 20, 510, 60);

        getContentPane().add(panelApp);
        panelApp.setBounds(0, 0, 660, 90);

        panelHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelHome.setLayout(null);

        labelDescricao.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        labelDescricao.setForeground(new java.awt.Color(51, 153, 255));
        labelDescricao.setText("Decrição");
        panelHome.add(labelDescricao);
        labelDescricao.setBounds(60, 220, 250, 30);

        labelCodigo.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        labelCodigo.setForeground(new java.awt.Color(51, 153, 255));
        labelCodigo.setText("Código");
        panelHome.add(labelCodigo);
        labelCodigo.setBounds(60, 40, 250, 30);

        labelNomeDaEspecialidade.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        labelNomeDaEspecialidade.setForeground(new java.awt.Color(51, 153, 255));
        labelNomeDaEspecialidade.setText("Nome da Especialiade");
        panelHome.add(labelNomeDaEspecialidade);
        labelNomeDaEspecialidade.setBounds(60, 130, 270, 30);

        textFieldDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldDescricaoActionPerformed(evt);
            }
        });
        panelHome.add(textFieldDescricao);
        textFieldDescricao.setBounds(70, 250, 240, 30);

        textFieldCodigo.setEditable(false);
        textFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCodigoActionPerformed(evt);
            }
        });
        panelHome.add(textFieldCodigo);
        textFieldCodigo.setBounds(70, 70, 100, 30);

        textFieldNomeDaEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNomeDaEspecialidadeActionPerformed(evt);
            }
        });
        panelHome.add(textFieldNomeDaEspecialidade);
        textFieldNomeDaEspecialidade.setBounds(70, 160, 240, 30);

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

    private void textFieldDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldDescricaoActionPerformed
    }//GEN-LAST:event_textFieldDescricaoActionPerformed

    private void textFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCodigoActionPerformed
    }//GEN-LAST:event_textFieldCodigoActionPerformed

    private void textFieldNomeDaEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNomeDaEspecialidadeActionPerformed
    }//GEN-LAST:event_textFieldNomeDaEspecialidadeActionPerformed

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
        especialidade.setNome(textFieldNomeDaEspecialidade.getText());
        especialidade.setDescricao(textFieldDescricao.getText());
        if(validarCadastro()){
            EspecialidadeDAO.atualizar(especialidade);
            JOptionPane.showMessageDialog(
                null, 
                "Especialidade gravada com sucesso.",
                "Especialidade",
                JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        
    }
   private void gravar(){
        Especialidade novaEspecialidade = new Especialidade();
        novaEspecialidade.setNome(textFieldNomeDaEspecialidade.getText());
        novaEspecialidade.setDescricao(textFieldDescricao.getText());

        if (validarCadastro()) {

            EspecialidadeDAO.gravar(novaEspecialidade);

            JOptionPane.showMessageDialog(
                    this,
                    "Plano de Saúde gravado com sucesso",
                    "Plano De Saúde",
                    JOptionPane.INFORMATION_MESSAGE);

            dispose();
        }
    
   }
    
    private boolean validarCadastro() {
        if (textFieldNomeDaEspecialidade.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha o nome da especialidade.",
                    "Especialidade",
                    JOptionPane.ERROR_MESSAGE);

            textFieldNomeDaEspecialidade.requestFocus();
            return false;

        } else if (textFieldDescricao.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha a descrição.",
                    "Especialidade",
                    JOptionPane.ERROR_MESSAGE);

            textFieldDescricao.requestFocus();
            return false;

        } else if (textFieldNomeDaEspecialidade.getText().isEmpty() && textFieldDescricao.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha todos os dados.",
                    "Especialidade",
                    JOptionPane.ERROR_MESSAGE);

            textFieldNomeDaEspecialidade.requestFocus();
            return false;
        }
        return true;

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelHome;
    private javax.swing.JLabel labelIcon;
    private javax.swing.JLabel labelNomeDaEspecialidade;
    private javax.swing.JPanel panelApp;
    private javax.swing.JPanel panelHome;
    private javax.swing.JTextField textFieldCodigo;
    private javax.swing.JTextField textFieldDescricao;
    private javax.swing.JTextField textFieldNomeDaEspecialidade;
    // End of variables declaration//GEN-END:variables
}
