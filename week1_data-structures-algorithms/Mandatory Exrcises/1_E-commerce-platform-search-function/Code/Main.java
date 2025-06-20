import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
    // step 3.1 
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // step 3.1
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0)
                return products[mid];
            else if (comparison < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        // step 3.2
        Product[] inventory = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Mouse", "Accessories"),
            new Product("P003", "Keyboard", "Accessories"),
            new Product("P004", "Phone", "Electronics"),
            new Product("P005", "Monitor", "Electronics"),
            new Product("P006", "Headphones", "Accessories"),   
            new Product("P007", "Webcam", "Accessories"),
            new Product("P008", "Printer", "Electronics"),
            new Product("P009", "Tablet", "Electronics"),
            new Product("P010", "Smartwatch", "Electronics")
        };

        Arrays.sort(inventory, Comparator.comparing(p -> p.productName.toLowerCase()));

        // linear search 
        System.out.println("Linear Search Result:");
        Product res1 = linearSearch(inventory, "Monitor");
        if (res1 != null) 
            res1.display();
        else 
            System.out.println("Product not found.");

        // binary search 
        System.out.println("\nBinary Search Result:");
        Product res2 = binarySearch(inventory, "Monitor");
        if (res2 != null) 
            res2.display();
        else 
            System.out.println("Product not found.");
    }
}