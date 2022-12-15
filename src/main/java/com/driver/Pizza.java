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
            this.bill = "Base Price Of The Pizza: 300\\\n";
            this.total += 300;
        }
        else{
            this.price = 400;
            this.bill = "Base Price Of The Pizza: 400\\\n";
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
                String replace = this.bill.replace("Extra Toppings Added: 70\\\n", "Extra Cheese Added: 80\\\n");
                this.bill = replace + "Extra Toppings Added: 70\\\n";
            }
            else{
                this.bill += "Extra Cheese Added: 80\\\n";
            }
            this.total += 80;
            this.cheeseAdded = true;
            return;
        }
        if(toppingsAdded){
            this.bill = this.bill.replace("Extra Toppings Added: 120\\\n","Extra Cheese Added: 80\\\n");
            this.bill += "Extra Toppings Added: 120\\\n";
        }
        else{
            this.bill += "Extra Cheese Added: 80\\\n";
        }
        this.total += 80;
        this.cheeseAdded = true;
    }

    public void addExtraToppings(){
        if(this.toppingsAdded == true){
            return;
        }
        if(isVeg){
            this.bill += "Extra Toppings Added: 70\\\n";
            this.total += 70;
            this.toppingsAdded = true;
            return;
        }
        this.bill += "Extra Toppings Added: 120\\\n";
        this.total += 120;
        this.toppingsAdded = true;
    }

    public void addTakeaway(){
        this.bill += "Paperbag Added: 20\\\n";
        this.total += 20;
    }

    public String getBill(){
        this.bill += "Total Price: " + this.total;
        return this.bill;
    }
}
