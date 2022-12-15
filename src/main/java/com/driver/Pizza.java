package com.driver;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;

    private int cheesePrice;
    private int toppingsPrice;
    private int takeAwayPrice;



    public boolean isCheeseAdded;
    public boolean isToppingsAdded;
    public boolean isTakeAwayAdded;
    public boolean isBillGenerated;


    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        if(isVeg){
            this.price = 300;
            this.toppingsPrice = 70;
        }
        else{
            this.price = 400;
            this.toppingsPrice = 120;
        }

        this.bill = "Base Price Of The Pizza: " + this.price+"\n";
        this.takeAwayPrice = 20;
        this.cheesePrice = 80;

        this.isToppingsAdded = false;
        this.isCheeseAdded = false;
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        if(isCheeseAdded) return;
        this.price += this.cheesePrice;
        this.isCheeseAdded = true;
    }

    public void addExtraToppings(){
        if(this.isToppingsAdded) return;
        this.price += this.toppingsPrice;
        this.isToppingsAdded = true;
    }

    public void addTakeaway(){
        if(isTakeAwayAdded) return;


        this.price += this.takeAwayPrice;

        this.isTakeAwayAdded = true;
    }

    public String getBill(){
        if(isBillGenerated) return this.bill;
        if(isCheeseAdded){
            this.bill += "Extra Cheese Added: "+this.cheesePrice+"\n";
        }
        if(isToppingsAdded){
            this.bill += "Extra Toppings Added: "+this.toppingsPrice+"\n";
        }
        if(isTakeAwayAdded){
            this.bill += "Paperbag Added: " + this.takeAwayPrice+"\n";
        }
        this.bill += "Total Price: "+this.price+"\n";

        this.isBillGenerated = true;

        return this.bill;
    }
}
