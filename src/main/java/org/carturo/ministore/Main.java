package org.carturo.ministore;

import org.carturo.ministore.model.Food;
import org.carturo.ministore.model.Appliance;
import org.carturo.ministore.model.Product;
import org.carturo.ministore.service.InventoryService;
import org.carturo.ministore.util.Validation;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();

        String menu = """
            Mini Store Menu:
            1. Add product
            2. List inventory
            3. Purchase product
            4. Statistics
            5. Search product
            6. Exit
            """;

        String input;
        int operation = -1;

        do {
            input = JOptionPane.showInputDialog(null, menu, "Mini Store", JOptionPane.PLAIN_MESSAGE);

            if (input != null && !input.trim().isEmpty()) {
                try {
                    operation = Integer.parseInt(input.trim());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid option. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a number option.", "Warning", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            switch (operation) {
                case 1 -> { // Add product
                    String type = Validation.askText("Product type (Food/Appliance):");
                    String name = Validation.askText("Product name:");
                    double price = Validation.askNumber("Product price:");
                    int stock = Validation.askInteger("Initial stock:");

                    Product product;
                    if (type.equalsIgnoreCase("Food")) {
                        product = new Food(name, price);
                    } else if (type.equalsIgnoreCase("Appliance")) {
                        product = new Appliance(name, price);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid type.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    inventory.addProduct(product, stock);
                }
                case 2 -> inventory.listInventory();
                case 3 -> {
                    String name = Validation.askText("Product name to purchase:");
                    int quantity = Validation.askInteger("Quantity to purchase:");
                    inventory.purchaseProduct(name, quantity);
                }
                case 4 -> inventory.showStatistics();
                case 5 -> {
                    String name = Validation.askText("Name to search:");
                    inventory.searchProduct(name);
                }
                case 6 -> {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to exit?",
                            "Exit Confirmation",
                            JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        inventory.showFinalReceipt();
                        System.exit(0);
                    }
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please choose between 1 and 6.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (true);
    }
}