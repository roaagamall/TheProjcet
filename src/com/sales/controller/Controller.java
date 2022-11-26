
package com.sales.controller;

import com.sales.model.Invoice;
import com.sales.model.InvoicesTableModel;
import com.sales.model.Item;
import com.sales.model.ItemsTableModel;
import com.sales.view.InvoiceDialog;
import com.sales.view.ItemDialog;
import com.sales.view.Myframe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ActionListener, ListSelectionListener{
    
    private Myframe frame;
    private InvoiceDialog invoiceDialog;
    private ItemDialog itemDialog;
    public Controller(Myframe frame){
    this.frame = frame;}

    @Override
    public void actionPerformed(ActionEvent e) {
       
        try {
            String actionCommand = e.getActionCommand();
            System.out.println("Action: "+ actionCommand);
            switch(actionCommand){
                case"lf":
                    loadfile();
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
                case"cnio":
                    createInvoiceOk();
                    break;
                case"cnic":
                    createInvoiceCancel();
                    break;
                case"cIO":
                    createItemOk();
                    break;
                case"cIC":
                    createCancel();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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
                String itemParts[] = itemItem.split(",");
                int invoiceNum = Integer.parseInt(itemParts[0]);
                String itemName = itemParts[1];
                double price = Double.parseDouble(itemParts[2]);
                int count = Integer.parseInt(itemParts[3]);
                Invoice inv = null;
                for(Invoice invoice : invoicesArray){
                    if(invoice.getNumber() == invoiceNum){
                        inv = invoice;
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
        ArrayList<Invoice> invoices = frame.getInvoices();
        String headers = "";
        String items = "";
        for (Invoice invoice : invoices) {
            String invCSV = invoice.getAsCSV();
            headers += invCSV;
            headers += "\n";

            for (Item item : invoice.getItems()) {
                String itemCSV = item.getAsCSV();
                     items += itemCSV;
                     items += "\n";
             
            }
        }
        System.out.println("Check point");
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File invoiceFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(invoiceFile);
                hfw.write(headers);
                hfw.flush();
                hfw.close();
                result = fc.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File itemFile = fc.getSelectedFile();
                    FileWriter lfw = new FileWriter(itemFile);
                    lfw.write(items);
                    lfw.flush();
                    lfw.close();
                }
            }
        } catch (Exception ex) {

        }
        
    }

    private void delete() {
        int selectedInv = frame.getInvoiceTable().getSelectedRow();
        int selectedRow = frame.getItemTable().getSelectedRow();

        if (selectedInv != -1 && selectedRow != -1) {
            Invoice invoice = frame.getInvoices().get(selectedInv);
            invoice.getItems().remove(selectedRow);
            ItemsTableModel itemsTableModel = new ItemsTableModel(invoice.getItems());
            frame.getItemTable().setModel(itemsTableModel);
            itemsTableModel.fireTableDataChanged();
        }
         
    }

    private void createnewinvoice() {
        invoiceDialog = new InvoiceDialog(frame);
        invoiceDialog.setVisible(true);
         
    }

    private void deleteinvoice() {
       int selectedRow = frame.getInvoiceTable().getSelectedRow();
       if (selectedRow != -1){
           frame.getInvoices().remove(selectedRow);
           frame.getInvoicesTableModel().fireTableDataChanged();
           
       }
    }

    private void create() {
        itemDialog = new ItemDialog(frame);
        itemDialog.setVisible(true);
    }

    private void createInvoiceOk() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = invoiceDialog.getInvDateField().getText();
        String customer = invoiceDialog.getCustNameField().getText();
        int num = frame.getNextInvoiceNum();
        try{
            Date invDate = df.parse(date);
            Invoice invoice = new Invoice(num, date, customer);
            frame.getInvoices().add(invoice);
            frame.getInvoicesTableModel().fireTableDataChanged();
            invoiceDialog.setVisible(false);
            invoiceDialog.dispose();
            invoiceDialog = null;
        }catch (ParseException ex){
            JOptionPane.showMessageDialog(frame, "wrong date format", "error", JOptionPane.ERROR_MESSAGE);
        }

        
        }

    private void createInvoiceCancel() {
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
         }

    private void createItemOk() {
        String itemName = itemDialog.getItemNameField().getText();
        String countStr = itemDialog.getItemCountField().getText();
        String priceStr = itemDialog.getItemPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = frame.getInvoiceTable().getSelectedRow();
        if (selectedInvoice != -1) {
            Invoice invoice = frame.getInvoices().get(selectedInvoice);
            Item item = new Item(itemName, price, count, invoice);
            invoice.getItems().add(item);
            ItemsTableModel linesTableModel = (ItemsTableModel) frame.getItemTable().getModel();
            linesTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }
    private void createCancel() {
        itemDialog.setVisible(false);
        itemDialog.dispose();
        itemDialog = null;
        }

    private Object itemsTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
