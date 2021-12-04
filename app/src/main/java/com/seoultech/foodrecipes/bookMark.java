package com.seoultech.foodrecipes;

public class bookMark {
    public String foodName;
    public String foodID;
    public String foodImg;

    public bookMark(){}

    public bookMark(String foodID, String foodName, String foodImg) {
        this.foodName = foodName;
        this.foodID = foodID;
        this.foodImg = foodImg;
    }
}
