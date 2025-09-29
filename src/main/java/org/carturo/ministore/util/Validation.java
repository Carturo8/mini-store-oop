package org.carturo.ministore.util;

import javax.swing.*;

public class Validation {
    public static String askText(String message) {
        String text;
        do {
            text = JOptionPane.showInputDialog(null, message);
        } while (text == null || text.trim().isEmpty());
        return text.trim();
    }

    public static double askNumber(String message) {
        double number = -1;
        boolean valid = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, message);
                if (input == null || input.trim().isEmpty()) continue;
                number = Double.parseDouble(input);
                if (number >= 0) valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number.");
            }
        } while (!valid);
        return number;
    }

    public static int askInteger(String message) {
        int number = -1;
        boolean valid = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, message);
                if (input == null || input.trim().isEmpty()) continue;
                number = Integer.parseInt(input);
                if (number >= 0) valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number.");
            }
        } while (!valid);
        return number;
    }
}