package org.carturo.ministore.service;

import org.carturo.ministore.model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class InventoryService {
    private final ArrayList<Product> products;
    private final HashMap<String, Integer> stock;
    private double totalPurchases = 0;

    public InventoryService() {
        this.products = new ArrayList<>();
        this.stock = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        Optional<Product> existing = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(product.getName()))
                .findFirst();

        if (existing.isPresent()) {
            JOptionPane.showMessageDialog(null, "Product already exists.");
        } else {
            products.add(product);
            stock.put(product.getName(), quantity);
            JOptionPane.showMessageDialog(null, "Product added successfully.");
        }
    }

    public void listInventory() {
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products in inventory.");
            return;
        }

        StringBuilder sb = new StringBuilder("Inventory:\n");
        for (Product p : products) {
            sb.append(String.format("%s | Price: %.2f | Stock: %d | %s\n",
                    p.getName(), p.getPrice(), stock.get(p.getName()), p.getDescription()));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void purchaseProduct(String name, int quantity) {
        Product product = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (product == null) {
            JOptionPane.showMessageDialog(null, "Product not found.");
            return;
        }

        int currentStock = stock.get(name);
        if (quantity > currentStock) {
            JOptionPane.showMessageDialog(null, "Insufficient stock.");
            return;
        }

        stock.put(name, currentStock - quantity);
        double subtotal = product.getPrice() * quantity;
        totalPurchases += subtotal;

        JOptionPane.showMessageDialog(null, String.format(
                "Purchase successful: %s x%d → Subtotal: %.2f",
                product.getName(), quantity, subtotal));
    }

    public void showStatistics() {
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products for statistics.");
            return;
        }

        Product mostExpensive = products.get(0);
        Product cheapest = products.get(0);

        for (Product p : products) {
            if (p.getPrice() > mostExpensive.getPrice()) mostExpensive = p;
            if (p.getPrice() < cheapest.getPrice()) cheapest = p;
        }

        JOptionPane.showMessageDialog(null,
                String.format("Most expensive product: %s - %.2f\nCheapest product: %s - %.2f",
                        mostExpensive.getName(), mostExpensive.getPrice(),
                        cheapest.getName(), cheapest.getPrice()));
    }

    public void searchProduct(String name) {
        StringBuilder sb = new StringBuilder("Search results:\n");
        products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(p -> sb.append(String.format("%s | Price: %.2f | Stock: %d | %s\n",
                        p.getName(), p.getPrice(), stock.get(p.getName()), p.getDescription())));

        JOptionPane.showMessageDialog(null, sb.length() > 10 ? sb.toString() : "No matches found.");
    }

    public void showFinalReceipt() {
        JOptionPane.showMessageDialog(null, String.format("Total purchases: %.2f", totalPurchases));
    }
}