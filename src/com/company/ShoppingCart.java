package com.company;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Kevin on 3/20/2017.
 */
public class ShoppingCart {
    private LinkedHashMap<Item,Integer> shopping_list;

    public ShoppingCart(){
       shopping_list = new LinkedHashMap<Item,Integer>();
    }

    public void add(Item item, int qty){
        int current_qty = 0;
        if(shopping_list.containsKey(item)) current_qty = shopping_list.get(item);
        shopping_list.put(item, current_qty+qty);
    }

    public void clear(){
        shopping_list.clear();
    }

    public LinkedHashMap<Item,Integer> getCart(){
        return shopping_list;
    }


}
