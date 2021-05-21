package com.company.restaurant;

import java.time.LocalDate;

public class MenuItem {

    private String name;
    private double price;
    private String description;
    private String category;
    boolean isNew;
    LocalDate dateAdded;

    public MenuItem(String name, double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.isNew = true;
    }

    public MenuItem(String name) {
        this(name, 0.0, "description goes here", "category goes here");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String listMenuItem() {
        return getName() + "\n" + getDescription() + "\n" + getPrice() + "\n";
    }

    void setName(String aName) {
        name = aName;
    }

    void setPrice(double aPrice) {
        price = aPrice;
    }

    void setDescription(String aDescription) {
        description = aDescription;
    }

    void setCategory(String aCategory) {
        // must be "appetizer", "main course" or "dessert"
        if (aCategory == "appetizer" || aCategory == "main course" || aCategory == "dessert") {
            category = aCategory;
        }
    }

    public boolean equals(MenuItem toBeCompared) {
        if (listMenuItem().compareTo(toBeCompared.listMenuItem()) == 0) {
            return true;
        } else {
            return false;
        }
    }
}