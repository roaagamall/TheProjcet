
package com.sales.model;

public class Item {



    
 
    private String item;
    private double price;
    private int count;
    private Invoice invoice;
    

    public Item() {
    }

    public Item(String item, double price, int count) {
        
        this.item = item;
        this.price = price;
        this.count = count;
    }

    public Item(int number, String item, double price, int count, Invoice invoice) {
       
        this.item = item;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }

    public Item(String itemName, double price, int count, Invoice inv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" + "number=" + invoice.getNumber() + ", item=" + item + ", price=" + price + ", count=" + count + '}';
    }

    public Invoice getInvoice() {
        return invoice;
    }
    
    public String getAsCSV() {
        return invoice.getNumber() + "," + item + "," + price + "," + count ;
         }
    
}
