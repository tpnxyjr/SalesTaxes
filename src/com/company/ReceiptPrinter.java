package com.company;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Kevin on 3/20/2017.
 */
public class ReceiptPrinter {
    private LinkedHashMap<Item, Integer> cart;
    public ReceiptPrinter(ShoppingCart cart){
        this.cart = cart.getCart();
    }

    public void printReceipt(){
        DecimalFormat df = new DecimalFormat("#.00");
        Iterator cart_iterator = cart.entrySet().iterator();
        double taxes = 0,total = 0;
        while(cart_iterator.hasNext()){
            Map.Entry<Item, Integer> pair = (Map.Entry<Item, Integer>) cart_iterator.next();
            taxes += pair.getKey().getTaxCost() * pair.getValue();
            total += pair.getKey().getFinal() * pair.getValue();
            System.out.println(pair.getValue() + " " + pair.getKey().getName() + ": " + df.format(pair.getKey().getFinal() * pair.getValue()));
        }
        System.out.println("Sales Taxes: "+ df.format(taxes));
        System.out.println("Total: "+ df.format(total));
    }
}
