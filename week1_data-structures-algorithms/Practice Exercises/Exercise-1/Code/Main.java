import java.util.HashMap;

public class Main {
    static HashMap<String, Product> inventory = new HashMap<>();

    public static void addProduct(String id, String name, int quantity, double price) {
        inventory.put(id, new Product(id, name, quantity, price));
        System.out.println("Product added.");
    }

    public static void updateProduct(String id, int quantity, double price) {
        Product p = inventory.get(id);
        if (p != null) {
            p.setQuantity(quantity);
            p.setPrice(price);
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void deleteProduct(String id) {
        if (inventory.remove(id) != null)
            System.out.println("Product deleted.");
        else
            System.out.println("Product not found.");
    }

    public static void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        addProduct("P001", "Laptop", 5, 59999);
        addProduct("P002", "Mouse", 25, 499);
        addProduct("P003", "Keyboard", 15, 799);
        System.out.println("");

        showInventory();
        System.out.println("");

        updateProduct("P002", 30, 450);
        deleteProduct("P001");
        System.out.println("");
        
        showInventory();
    }
}