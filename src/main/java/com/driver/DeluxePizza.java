package com.driver;

public class DeluxePizza extends Pizza {

    public DeluxePizza(Boolean isVeg) {
        super(isVeg);
        // your code goes here
        // extra cheese and toppings
        super.addExtraCheese();
        super.addExtraToppings();

        super.cheeseAdded = true;
        super.toppingsAdded = true;
    }
}
