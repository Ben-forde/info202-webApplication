/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import dao.DaoExceptionMapper;
import dao.ProductDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author benforde
 */
public class MainMenu extends javax.swing.JFrame {
     public ProductDAO dao;
    /**
     * Creates new form MainMenu
     */
    public MainMenu(ProductDAO dao) {
        this.dao = dao;
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

        txtMainMenu = new javax.swing.JTextField();
        addNewButton = new javax.swing.JButton();
        viewProductsButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtMainMenu.setText("Prodduct Administration ");
        txtMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMainMenuActionPerformed(evt);
            }
        });

        addNewButton.setText("Add a new product");
        addNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButtonActionPerformed(evt);
            }
        });

        viewProductsButton.setText("View Products");
        viewProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductsButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMainMenu, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addNewButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewProductsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(addNewButton)
                .addGap(32, 32, 32)
                .addComponent(viewProductsButton)
                .addGap(34, 34, 34)
                .addComponent(exitButton)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMainMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMainMenuActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0); 
    }//GEN-LAST:event_exitButtonActionPerformed

    private void viewProductsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductsButtonActionPerformed
        // TODO add your handling code here:
        try{
            ProductViewer productViewer = new ProductViewer(this, true); 
            productViewer.setLocationRelativeTo(this);
            productViewer.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
            new DaoExceptionMapper().messageFromException(ex),
            "Database Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_viewProductsButtonActionPerformed

    private void addNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButtonActionPerformed
        // TODO add your handling code here:
        try{
            ProductEditor dialog = new ProductEditor(this, true, dao);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
            new DaoExceptionMapper().messageFromException(ex),
            "Database Error", JOptionPane.ERROR_MESSAGE);
}
       
    }//GEN-LAST:event_addNewButtonActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField txtMainMenu;
    private javax.swing.JButton viewProductsButton;
    // End of variables declaration//GEN-END:variables
}
