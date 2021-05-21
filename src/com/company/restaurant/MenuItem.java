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

    void setPrice(double aPrice) {
        price = aPrice;
    }

    void setDescription(String aDescription) {
        description = aDescription;
    }

    void setCategory(String aCategory) {
        // must be "appetizer", "main course" or "dessert"
        if (aCategory.equals("appetizer") || aCategory.equals("main course") || aCategory.equals("dessert")) {
            category = aCategory;
        }
    }

    @Override
    public boolean equals(final Object objToBeCompared) {
        if (this == objToBeCompared) {
            return true;
        }
        if (objToBeCompared == null) {
            return false;
        }
        if (getClass() != objToBeCompared.getClass()) {
            return false;
        }
        final MenuItem menuItemToBeCompared = (MenuItem) objToBeCompared;
        if (name == null) {
            return menuItemToBeCompared.name == null;
        } else return name.equals(menuItemToBeCompared.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}