/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.Calcolatrice;

/**
 *
 * @author gigi9
 */
public class GUI extends javax.swing.JPanel {

    /**
     * Creates new form GUI
     */
    Calcolatrice calcolatrice;
    
    public GUI(){
        initComponents();
    }

    public GUI(Calcolatrice calcolatrice) {
        initComponents();
        setVisible(true);
        System.out.println("SONO IN GUI");

        this.calcolatrice = calcolatrice;

    }

    /**
     * This method zis called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textTitle = new javax.swing.JTextField();
        buttonSum = new javax.swing.JButton();
        buttonDiff = new javax.swing.JButton();
        buttonProd = new javax.swing.JButton();
        buttonDiv = new javax.swing.JButton();
        buttonSqr = new javax.swing.JButton();
        buttonInv = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        labelRealPart = new javax.swing.JLabel();
        labelComplexPart = new javax.swing.JLabel();
        textRealPart = new javax.swing.JTextField();
        textComplexPart = new javax.swing.JTextField();
        buttonInsert = new javax.swing.JButton();

        textTitle.setText("Calcolatrice Con Numeri Complessi");
        textTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTitleActionPerformed(evt);
            }
        });

        buttonSum.setText("Somma");
        buttonSum.setMaximumSize(new java.awt.Dimension(85, 25));
        buttonSum.setMinimumSize(new java.awt.Dimension(85, 25));
        buttonSum.setPreferredSize(new java.awt.Dimension(85, 25));
        buttonSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSumActionPerformed(evt);
            }
        });

        buttonDiff.setText("Differenza");
        buttonDiff.setMaximumSize(new java.awt.Dimension(85, 25));
        buttonDiff.setMinimumSize(new java.awt.Dimension(85, 25));
        buttonDiff.setPreferredSize(new java.awt.Dimension(85, 25));
        buttonDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDiffActionPerformed(evt);
            }
        });

        buttonProd.setText("Prodotto");
        buttonProd.setMaximumSize(new java.awt.Dimension(85, 25));
        buttonProd.setMinimumSize(new java.awt.Dimension(85, 25));
        buttonProd.setPreferredSize(new java.awt.Dimension(85, 25));
        buttonProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProdActionPerformed(evt);
            }
        });

        buttonDiv.setText("Divisione");
        buttonDiv.setMaximumSize(new java.awt.Dimension(85, 25));
        buttonDiv.setMinimumSize(new java.awt.Dimension(85, 25));
        buttonDiv.setPreferredSize(new java.awt.Dimension(85, 25));
        buttonDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDivActionPerformed(evt);
            }
        });

        buttonSqr.setText("Radice Quadrata");
        buttonSqr.setMaximumSize(new java.awt.Dimension(125, 25));
        buttonSqr.setMinimumSize(new java.awt.Dimension(125, 25));
        buttonSqr.setPreferredSize(new java.awt.Dimension(125, 25));
        buttonSqr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSqrActionPerformed(evt);
            }
        });

        buttonInv.setText("Inversione Segno");
        buttonInv.setMaximumSize(new java.awt.Dimension(125, 25));
        buttonInv.setMinimumSize(new java.awt.Dimension(125, 25));
        buttonInv.setPreferredSize(new java.awt.Dimension(125, 25));
        buttonInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInvActionPerformed(evt);
            }
        });

        jTextField1.setText(" +");

        labelRealPart.setText("Parte Reale");

        labelComplexPart.setText("Parte Immaginaria");

        textRealPart.setMaximumSize(new java.awt.Dimension(60, 25));
        textRealPart.setMinimumSize(new java.awt.Dimension(60, 25));
        textRealPart.setPreferredSize(new java.awt.Dimension(60, 25));

        textComplexPart.setMaximumSize(new java.awt.Dimension(60, 25));
        textComplexPart.setMinimumSize(new java.awt.Dimension(60, 25));
        textComplexPart.setPreferredSize(new java.awt.Dimension(60, 25));

        buttonInsert.setText("Inserisci");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelRealPart, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textRealPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(labelComplexPart, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(textComplexPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonInsert)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonSum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonDiff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonDiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSqr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRealPart)
                    .addComponent(labelComplexPart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textRealPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textComplexPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInsert))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSqr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(283, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTitleActionPerformed

    private void buttonDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDivActionPerformed
        // TODO add your handling code here:
        calcolatrice.stackDiv();
    }//GEN-LAST:event_buttonDivActionPerformed

    private void buttonSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSumActionPerformed
        // TODO add your handling code here:
        calcolatrice.stackSum();
    }//GEN-LAST:event_buttonSumActionPerformed

    private void buttonProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProdActionPerformed
        // TODO add your handling code here:
        calcolatrice.stackProd();
    }//GEN-LAST:event_buttonProdActionPerformed

    private void buttonDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDiffActionPerformed
        // TODO add your handling code here:
        calcolatrice.stackDiff();

    }//GEN-LAST:event_buttonDiffActionPerformed

    private void buttonSqrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSqrActionPerformed
        // TODO add your handling code here:
        calcolatrice.stackSqr();
    }//GEN-LAST:event_buttonSqrActionPerformed

    private void buttonInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInvActionPerformed
        // TODO add your handling code here:
        calcolatrice.stackInv();
    }//GEN-LAST:event_buttonInvActionPerformed

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        // TODO add your handling code here:
        String realPart = textRealPart.getText();
        String complexPart = textComplexPart.getText();

        if (isNumeric(realPart) && isNumeric(complexPart)) {
            double real = Double.parseDouble(realPart);
            double img = Double.parseDouble(complexPart);

            calcolatrice.creatComplexNumber(real, img);
        }
    }//GEN-LAST:event_buttonInsertActionPerformed

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDiff;
    private javax.swing.JButton buttonDiv;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonInv;
    private javax.swing.JButton buttonProd;
    private javax.swing.JButton buttonSqr;
    private javax.swing.JButton buttonSum;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelComplexPart;
    private javax.swing.JLabel labelRealPart;
    private javax.swing.JTextField textComplexPart;
    private javax.swing.JTextField textRealPart;
    private javax.swing.JTextField textTitle;
    // End of variables declaration//GEN-END:variables
}
