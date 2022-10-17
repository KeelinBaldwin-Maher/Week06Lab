package services;

import java.util.*;
import models.Item;

public class ShoppingListServices {
    private static ArrayList<Item> shoppingList = new ArrayList<>();
    
    public ShoppingListServices() {
        
    }
    
    public void add(String item) {
        Item newItem = new Item(item, shoppingList.size());
        shoppingList.add(newItem);
    }
    
    public void remove(int index) {
        shoppingList.remove(index);
    }

    public ArrayList<Item> getShoppingList() {
        return shoppingList;
    }
    
    public void clear() {
        shoppingList.clear();
    } 

}
