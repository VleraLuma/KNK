package com.example.sample.Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private  static  ShoppingCart INSTANCE;

    public static ShoppingCart getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ShoppingCart();
        }
        return INSTANCE;
    }
    private Map<String, CartEntry> entries;

    private ShoppingCart(){
        this.entries = new HashMap<>();
    }

    public void addProducts(String prodctName){
        CartEntry productEntry = entries.get(prodctName.toUpperCase());
        if(productEntry != null){
            productEntry.increaseQuantity();
        }else {
            Product product = Product.valueOf(prodctName);
            CartEntry entry = new CartEntry(product,1);
            entries.put(prodctName.toUpperCase(),entry);
        }
    }

    public void removeProduct(String productName) {
        if (productName != null) {
            String upperCaseProductName = productName.toUpperCase();
            CartEntry productEntry = entries.get(upperCaseProductName);

            if (productEntry != null) {
                productEntry.decreaseQuantity();
            }
        }
    }


    public int getQuantity(String productName){
        CartEntry entry = entries.get(productName.toUpperCase());
        if (entry != null){
            return entry.getQuantity();
        }
        return 0;
    }
    public  double calculateTotal(){
        double total = 0;
        for (CartEntry entry:entries.values()){
            double entryCost = entry.getProduct().getPrice()*entry.getQuantity();
            total = total + entryCost;
        }
        return total;
    }
    public List<CartEntry> getEntries(){
        return new ArrayList<>(entries.values());
    }


}

