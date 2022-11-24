
package com.sales.model;

import java.util.ArrayList;


public class Invoice {
    
    private int number;
    private String date;
    private String customer;
    private ArrayList<Item> items;
    

    public Invoice() {
    }

    public Invoice(int number, String date, String customer) {
        this.number = number;
        this.date = date;
        this.customer = customer;
    }
    public double getInvoiceTotal(){
        double total = 0;
        for(Item item : getItems()){
            total += item.getItemTotal();
        }
        return total;
    }
           
    public ArrayList<Item> getItems() {
        if(items == null){
            items = new ArrayList<>();
        }
        return items;
    }
    
    

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "number=" + number + ", date=" + date + ", customer=" + customer + ", items=" + items + '}';
    }


    public String getAsCSV() {
         return number +"," + date + "," + customer;
    }

    
}
