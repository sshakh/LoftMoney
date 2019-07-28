package com.loftschool.syuldashev.loftmoney;

public enum FragmentType {

    expense(R.color.income_price_color),
    income(R.color.dark_sky_blue);

    FragmentType(int priceColor) {
        this.priceColor = priceColor;
    }

    private int priceColor;

    public int getPriceColor() {
        return priceColor;
    }
}
