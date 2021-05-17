package com.company.restaurant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MenuItem {

    private String name;
    private double price;
    private String description;
    private String category;

    public MenuItem(String name, double price, String description, String category) {
        LocalDateTime date = LocalDateTime.now();
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public MenuItem(String name) {
        this(name, 0.0, "description incoming", "category incoming");
    }

    private DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

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

    public void setName(String aName) {
        name = aName;
    }

    public void setPrice(double aPrice) {
        price = aPrice;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public void setCategory(String aCategory) {
        category = aCategory;
    }
}
