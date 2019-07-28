package com.loftschool.syuldashev.loftmoney;

public class Item {
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private int price;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
