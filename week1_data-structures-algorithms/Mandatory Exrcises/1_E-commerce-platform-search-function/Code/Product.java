// step 2
public class Product {
    public String productId;
    public String productName;
    public String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public void display() {
        System.out.println("Id: " + productId + ", Name: " + productName + ", Category: " + category);
    }
}