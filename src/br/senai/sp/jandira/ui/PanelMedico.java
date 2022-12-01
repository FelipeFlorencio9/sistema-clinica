package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.MedicoDAO;
import br.senai.sp.jandira.model.Medico;
import br.senai.sp.jandira.model.TipoOperacao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelMedico extends javax.swing.JPanel {

    int linha;

    public PanelMedico() {
        initComponents();
        criarTabelaMedicos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTable = new javax.swing.JScrollPane();
        tableMedico = new javax.swing.JTable();
        buttonEditarMedico = new javax.swing.JButton();
        buttonDeletarMedico = new javax.swing.JButton();
        labelTableNome = new javax.swing.JLabel();
        buttonAdicionarMedico = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(900, 410));
        setLayout(null);

        tableMedico.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollTable.setViewportView(tableMedico);

        add(scrollTable);
        scrollTable.setBounds(20, 40, 870, 280);

        buttonEditarMedico.setBackground(new java.awt.Color(153, 204, 255));
        buttonEditarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/editar.png"))); // NOI18N
        buttonEditarMedico.setToolTipText("Editar medico selecionado.");
        buttonEditarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarMedicoActionPerformed(evt);
            }
        });
        add(buttonEditarMedico);
        buttonEditarMedico.setBounds(730, 340, 70, 50);

        buttonDeletarMedico.setBackground(new java.awt.Color(153, 204, 255));
        buttonDeletarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/delete.png"))); // NOI18N
        buttonDeletarMedico.setToolTipText("Excluir plano de saúde selecionado.");
        buttonDeletarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarMedicoActionPerformed(evt);
            }
        });
        add(buttonDeletarMedico);
        buttonDeletarMedico.setBounds(650, 340, 70, 50);

        labelTableNome.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        labelTableNome.setText("Médicos");
        add(labelTableNome);
        labelTableNome.setBounds(40, 0, 210, 30);

        buttonAdicionarMedico.setBackground(new java.awt.Color(153, 204, 255));
        buttonAdicionarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/add.png"))); // NOI18N
        buttonAdicionarMedico.setToolTipText("Adicionar novo plano de saúde");
        buttonAdicionarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarMedicoActionPerformed(evt);
            }
        });
        add(buttonAdicionarMedico);
        buttonAdicionarMedico.setBounds(810, 340, 70, 50);
    }// </editor-fold>//GEN-END:initComponents
    private void criarTabelaMedicos() {

        tableMedico.setModel(MedicoDAO.getTableModel());

        tableMedico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tableMedico.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableMedico.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableMedico.getColumnModel().getColumn(2).setPreferredWidth(309);
        tableMedico.getColumnModel().getColumn(3).setPreferredWidth(308);
        tableMedico.getTableHeader().setReorderingAllowed(false);

        tableMedico.setDefaultEditor(Object.class, null);
    }


    private void buttonEditarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarMedicoActionPerformed

        linha = tableMedico.getSelectedRow();

        if (linha != -1) {
            editar();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, selecione um médico para alterar.",
                    "Médico",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonEditarMedicoActionPerformed
    private void editar() {
        Medico medico = MedicoDAO.getMedico(getCodigo());

        DialogMedicos medicosDialog
                = new DialogMedicos(
                        null,
                        true,
                        TipoOperacao.ALTERAR,
                        medico);

        medicosDialog.setVisible(true);

    }
    private void buttonDeletarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarMedicoActionPerformed
        //Obtemos o indice da linha selecionada na tabela
        linha = tableMedico.getSelectedRow();

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
    }//GEN-LAST:event_buttonDeletarMedicoActionPerformed

    private void buttonAdicionarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarMedicoActionPerformed
        DialogMedicos dialogMedico = new DialogMedicos(
                null,
                true,
                TipoOperacao.ADICIONAR,
                null);

        dialogMedico.setVisible(true);
        criarTabelaMedicos();
    }//GEN-LAST:event_buttonAdicionarMedicoActionPerformed
    private void excluir() {
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Você tem certeza que quer excluir o item selecionado?",
                "Medico",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        System.out.println(resposta);

        if (resposta == 0) {
            MedicoDAO.remover(getCodigo());
            criarTabelaMedicos();
        }
    }

    private Integer getCodigo() {
        String codigoStr = tableMedico.getValueAt(linha, 0).toString();
        return Integer.valueOf(codigoStr);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarMedico;
    private javax.swing.JButton buttonDeletarMedico;
    private javax.swing.JButton buttonEditarMedico;
    private javax.swing.JLabel labelTableNome;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tableMedico;
    // End of variables declaration//GEN-END:variables
}
