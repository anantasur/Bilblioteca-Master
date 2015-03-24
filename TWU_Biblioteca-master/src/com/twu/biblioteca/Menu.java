package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuItems;


    public Menu() {
        menuItems = new ArrayList<MenuItem>();
    }

    @Override
    public String toString() {
        StringBuilder menuListing = new StringBuilder();
        int index = 0;

        for (MenuItem menuItem : menuItems) {
            ++index;

            menuListing.append(index);
            menuListing.append(". ");
            menuListing.append(menuItem.getName());
            menuListing.append(System.lineSeparator());
        }

        return menuListing.toString();
    }

    public void handleOption(int option) throws QuitBibliotecaException, InvalidOptionException {
        if(option <1 || option > menuItems.size())
            throw new InvalidOptionException("Invalid Option");
        menuItems.get(option-1).performAction();
    }

    public void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
}