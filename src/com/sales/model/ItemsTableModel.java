
package com.sales.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ItemsTableModel extends AbstractTableModel{
    
    private ArrayList<Item>items;
    private String [] columns = {"No.", "Item Name", "Price", "Count ", "Item Total"};

    public ItemsTableModel(ArrayList<Item> items) {
        this.items = items;
    }

    public ItemsTableModel(ArrayList<Item> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public int getRowCount() {
        return items.size();
         }

    @Override
    public int getColumnCount() {
        return columns.length;
        }
    
    public String getColumnName(int Y){
        return columns[Y];
         }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = items.get(rowIndex);
        
        switch(columnIndex){
            case 0: return item.getInvoice().getNumber();
            case 1: return item.getItem();
            case 2: return item.getPrice();
            case 3: return item.getCount();
            case 4: return item.getItemTotal();
            default : return "";
        }
        }
    
}
