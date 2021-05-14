package com.company;

import com.company.restaurant.Menu;
import com.company.restaurant.MenuItem;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MenuItem spinDip = new MenuItem("Spinach and Artichoke Dip");

        spinDip.setCategory("Appetizers");
        spinDip.setDescription("This spinach artichoke dip is a mix of freshly cooked spinach, artichoke hearts and three types of cheese, all baked to golden brown perfection");
        spinDip.setPrice(9.50);

        MenuItem wings = new MenuItem("Buffalo Chicken Wings", 8.50, "A Buffalo wing in American cuisine, is an unbreaded chicken wing section that is generally deep-fried and then coated or dipped in a sauce consisting of a vinegar-based cayenne pepper hot sauce and melted butter prior to serving.", "Appetizers");

        Menu fastCasual = new Menu("Spanky's");

        fastCasual.addAppetizer(spinDip);
        fastCasual.addAppetizer(wings);

        fastCasual.getAppetizers();
    }
}
