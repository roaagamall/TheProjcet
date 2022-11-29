
package com.sales.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ItemDialog extends JDialog {
    
    private JTextField itemNameField;
    private JTextField itemCountField;
    private JTextField PriceField;
    private JLabel itemNameLbl;
    private JLabel itemCountLbl;
    private JLabel PriceLbl;
    private JButton okBtn;
    private JButton cancelBtn;
    
    public ItemDialog(Myframe frame) {
        itemNameField = new JTextField(20);
        itemNameLbl = new JLabel("Item Name");
        
        itemCountField = new JTextField(20);
        itemCountLbl = new JLabel("Item Count");
        
        PriceField = new JTextField(20);
        PriceLbl = new JLabel("Item Price");
        
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        okBtn.setActionCommand("createOK");
        cancelBtn.setActionCommand("createCancel");
        
        okBtn.addActionListener(frame.getController());
        cancelBtn.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLbl);
        add(itemNameField);
        add(itemCountLbl);
        add(itemCountField);
        add(PriceLbl);
        add(PriceField);
        add(okBtn);
        add(cancelBtn);
        
        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return PriceField;
    }

   

    public void setVisible(boolean b) {
       
        
         }

    private void setLayout(GridLayout gridLayout) {
         }

    private void add(JLabel itemNameLbl) {
        }

    private void add(JTextField itemCountField) {
         }

    public void pack() {
         }

    private void add(JButton cancelBtn) {
         }

    public Object getPriceField() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


