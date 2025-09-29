# 🛒 Mini Store OOP

> 📄 This README is also available in [Spanish 🇪🇸](README.es.md)

A simple **inventory management system** built with **Java, Object-Oriented Programming (OOP), and basic data structures**.  
It allows you to add, list, purchase, search, and generate statistics for products using a Swing-based menu interface (`JOptionPane`).

---

## ✨ Features

- ➕ Add new products (Food / Appliance) to inventory
- 📋 List all products with price, stock, and description
- 🛒 Purchase products with stock validation and subtotal calculation
- 📊 Show statistics: most expensive and cheapest product
- 🔎 Search products by partial name matches
- 🧾 Generate a final receipt with total purchases
- ⚠️ Input validations for numbers, empty values, and duplicates

---

## 🖼️ Preview

Here’s a preview of the application’s main menu:

![Menu Preview](assets/menu-preview.png)

---

## 📂 Project Structure

```bash
mini-store-oop/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org.carturo.ministore/
│   │   │       ├── Main.java
│   │   │       ├── model/
│   │   │       │   ├── Product.java
│   │   │       │   ├── Food.java
│   │   │       │   └── Appliance.java
│   │   │       ├── service/
│   │   │       │   └── InventoryService.java
│   │   │       └── util/
│   │   │           └── Validation.java
├── .gitignore
├── LICENSE
├── pom.xml
├── README.md
└── README.es.md
```

---

## ⚙️ Requirements

- JDK 21+ (tested with JDK 24)
- Maven 3
- IntelliJ IDEA or any Java IDE
- No additional libraries required

---

## ▶️ Run the Application

1. Compile the project in your IDE.
2. Run `Main.java`.
3. Interact with the Swing-based menu to manage the inventory.

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).