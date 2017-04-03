package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kevin on 3/20/2017.
 */
public class ItemTest {
    protected Item item = new Item("book", 12.49);
    protected Item item_2 = new Item("imported box of chocolates", 10.00);
    protected Item item_3 = new Item("packet of headache pills", 9.75);
    protected Item item_4 = new Item("imported bottle of perfume", 47.50);
    @Test
    public void getName() throws Exception {
        assertEquals(item.getName(), "book");
        assertEquals(item_2.getName(), "imported box of chocolates");
        assertEquals(item_3.getName(), "packet of headache pills");
        assertEquals(item_4.getName(), "imported bottle of perfume");
    }

    @Test
    public void getCost() throws Exception {
        assertEquals(item.getCost(), 12.49, 0.001);
        assertEquals(item_2.getCost(), 10.00, 0.001);
        assertEquals(item_3.getCost(), 9.75, 0.001);
        assertEquals(item_4.getCost(), 47.50, 0.001);
    }

    @Test
    public void getTaxCost() throws Exception {
        assertEquals(item.getTaxCost(), 0, 0.001);
        assertEquals(item_2.getTaxCost(), 0.50, 0.001);
        assertEquals(item_3.getTaxCost(), 0, 0.001);
        assertEquals(item_4.getTaxCost(), 7.15, 0.001);
    }

    @Test
    public void getFinal() throws Exception {
        assertEquals(item.getFinal(), 12.49, 0.001);
        assertEquals(item_2.getFinal(), 10.50, 0.001);
        assertEquals(item_3.getFinal(), 9.75, 0.001);
        assertEquals(item_4.getFinal(), 54.65, 0.001);
    }

}