package com.company.restaurant;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Arrays;

public class Menu {

    private final String name;
    private final String lastUpdated;
    private final ArrayList<MenuItem> menuItems;

    public Menu(String name) {
        this.name = name;
        this.lastUpdated = setDateUpdated();
        this.menuItems = new ArrayList<>();
    }

    private final DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

    private void isItNew() {
        for (MenuItem aMenuItem : menuItems) {

            // check age of aMenuItem
            Period period = Period.between(aMenuItem.dateAdded, LocalDate.now());

            // if aMenuItem is older than 10 days change isNew to false
            if (aMenuItem.isNew && period.getDays() > 10) {
                aMenuItem.isNew = false;
            }
        }
    }

    public void addToMenu(MenuItem aMenuItem) {
        if (menuItems.contains(aMenuItem)) {
            System.out.println("That item is already on the menu.");
        } else {
            menuItems.add(aMenuItem);
            System.out.println(aMenuItem.getName() + " added to " + name + " menu");
            setDateUpdated();
            aMenuItem.dateAdded = LocalDate.now();
        }
    }

    public void addListToMenu(ArrayList<MenuItem> menuItemArrayList) {
        for (MenuItem aMenuItem : menuItemArrayList) {
            addToMenu(aMenuItem);
        }
    }

    public void removeFromMenu(MenuItem aMenuItem) {
        if (menuItems.contains(aMenuItem)) {
            menuItems.remove(aMenuItem);
            System.out.println(aMenuItem.getName() + " has been removed.");
        }
    }

    private String setDateUpdated() {
        LocalDate date = LocalDate.now();

        return date.format(myDateFormatter);
    }

    public void listMenu() {
        System.out.println("\nWelcome to " + name + "!\n\n***Appetizers***\n");
        for (MenuItem aMenuItem : menuItems) {

            if (aMenuItem.getCategory().equals("appetizer")) {
                if (aMenuItem.isNew) {
                    System.out.println("New item!");
                }
                System.out.println(aMenuItem.listMenuItem());
            }
        }

        System.out.println("***Main Course***\n");

        for (MenuItem aMenuItem : menuItems) {
            if (aMenuItem.getCategory().equals("main course")) {
                if (aMenuItem.isNew) {
                    System.out.println("New item!");
                }
                System.out.println(aMenuItem.listMenuItem());
            }
        }

        System.out.println("***Dessert***\n");

        for (MenuItem aMenuItem : menuItems) {
            if (aMenuItem.getCategory().equals("dessert")) {
                if (aMenuItem.isNew) {
                    System.out.println("New item!");
                }
                System.out.println(aMenuItem.listMenuItem());
            }
        }

        System.out.println("Menu last updated " + lastUpdated);
    }

    public static void main(String[] args) {

        MenuItem spinDip = new MenuItem("Spinach and Artichoke Dip");
        spinDip.setCategory("appetizer");
        spinDip.setDescription("What? You never been to AppleBees?");
        spinDip.setPrice(9);

        MenuItem wings = new MenuItem("Buffalo Chicken Wings", 8.50, "The classic bone-in wing.", "appetizer");

        MenuItem travs = new MenuItem("Toasted Ravioli", 4.5, "A Saint Louis Specialty/Travesty", "appetizer");

        MenuItem porkSteak = new MenuItem("Pork Steak", 15.5, "Another Saint Louis thing.", "main course");

        MenuItem ribeye = new MenuItem("22oz Ribeye", 22.5, "This isn't small.", "main course");

        MenuItem gooButt = new MenuItem("Gooey Butter Cake", 7.5, "I hope you like rich and delicious.", "dessert");

        MenuItem gooeyButt = new MenuItem("Gooey Butter Cake", 7.5, "I hope you like rich and delicious.", "dessert");

        System.out.println(gooButt.equals(gooeyButt));

        Menu neighborhoodBar = new Menu("Spanky's");

        ArrayList<MenuItem> toAdd = new ArrayList<>(Arrays.asList(spinDip, gooButt, wings, travs, porkSteak, ribeye));

        neighborhoodBar.addListToMenu(toAdd);


        neighborhoodBar.addToMenu(new MenuItem("Buffalo Chicken Wings", 6.0, "other wings", "main course"));
        neighborhoodBar.listMenu();

        neighborhoodBar.removeFromMenu(ribeye);

        neighborhoodBar.listMenu();
    }

}
