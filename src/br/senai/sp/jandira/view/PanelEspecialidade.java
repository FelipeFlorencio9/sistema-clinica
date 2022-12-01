/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.senai.sp.jandira.view;

import br.senai.sp.jandira.dao.EspecialidadeDAO;
import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.model.TipoOperacao;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author 22282108
 */
public class PanelEspecialidade extends javax.swing.JPanel {

    int linha;

    public PanelEspecialidade() {
        initComponents();
        criarTableEspecialidade();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTable = new javax.swing.JScrollPane();
        tableEspecialidade = new javax.swing.JTable();
        buttonEditarEspecialidade = new javax.swing.JButton();
        buttonDeletarEspecialidade = new javax.swing.JButton();
        buttonAdicionarEspecialidade = new javax.swing.JButton();
        labelTableNome = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(null);

        tableEspecialidade.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollTable.setViewportView(tableEspecialidade);

        add(scrollTable);
        scrollTable.setBounds(20, 40, 870, 280);

        buttonEditarEspecialidade.setBackground(new java.awt.Color(153, 204, 255));
        buttonEditarEspecialidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/editar.png"))); // NOI18N
        buttonEditarEspecialidade.setToolTipText("Editar plano de saúde selecionado.");
        buttonEditarEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarEspecialidadeActionPerformed(evt);
            }
        });
        add(buttonEditarEspecialidade);
        buttonEditarEspecialidade.setBounds(730, 340, 70, 50);

        buttonDeletarEspecialidade.setBackground(new java.awt.Color(153, 204, 255));
        buttonDeletarEspecialidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/delete.png"))); // NOI18N
        buttonDeletarEspecialidade.setToolTipText("Excluir plano de saúde selecionado.");
        buttonDeletarEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarEspecialidadeActionPerformed(evt);
            }
        });
        add(buttonDeletarEspecialidade);
        buttonDeletarEspecialidade.setBounds(650, 340, 70, 50);

        buttonAdicionarEspecialidade.setBackground(new java.awt.Color(153, 204, 255));
        buttonAdicionarEspecialidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/add.png"))); // NOI18N
        buttonAdicionarEspecialidade.setToolTipText("Adicionar novo plano de saúde");
        buttonAdicionarEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarEspecialidadeActionPerformed(evt);
            }
        });
        add(buttonAdicionarEspecialidade);
        buttonAdicionarEspecialidade.setBounds(810, 340, 70, 50);

        labelTableNome.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        labelTableNome.setText("Especialidade");
        add(labelTableNome);
        labelTableNome.setBounds(40, 0, 210, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditarEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarEspecialidadeActionPerformed
        
        linha = tableEspecialidade.getSelectedRow();
        
        if (linha != -1) {
            editar();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, selecione um plano de saúde para alterar.",
                    "Planos de Saúde",
                    JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_buttonEditarEspecialidadeActionPerformed
    
    private void editar(){
        Especialidade especialidade = EspecialidadeDAO.getEspecialidade(getCodigo());
        //criar um dialog Especialiadade
        DialogEspecialidade especialidadeDialog = 
                new DialogEspecialidade(
                        null, 
                        true,
                        TipoOperacao.ALTERAR, 
                        especialidade);
        
        especialidadeDialog.setVisible(true);
        criarTableEspecialidade();     
    }
    private void buttonDeletarEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarEspecialidadeActionPerformed
        //Obtemos o indice da linha selecionada na tabela
        linha = tableEspecialidade.getSelectedRow();

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
    }//GEN-LAST:event_buttonDeletarEspecialidadeActionPerformed
    
    private void excluir() {
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Você tem certeza que quer excluir o item selecionado?",
                "Especialidade",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        System.out.println(resposta);
        
        if (resposta == 0) {
            EspecialidadeDAO.excluir(getCodigo());
            criarTableEspecialidade();
        }
    }

    private Integer getCodigo() {
        String codigoStr = tableEspecialidade.getValueAt(linha, 0).toString();
        return Integer.valueOf(codigoStr);
    }
    private void buttonAdicionarEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarEspecialidadeActionPerformed
        
        DialogEspecialidade dialogEspecialidade
                = new DialogEspecialidade(null, true, TipoOperacao.ADICIONAR, null);
        
        dialogEspecialidade.setVisible(true);
        criarTableEspecialidade();
    }//GEN-LAST:event_buttonAdicionarEspecialidadeActionPerformed
    
    private void criarTableEspecialidade() {
        tableEspecialidade.setModel(EspecialidadeDAO.getTableModel());
        
        tableEspecialidade.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        tableEspecialidade.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableEspecialidade.getColumnModel().getColumn(1).setPreferredWidth(300);
        tableEspecialidade.getColumnModel().getColumn(2).setPreferredWidth(300);
        
        tableEspecialidade.getTableHeader().setReorderingAllowed(false);

        // Bloquear edição das células
        tableEspecialidade.setDefaultEditor(Object.class, null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarEspecialidade;
    private javax.swing.JButton buttonDeletarEspecialidade;
    private javax.swing.JButton buttonEditarEspecialidade;
    private javax.swing.JLabel labelTableNome;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tableEspecialidade;
    // End of variables declaration//GEN-END:variables
}
