package com.company.restaurant;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Menu {

    private DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

    private String name;
    private ArrayList<MenuItem> appetizers;
    private ArrayList<MenuItem> entrees;
    private ArrayList<MenuItem> desserts;
    private String lastUpdated;

    public Menu(String name) {
        this.name = name;
        this.appetizers = new ArrayList<>();
        this.entrees = new ArrayList<>();
        this.desserts = new ArrayList<>();
        this.lastUpdated = setDateUpdated();
    }

    public void getAppetizers() {

        for (MenuItem app : appetizers) {
            System.out.println(app.getName());
            System.out.println(app.getDescription());
            System.out.println("$ " + app.getPrice());
        }
    }

    public void getEntrees() {

        for (MenuItem entree : entrees) {
            System.out.println(entree.getName());
            System.out.println(entree.getDescription());
            System.out.println("$ " + entree.getPrice());
        }
    }

    public void getDesserts() {

        for (MenuItem dessert : desserts) {
            System.out.println(dessert.getName());
            System.out.println(dessert.getDescription());
            System.out.println("$ " + dessert.getPrice());
        }
    }

    public void addAppetizer(MenuItem anAppetizer) {
        appetizers.add(anAppetizer);
        setDateUpdated();
    }

    public void addEntree(MenuItem anEntree) {
        entrees.add(anEntree);
        setDateUpdated();
    }

    public void addDessert(MenuItem aDessert) {
        desserts.add(aDessert);
    }

    public void removeAppetizer(MenuItem anAppetizer) {
        if (!appetizers.contains(anAppetizer)) {
            System.out.println("This item was not on the menu.");
        } else {
            appetizers.remove(anAppetizer);
            System.out.println(anAppetizer.getName() + " successfully removed from Appetizers.");
        }
    }

    private String setDateUpdated() {
        LocalDateTime date = LocalDateTime.now();
        String dateUpdated = date.format(myDateFormatter);

        return dateUpdated;
    }

    public static void main(String[] args) {
        MenuItem spinDip = new MenuItem("Spinach and Artichoke Dip");
        spinDip.setCategory("Appetizers");
        spinDip.setDescription("This spinach artichoke dip is a mix of freshly cooked spinach, artichoke hearts and three types of cheese, all baked to golden brown perfection");
        spinDip.setPrice(9.50);

        MenuItem wings = new MenuItem("Buffalo Chicken Wings", 8.50, "A Buffalo wing in American cuisine, is an un-breaded chicken wing section that is generally deep-fried and then coated or dipped in a sauce consisting of a vinegar-based cayenne pepper hot sauce and melted butter prior to serving.", "Appetizers");

        Menu fastCasual = new Menu("Spanky's");

        fastCasual.addAppetizer(spinDip);
        fastCasual.addAppetizer(wings);

        fastCasual.getAppetizers();

        fastCasual.removeAppetizer(wings);
    }
}
