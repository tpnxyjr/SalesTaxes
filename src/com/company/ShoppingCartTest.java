package com.company;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Kevin on 3/20/2017.
 */
public class ShoppingCartTest {
    protected ShoppingCart cart = new ShoppingCart();
    @Test
    public void add() throws Exception {
        Item test_item = new Item("book",10.00);
        cart.add(test_item, 1);
        Iterator cart_iterator = cart.getCart().entrySet().iterator();
        Map.Entry<Item, Integer> pair = (Map.Entry<Item, Integer>) cart_iterator.next();
        assertEquals(pair.getKey(), test_item);
        assertEquals(pair.getValue(), 1, 0.0001);
    }

}