
package com.sales.controller;

import com.sales.model.Invoice;
import com.sales.model.InvoicesTableModel;
import com.sales.model.Item;
import com.sales.model.ItemsTableModel;
import com.sales.view.Myframe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ActionListener, ListSelectionListener{
    private Myframe frame;
    public Controller(Myframe frame){
    this.frame = frame;}

    @Override
    public void actionPerformed(ActionEvent e) {
       
        String actionCommand = e.getActionCommand();
        System.out.println("Action: "+ actionCommand);
        switch(actionCommand){
            case"lf":
        {
            try {
                loadfile();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case"sf":
                savefile();
                break;
            case"cni":
                createnewinvoice();
                break;
            case"di":
                deleteinvoice();
                break;
            case"c":
                create();
                break;
            case"d":
                delete();
                break;
            
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int SelectedIndex = frame.getInvoiceTable().getSelectedRow();
        if(SelectedIndex != -1){
        System.out.println("you have selected row: " + SelectedIndex);
        Invoice currentInvoice = frame.getInvoices().get(SelectedIndex);
        frame.getInvoiceNumLabel().setText(""+currentInvoice.getNumber());
        frame.getInvoiceDateLabel().setText(""+currentInvoice.getDate());
        frame.getCustomerNameLabel().setText(""+currentInvoice.getCustomer());
        frame.getInvoiceTotalLabel().setText(""+currentInvoice.getInvoiceTotal());
        ItemsTableModel itemsTableModel = new ItemsTableModel(currentInvoice.getItems());
        frame.getItemTable().setModel(itemsTableModel);
        itemsTableModel.fireTableDataChanged();
        }
    }
    
    
    
    private void loadfile() throws IOException {
        JFileChooser fc = new JFileChooser();
        try{
        int result = fc.showOpenDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION){
            File invoiceFile = fc.getSelectedFile();
            Path invoicePath = Paths.get(invoiceFile.getAbsolutePath());
            List <String> invoiceLines = Files.readAllLines(invoicePath);
            System.out.println("Invoices have been read"); 
          
            ArrayList<Invoice> invoicesArray = new ArrayList<>();
            for(String invoiceLine : invoiceLines){
            String[] invoiceParts = invoiceLine.split(",");
            int invoiceNum = Integer.parseInt(invoiceParts[0]);
            String invoiceDate = invoiceParts[1];
            String customerName = invoiceParts[2];
            Invoice invoice = new Invoice (invoiceNum, invoiceDate, customerName);
            invoicesArray.add(invoice);
            }
            System.out.println("Check point");
            result = fc.showOpenDialog(frame);
            if(result == JFileChooser.APPROVE_OPTION){
            File itemFile = fc.getSelectedFile();
            Path itemPath = Paths.get(itemFile.getAbsolutePath());
            List <String> itemItems = Files.readAllLines(itemPath);
            System.out.println("Items have been read"); 
              
                for(String itemItem : itemItems){
                String[] itemParts = itemItem.split(",");
                int invoiceNum = Integer.parseInt(itemParts[0]);
                String itemName = itemParts[1];
                double price = Double.parseDouble(itemParts[2]);
                int count = Integer.parseInt(itemParts[3]);
                Invoice inv = null;
            
            
                    for(Invoice invoices : invoicesArray){
                        if(Invoice.getNumber){
                            inv = invoices;
                            break;
                        }
                    }
                    Item item = new Item(itemName, price, count, inv);
                    inv.getItems().add(item);
                }
            }
            frame.setInvoices(invoicesArray);
            InvoicesTableModel invoicesTableModel = new InvoicesTableModel(invoicesArray);
            frame.setInvoicesTableModel(invoicesTableModel);
            frame.getInvoiceTable().setModel(invoicesTableModel);
            frame.getInvoicesTableModel().fireTableDataChanged();
            }
        }catch(IOException ex){
            ex.printStackTrace(); 
        }   
    }

    
    
    
    private void savefile() {
        
    }

    private void delete() {
        int selectedInv = frame.getInvoiceTable().getSelectedRow();
        int selectedRow = frame.getItemTable().getSelectedRow();
        if (selectedInv != -1 && selectedRow != -1){
            Invoice invoice = frame.getInvoices().get(selectedInv);
            invoice.getItems().remove(selectedRow);
            ItemsTableModel itemsTableModel = new ItemsTableModel(invoice.getItems());
            frame.getItemTable().setModel(itemsTableModel);
            itemsTableModel.fireTableDataChanged();
            
           
       }
         
    }

    private void createnewinvoice() {
         
    }

    private void deleteinvoice() {
       int selectedRow = frame.getInvoiceTable().getSelectedRow();
       if (selectedRow != -1){
           frame.getInvoices().remove(selectedRow);
           frame.getInvoicesTableModel().fireTableDataChanged();
           
       }
    }

    private void create() {
        
    }

}
