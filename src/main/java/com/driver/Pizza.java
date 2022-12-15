package com.driver;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;
    private int total = 0;

    public boolean cheeseAdded;
    public boolean toppingsAdded;

//    Veg pizza base price = 300\
//    Non-veg pizza base price = 400\
//    Extra Cheese Price = 80\
//    Extra Toppings For Veg Pizza = 70\
//    Extra Toppings For Non-veg Pizza = 120\
//    Paper bag Price = 20

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        if(isVeg){
            this.price = 300;
            this.bill = "Base Price Of The Pizza: 300\\";
            this.total += 300;
        }
        else{
            this.price = 400;
            this.bill = "\nBase Price Of The Pizza: 400\\";
            this.total += 400;
        }
        this.toppingsAdded = false;
        this.cheeseAdded = false;
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        if(this.cheeseAdded == true){
            return;
        }
        if(isVeg){
            if(toppingsAdded){
                String replace = this.bill.replace("\nExtra Toppings Added: 70\\", "\nExtra Cheese Added: 80\\");
                this.bill = replace + "\nExtra Toppings Added: 70\\";
            }
            else{
                this.bill += "\nExtra Cheese Added: 80\\";
            }
            this.total += 80;
            this.cheeseAdded = true;
            return;
        }
        if(toppingsAdded){
            this.bill = this.bill.replace("\nExtra Toppings Added: 120\\","\nExtra Cheese Added: 80\\");
            this.bill += "\nExtra Toppings Added: 120\\";
        }
        else{
            this.bill += "\nExtra Cheese Added: 80\\";
        }
        this.total += 80;
        this.cheeseAdded = true;
    }

    public void addExtraToppings(){
        if(this.toppingsAdded == true){
            return;
        }
        if(isVeg){
            this.bill += "\nExtra Toppings Added: 70\\";
            this.total += 70;
            this.toppingsAdded = true;
            return;
        }
        this.bill += "\nExtra Toppings Added: 120\\";
        this.total += 120;
        this.toppingsAdded = true;
    }

    public void addTakeaway(){
        this.bill += "\nPaperbag Added: 20\\";
        this.total += 20;
    }

    public String getBill(){
        this.bill += "\nTotal Price: " + this.total;
        return this.bill;
    }
}
