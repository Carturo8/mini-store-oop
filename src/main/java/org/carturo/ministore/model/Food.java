package org.carturo.ministore.model;

public class Food extends Product {

    public Food(String name, double price) {
        super(name, price);
    }

    @Override
    public String getDescription() {
        return "Food product: Suitable for daily consumption.";
    }
}