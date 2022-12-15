package com.driver;

public class Pizza {

    private int price; // calculate total price of the bill
    private Boolean isVeg;
    private String bill;

    private int cheesePrice;
    private int toppingsPrice;
    private int takeAwayPrice;



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
        if(isVeg) this.price = 300;
        else this.price = 400;

        this.bill = "Base Price Of The Pizza: " + this.price + "\\";
        this.takeAwayPrice = 20;
        this.cheesePrice = 80;

        if(isVeg) this.toppingsPrice = 70;
        else this.toppingsPrice = 120;

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
                this.bill += "\nExtra Cheese Added: " + cheesePrice + "\\";
            }
            this.price += 80;
            this.cheeseAdded = true;
            return;
        }
        if(toppingsAdded){
            this.bill = this.bill.replace("\nExtra Toppings Added: "+ toppingsPrice + "\\","\nExtra Cheese Added: " + cheesePrice + "\\");
            this.bill += "\nExtra Toppings Added: "+ toppingsPrice + "\\";
        }
        else{
            this.bill += "\nExtra Cheese Added: " + cheesePrice + "\\";
        }
        this.price += 80;
        this.cheeseAdded = true;
    }

    public void addExtraToppings(){
        if(this.toppingsAdded == true){
            return;
        }
        if(isVeg){
            this.bill += "\nExtra Toppings Added: "+ toppingsPrice + "\\";
            this.price += 70;
            this.toppingsAdded = true;
            return;
        }
        this.bill += "\nExtra Toppings Added: "+ toppingsPrice + "\\";
        this.price += 120;
        this.toppingsAdded = true;
    }

    public void addTakeaway(){
        this.bill += "\nPaperbag Added: " + takeAwayPrice + "\\";
        this.price += 20;
    }

    public String getBill(){
        this.bill += "\nTotal Price: " + this.price;
        return this.bill;
    }
}
