/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Presentation;

import Main.Business.Ford;
import Main.Data.ComponenteObrigatoriaDAO;
import Main.Data.ComponenteOpcionalDAO;
import Main.Data.DetExteriorDAO;
import Main.Data.DetInteriorDAO;
import Main.Data.UtilizadorDAO;

/**
 *
 * @author Nuno
 */
public class Menu_Admin extends javax.swing.JFrame {
     private Ford ford;
     private UtilizadorDAO  userDAO;
     private ComponenteObrigatoriaDAO coDAO;
     private ComponenteOpcionalDAO copDAO;
     private DetExteriorDAO dextDAO;
     private DetInteriorDAO dintDAO;
    /**
     * Creates new form MenuAdmin
     */
    public Menu_Admin(Ford ford, UtilizadorDAO userDAO, ComponenteObrigatoriaDAO coDAO, ComponenteOpcionalDAO copDAO,
            DetExteriorDAO dextDAO, DetInteriorDAO dintDAO) {
        this.ford=ford;
        this.userDAO=userDAO;
        this.coDAO=coDAO;
        this.copDAO=copDAO;
        this.dextDAO=dextDAO;
        this.dintDAO=dintDAO;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        defDesconto = new javax.swing.JButton();
        defPacote = new javax.swing.JButton();
        elemFunc = new javax.swing.JButton();
        autFunc = new javax.swing.JButton();
        altConfig = new javax.swing.JButton();
        consultFunc = new javax.swing.JButton();
        defPPeca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Administrador");

        defDesconto.setText("Defenir Desconto");
        defDesconto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        defDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defDescontoActionPerformed(evt);
            }
        });

        defPacote.setText("Defenir Pacote");
        defPacote.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        defPacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defPacoteActionPerformed(evt);
            }
        });

        elemFunc.setText("Eleminar Funcionário");
        elemFunc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        elemFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elemFuncActionPerformed(evt);
            }
        });

        autFunc.setText("Adicionar Funcionario");
        autFunc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        autFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autFuncActionPerformed(evt);
            }
        });

        altConfig.setText("Alterar Configuração");
        altConfig.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        consultFunc.setText("Consultar Funcionário");
        consultFunc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        consultFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultFuncActionPerformed(evt);
            }
        });

        defPPeca.setText("Defenir Preço Peça");
        defPPeca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        defPPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defPPecaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(defPacote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(autFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(defDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(consultFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elemFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(altConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(defPPeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elemFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defPPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(defPacote, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void autFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autFuncActionPerformed
        // TODO add your handling code here:
        Cria_Funcionario af = new Cria_Funcionario(ford);
        af.setVisible(true);
    }//GEN-LAST:event_autFuncActionPerformed

    private void defDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defDescontoActionPerformed
        // TODO add your handling code here:
        Defenir_Desconto dd = new Defenir_Desconto();
        dd.setVisible(true);
    }//GEN-LAST:event_defDescontoActionPerformed

    private void defPacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defPacoteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_defPacoteActionPerformed

    private void consultFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultFuncActionPerformed
        // TODO add your handling code here:
        Consultar_Funcionario cf = new Consultar_Funcionario(userDAO);
        cf.setVisible(true);
    }//GEN-LAST:event_consultFuncActionPerformed

    private void elemFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elemFuncActionPerformed
        // TODO add your handling code here:
        EleminarFuncionario ef = new EleminarFuncionario(userDAO);
        ef.setVisible(true);
    }//GEN-LAST:event_elemFuncActionPerformed

    private void defPPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defPPecaActionPerformed
        // TODO add your handling code here:
        Definir_Preco_Peca dpp = new Definir_Preco_Peca(coDAO, copDAO, dextDAO, dintDAO, ford);
        dpp.setVisible(true);
    }//GEN-LAST:event_defPPecaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altConfig;
    private javax.swing.JButton autFunc;
    private javax.swing.JButton consultFunc;
    private javax.swing.JButton defDesconto;
    private javax.swing.JButton defPPeca;
    private javax.swing.JButton defPacote;
    private javax.swing.JButton elemFunc;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}