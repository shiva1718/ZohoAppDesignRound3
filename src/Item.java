package org.shiva;

public class Item {
    private int costPrice;
    private int sellingPrice;
    private String name;
    private int netProfit;

    public Item(int cp, int sp, String itemName) {
        costPrice = cp;
        sellingPrice = sp;
        name = itemName;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNetProfit() {
        return netProfit;
    }

    @Override
    public String toString() {
        return name + "(" + sellingPrice + ")";
    }

    public void incrementProfit() {
        netProfit += sellingPrice - costPrice;
    }
}
