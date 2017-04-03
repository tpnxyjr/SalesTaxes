package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	    ShoppingCart shopping_cart = new ShoppingCart();
	    String current_line;


	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try {
            while((current_line=br.readLine()) != null){
                String[] ln = current_line.split("\\s+");
                int qty = 0;
                if(isInteger(ln[0]) && isDouble(ln[ln.length-1])){
                    qty = Integer.parseInt(ln[0]);
                    Item new_item = new Item(convertToString(ln), Double.parseDouble(ln[ln.length-1]));
                    shopping_cart.add(new_item, qty);
                }
                else System.out.println("Invalid Input");
            }

            ReceiptPrinter printer = new ReceiptPrinter(shopping_cart);
            printer.printReceipt();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    private static boolean isDouble(String s){
        try {
            Double.parseDouble(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    private static String convertToString(String [] s){
        StringBuilder item = new StringBuilder();
        for(int i = 1; i < s.length; i++){
            if(s[i].equals("at"))break;
            if(i!= 1) item.append(" ");
            item.append(s[i]);
        }
        return item.toString();
    }
}
