/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface.dss;

/**
 *
 * @author Nuno
 */
public class ComponentesObrigatorias extends javax.swing.JPanel {

    /**
     * Creates new form ComponentesObrigatorias
     */
    public ComponentesObrigatorias() {
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

        pinturaB = new javax.swing.JRadioButton();
        jantesB = new javax.swing.JRadioButton();
        pneuB = new javax.swing.JRadioButton();
        motorB = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nextB = new javax.swing.JButton();
        backB = new javax.swing.JButton();

        pinturaB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pinturaB.setText("Pintura");

        jantesB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jantesB.setText("Jantes");

        pneuB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pneuB.setText("Pneu");

        motorB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        motorB.setText("Motor");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkginterface/dss/images/jante.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkginterface/dss/images/pneu.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkginterface/dss/images/motor.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkginterface/dss/images/tinta.png"))); // NOI18N

        nextB.setText("Next");

        backB.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(backB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextB)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pinturaB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jantesB)
                    .addComponent(pneuB)
                    .addComponent(motorB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pinturaB)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jantesB)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pneuB)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motorB)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextB)
                    .addComponent(backB))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jantesB;
    private javax.swing.JRadioButton motorB;
    private javax.swing.JButton nextB;
    private javax.swing.JRadioButton pinturaB;
    private javax.swing.JRadioButton pneuB;
    // End of variables declaration//GEN-END:variables
}
