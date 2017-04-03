package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kevin on 3/20/2017.
 */

public class Item {
    public double IMPORTED_TAX = 0.05;
    public double SALES_TAX = 0.10;
    private String name;
    private double cost;
    private Boolean imported = false;
    private Boolean taxable = false;

    public Item(String name, double cost){
        this.name = name;

        if(name.contains("imported")){
            imported = true;
            name = name.substring(9);
        }
        FileScanner scanner = new FileScanner("./src/com/company/notax.txt");
        if(scanner.scanFile(name)) taxable = false;
        else taxable = true;

        this.cost = cost;
    }

    public String getName(){
        return this.name;
    }

    public double getCost(){
        return this.cost;
    }

    private double getTax(){
        double tax = 0.00;
        if(imported) tax += IMPORTED_TAX;
        if(taxable) tax += SALES_TAX;

        return tax;
    }

    public double getTaxCost(){
        return round_up(this.getCost() * this.getTax());
    }

    public double getFinal(){
        return getCost() + getTaxCost();
    }

    private double round_up(Double d){
        return Math.ceil(d*20.0)/20.0;
    }

    public boolean equals(Object o){
        if((o instanceof Item) && ((Item)o).getName().equals(this.name) && ((Item)o).getCost()==this.cost)return true;
        return false;
    }
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + this.name.hashCode();
        result = prime * result + (int)Math.round(this.cost);
        return result;
    }
}
