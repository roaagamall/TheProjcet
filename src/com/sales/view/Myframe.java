
package com.sales.view;

import com.sales.controller.Controller;
import com.sales.model.Invoice;
import com.sales.model.InvoicesTableModel;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;


public class Myframe extends javax.swing.JFrame {

    
    public Myframe() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        InvoiceTable.getSelectionModel().addListSelectionListener(controller);
        createinvoiceButton = new javax.swing.JButton();
        createinvoiceButton.addActionListener(controller);
        deleteinvoiceButton = new javax.swing.JButton();
        deleteinvoiceButton.addActionListener(controller);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        InvoiceNumLabel = new javax.swing.JLabel();
        InvoiceDateLabel = new javax.swing.JLabel();
        CustomerNameLabel = new javax.swing.JLabel();
        InvoiceTotalLabel = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        createButton.addActionListener(controller);
        deleteButton = new javax.swing.JButton();
        deleteButton.addActionListener(controller);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadfileMenuItem = new javax.swing.JMenuItem();
        loadfileMenuItem.addActionListener(controller);
        savefileMenuItem = new javax.swing.JMenuItem();
        savefileMenuItem.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(InvoiceTable);

        createinvoiceButton.setText("Create New Invoice");

        deleteinvoiceButton.setText("Delete Invoice");
        deleteinvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteinvoiceButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(ItemTable);

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");

        jMenu1.setText("File");

        loadfileMenuItem.setText("Loadfile");
        jMenu1.add(loadfileMenuItem);

        savefileMenuItem.setText("Savefile");
        jMenu1.add(savefileMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(createinvoiceButton)
                        .addGap(41, 41, 41)
                        .addComponent(deleteinvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(createButton)
                                        .addGap(46, 46, 46))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(InvoiceDateLabel)
                                            .addComponent(InvoiceNumLabel)
                                            .addComponent(CustomerNameLabel)
                                            .addComponent(InvoiceTotalLabel))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addComponent(deleteButton)
                                .addGap(157, 157, 157))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createinvoiceButton)
                            .addComponent(deleteinvoiceButton))
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(InvoiceNumLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(InvoiceDateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(CustomerNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(InvoiceTotalLabel))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createButton)
                    .addComponent(deleteButton))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteinvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteinvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteinvoiceButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Myframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Myframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Myframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Myframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Myframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerNameLabel;
    private javax.swing.JLabel InvoiceDateLabel;
    private javax.swing.JLabel InvoiceNumLabel;
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JLabel InvoiceTotalLabel;
    private javax.swing.JTable ItemTable;
    private javax.swing.JButton createButton;
    private javax.swing.JButton createinvoiceButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteinvoiceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadfileMenuItem;
    private javax.swing.JMenuItem savefileMenuItem;
    // End of variables declaration//GEN-END:variables
private ArrayList<Invoice>invoices;
private Controller controller = new Controller(this);
private InvoicesTableModel invoicesTableModel;


    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public InvoicesTableModel getInvoicesTableModel() {
        return invoicesTableModel;
    }

    public void setInvoicesTableModel(InvoicesTableModel invoicesTableModel) {
        this.invoicesTableModel = invoicesTableModel;
    }

    public JLabel getCustomerNameLabel() {
        return CustomerNameLabel;
    }

    public JLabel getInvoiceDateLabel() {
        return InvoiceDateLabel;
    }

    public JLabel getInvoiceNumLabel() {
        return InvoiceNumLabel;
    }

    public JTable getInvoiceTable() {
        return InvoiceTable;
    }

    public JLabel getInvoiceTotalLabel() {
        return InvoiceTotalLabel;
    }

    public JTable getItemTable() {
        return ItemTable;
    }

    public Controller getController() {
        return controller;
    }

    public Object getInvoiceNumberLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getInvoiceCustomerLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getInvoiceCustomerNameLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 public int getNextInvoiceNumber(){
  int num = 0;
  for (Invoice invoice : invoices){
      if(invoice.getNumber()> num) 
          num = invoice.getNumber();
    }
       return ++num;
     
    }

  
 }
