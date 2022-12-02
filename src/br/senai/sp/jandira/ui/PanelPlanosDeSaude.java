/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.PlanoDeSaudeDAO;
import br.senai.sp.jandira.model.PlanoDeSaude;
import br.senai.sp.jandira.model.TipoOperacao;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author 22282108
 */
public class PanelPlanosDeSaude extends javax.swing.JPanel {

    int linha;

    public PanelPlanosDeSaude() {
        initComponents();
        criarTabelaPlanosDeSaude();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTable = new javax.swing.JScrollPane();
        tablePlanosDeSaude = new javax.swing.JTable();
        buttonEditarPlanoDeSaude = new javax.swing.JButton();
        buttonDeletarPlanoDeSaude = new javax.swing.JButton();
        buttonAdicionarPlanoDeSaude = new javax.swing.JButton();
        labelTableNome = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(900, 410));
        setLayout(null);

        tablePlanosDeSaude.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollTable.setViewportView(tablePlanosDeSaude);

        add(scrollTable);
        scrollTable.setBounds(20, 40, 870, 280);

        buttonEditarPlanoDeSaude.setBackground(new java.awt.Color(153, 204, 255));
        buttonEditarPlanoDeSaude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/editar.png"))); // NOI18N
        buttonEditarPlanoDeSaude.setToolTipText("Editar plano de saúde selecionado.");
        buttonEditarPlanoDeSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarPlanoDeSaudeActionPerformed(evt);
            }
        });
        add(buttonEditarPlanoDeSaude);
        buttonEditarPlanoDeSaude.setBounds(730, 340, 70, 50);

        buttonDeletarPlanoDeSaude.setBackground(new java.awt.Color(153, 204, 255));
        buttonDeletarPlanoDeSaude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/delete.png"))); // NOI18N
        buttonDeletarPlanoDeSaude.setToolTipText("Excluir plano de saúde selecionado.");
        buttonDeletarPlanoDeSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarPlanoDeSaudeActionPerformed(evt);
            }
        });
        add(buttonDeletarPlanoDeSaude);
        buttonDeletarPlanoDeSaude.setBounds(650, 340, 70, 50);

        buttonAdicionarPlanoDeSaude.setBackground(new java.awt.Color(153, 204, 255));
        buttonAdicionarPlanoDeSaude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/add.png"))); // NOI18N
        buttonAdicionarPlanoDeSaude.setToolTipText("Adicionar novo plano de saúde");
        buttonAdicionarPlanoDeSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarPlanoDeSaudeActionPerformed(evt);
            }
        });
        add(buttonAdicionarPlanoDeSaude);
        buttonAdicionarPlanoDeSaude.setBounds(810, 340, 70, 50);

        labelTableNome.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        labelTableNome.setText("Plano de Saúde");
        add(labelTableNome);
        labelTableNome.setBounds(40, 0, 210, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditarPlanoDeSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarPlanoDeSaudeActionPerformed
        
        linha = tablePlanosDeSaude.getSelectedRow();
        
        if (linha != -1){
             editar();
        } else{
            JOptionPane.showMessageDialog(
                    this, 
                    "Por favor, selecione um plano de saúde para alterar.",
                    "Planos de Saúde",
                    JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_buttonEditarPlanoDeSaudeActionPerformed
    private void editar(){
        PlanoDeSaude planoDeSaude = PlanoDeSaudeDAO.getPlanoDeSaude(getCodigo());
        
        DialogPlanosDeSaude planosDeSaudeDialog = 
                new DialogPlanosDeSaude(
                        null, 
                        true,
                        TipoOperacao.ALTERAR, 
                        planoDeSaude);
        
        planosDeSaudeDialog.setVisible(true);
        criarTabelaPlanosDeSaude();
        
    }
    private void buttonDeletarPlanoDeSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarPlanoDeSaudeActionPerformed
        //Obtemos o indice da linha selecionada na tabela
        linha = tablePlanosDeSaude.getSelectedRow();

        //Verificamos se a linha é diferente de -1
        //-1 significa que o usuário não selecionou nada
        if (linha != -1) {
            excluir();
        } else {
            JOptionPane.showConfirmDialog(
                    this,
                    "Por favor, selecione o plano que você deseja excluir!",
                    "Plano de saúde",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonDeletarPlanoDeSaudeActionPerformed
    private void excluir() {
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Você tem certeza que quer excluir o item selecionado?",
                "Plano de saude",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        System.out.println(resposta);
        
        if (resposta == 0) {
            PlanoDeSaudeDAO.excluir(getCodigo());
            criarTabelaPlanosDeSaude();
        }
        
        
    }
    private Integer getCodigo(){
            String codigoStr = tablePlanosDeSaude.getValueAt(linha, 0).toString();
            return Integer.valueOf(codigoStr);
    }
        
    private void buttonAdicionarPlanoDeSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarPlanoDeSaudeActionPerformed
        
        DialogPlanosDeSaude dialogPlanosDeSaude = 
                new DialogPlanosDeSaude(null, true, TipoOperacao.ADICIONAR, null);
        
        dialogPlanosDeSaude.setVisible(true);
        
        criarTabelaPlanosDeSaude();
    }//GEN-LAST:event_buttonAdicionarPlanoDeSaudeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarPlanoDeSaude;
    private javax.swing.JButton buttonDeletarPlanoDeSaude;
    private javax.swing.JButton buttonEditarPlanoDeSaude;
    private javax.swing.JLabel labelTableNome;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tablePlanosDeSaude;
    // End of variables declaration//GEN-END:variables

    private void criarTabelaPlanosDeSaude() {
        tablePlanosDeSaude.setModel(PlanoDeSaudeDAO.getTableModel());

        //Desativar o redimensionamento da JTable
        tablePlanosDeSaude.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        //Definir a largua de cada coluna
        tablePlanosDeSaude.getColumnModel().getColumn(0).setPreferredWidth(100);
        tablePlanosDeSaude.getColumnModel().getColumn(1).setPreferredWidth(300);
        tablePlanosDeSaude.getColumnModel().getColumn(2).setPreferredWidth(300);

        //Impedir/ bloquear a movimentação das colunas
        tablePlanosDeSaude.getTableHeader().setReorderingAllowed(false);

        // Bloquear edição das células
        tablePlanosDeSaude.setDefaultEditor(Object.class, null);
    }

}

