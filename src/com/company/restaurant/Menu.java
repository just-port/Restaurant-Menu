package com.company.restaurant;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Arrays;

public class Menu {

    private String name;
    private String lastUpdated;
    private ArrayList<MenuItem> menuItems;

    public Menu(String name) {
        this.name = name;
        this.lastUpdated = setDateUpdated();
        this.menuItems = new ArrayList<>();
    }

    private DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

    private void isItNew() {
        for (MenuItem aMenuItem : menuItems) {

            // check age of aMenuItem
            Period period = Period.between(aMenuItem.dateAdded, LocalDate.now());

            // if aMenuItem is older than 10 days change isNew to false
            if (aMenuItem.isNew == true && period.getDays() > 10) {
                aMenuItem.isNew = false;
            }
        }
    }

    public void addToMenu(MenuItem aMenuItem) {
        if (!menuItems.contains(aMenuItem)) {
            menuItems.add(aMenuItem);
            System.out.println(aMenuItem.getName() + " added to " + name + " menu");
            setDateUpdated();
            aMenuItem.dateAdded = LocalDate.now();
        } else {
            System.out.println("That item is already on the menu.");
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
            System.out.println(aMenuItem + " has been removed.");
        }
    }

    private String setDateUpdated() {
        LocalDate date = LocalDate.now();
        String dateUpdated = date.format(myDateFormatter);

        return dateUpdated;
    }

    public void listMenu() {
        System.out.println("\nWelcome to " + name + "!\n\n***Appetizers***\n");
        for (MenuItem aMenuItem : menuItems) {

            if (aMenuItem.getCategory() == "appetizer") {
                if (aMenuItem.isNew == true) {
                    System.out.println("New item!");
                }
                System.out.println(aMenuItem.listMenuItem());
            }
        }

        System.out.println("***Main Course***\n");

        for (MenuItem aMenuItem : menuItems) {
            if (aMenuItem.getCategory() == "main course") {
                if (aMenuItem.isNew == true) {
                    System.out.println("New item!");
                }
                System.out.println(aMenuItem.listMenuItem());
            }
        }

        System.out.println("***Dessert***\n");

        for (MenuItem aMenuItem : menuItems) {
            if (aMenuItem.getCategory() == "dessert") {
                if (aMenuItem.isNew == true) {
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
        spinDip.setPrice(9.50);

        MenuItem wings = new MenuItem("Buffalo Chicken Wings", 8.50, "The classic bone-in wing.", "appetizer");

        MenuItem travs = new MenuItem("Toasted Ravioli", 4.5, "A Saint Louis Specialty/Travesty", "appetizer");

        MenuItem porkSteak = new MenuItem("Pork Steak", 15.5, "Another Saint Louis thing.", "main course");

        MenuItem ribeye = new MenuItem("22oz Ribeye", 22.5, "This isn't small.", "main course");

        MenuItem gooButt = new MenuItem("Gooey Butter Cake", 7.5, "I hope you like rich and delicious.", "dessert");

        MenuItem gooeyButt = new MenuItem("Gooey Butter Cake", 7.5, "I hope you like rich and delicious.", "dessert");

        System.out.println(gooButt.equals(gooeyButt));

        Menu neighborhooodBar = new Menu("Spanky's");

        ArrayList<MenuItem> toAdd = new ArrayList<>();

        toAdd.addAll(Arrays.asList(new MenuItem[]{spinDip, gooButt, wings, travs, porkSteak, ribeye}));

        neighborhooodBar.addListToMenu(toAdd);


        neighborhooodBar.addToMenu(new MenuItem("Buffalo Chicken Wings", 6.0, "other wings", "main course"));
        neighborhooodBar.listMenu();
    }

}
