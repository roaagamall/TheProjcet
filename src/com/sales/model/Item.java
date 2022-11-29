
package com.sales.model;

public class Item {



    
 
    private String itemName;
    private double price;
    private int count;
    private Invoice invoice;
    

    public Item() {
    }

    public Item(String item, double price, int count) {
        
        this.itemName = item;
        this.price = price;
        this.count = count;
    }

    public Item(int number, String itemName, double price, int count, Invoice invoice) {
       
        this.itemName = itemName;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }

    public Item(String item, double price, int count, Invoice inv) {
         }

    public Item(Item item, double price, int count, Invoice invoice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public double getItemTotal(){
     return price * count;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" + "number=" + invoice.getNumber() + ", item=" + itemName + ", price=" + price + ", count=" + count + '}';
    }

    public Invoice getInvoice() {
        return invoice;
    }
    
    public  String getAsCSV() {
        return invoice.getNumber() + "," + itemName + "," + price + "," + count ;
         }

   
    
}
