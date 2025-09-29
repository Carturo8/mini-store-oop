package org.carturo.ministore.model;

public class Appliance extends Product {

    public Appliance(String name, double price) {
        super(name, price);
    }

    @Override
    public String getDescription() {
        return "Appliance: Device designed to help with household tasks.";
    }
}