package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Library {
    protected List<Item> itemsInLibraryNow;
    protected List<Item> checkedOutItems;
    protected AppInteraction appInteraction;

    public Library(List<Item> defaultItems, AppInteraction appInteraction) {
        this.itemsInLibraryNow = new ArrayList<>(defaultItems);
        checkedOutItems = new ArrayList<>();
        this.appInteraction = appInteraction;
    }

    public void displayList() {
        appInteraction.printList(itemsInLibraryNow);
    }

    public void checkout(String itemName) throws IOException {
        Item item;
        Iterator<Item> itemIterator = itemsInLibraryNow.iterator();
        while (itemIterator.hasNext()) {
            item = itemIterator.next();
            if (item.getName().equals(itemName)) {
                itemIterator.remove();
                appInteraction.successfulCheckout();
                checkedOutItems.add(item);
                return;
            }
        }
        appInteraction.checkoutFail();
    }

    public void returnItem(String itemName) throws IOException {
        Item itemToBeReturned = itemToBeReturned(itemName);

        if (itemToBeReturned == null) {
            appInteraction.returnFail();
            return;
        }
        checkedOutItems.remove(itemToBeReturned);
        itemsInLibraryNow.add(itemToBeReturned);
        appInteraction.successfulReturn();
    }

    private Item itemToBeReturned(String itemName) { //TODO: Optional => Optional class isn't changing this so unnecessary atm
        for (Item item : checkedOutItems)
            if (item.getName().equals(itemName)) return item;
        return null;
    }
}
