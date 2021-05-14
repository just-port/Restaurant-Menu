package com.company.restaurant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MenuItem {
    // possible fields: name, price, description, category(appetizer, main course, dessert), date released

    private String name;
    private double price;
    private String description;
    private String category;


    public MenuItem(String name, double price, String description, String category) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;

    }


    public MenuItem(String name) {

        this.name = name;
        this.price = 0.0;
        this.description = "description incoming";
        this.category = "category incoming";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private DateTimeFormatter aFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

    public String getDateAdded() {

        LocalDateTime date = LocalDateTime.now();
        String dateAdded = date.format(aFormatter);

        return dateAdded;
    }

}
