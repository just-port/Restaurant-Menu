package com.company.restaurant;

import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Menu {

    private DateTimeFormatter aFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

    // possible fields: categories,
    // several menuItems, inside categories?
    // hashmap? arraylist?
    // last updated? use Date()

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

    }

    public void getAppetizers() {

        for (MenuItem app : appetizers) {

            System.out.println(app.getName());
            System.out.println(app.getDescription());
            System.out.println("Added on " + app.getDateAdded());
            System.out.println("\\$ " + app.getPrice());

        }
    }

    public void addAppetizer(MenuItem app) {

        this.appetizers.add(app);
        this.getDateUpdated();

    }

    public void getEntrees(@NotNull ArrayList<MenuItem> entrees) {

        for (MenuItem entree : entrees) {

            System.out.println(entree.getName());
            System.out.println(entree.getDescription());
            System.out.println("Added on " + entree.getDateAdded());
            System.out.println("\\$ " + entree.getPrice());

        }
    }

    public void addEntree(MenuItem entree) {

        this.entrees.add(entree);
        this.getDateUpdated();
    }

    public void getDesserts(ArrayList<MenuItem> desserts) {

        for (MenuItem dessert : desserts) {

            System.out.println(dessert.getName());
            System.out.println(dessert.getDescription());
            System.out.println("Added on " + dessert.getDateAdded());
            System.out.println("\\$ " + dessert.getPrice());

        }
    }

    public String getDateUpdated() {

        LocalDateTime date = LocalDateTime.now();
        String dateUpdated = date.format(aFormatter);

        return dateUpdated;
    }
}
