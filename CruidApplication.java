import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ProductManager {
    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully.");
    }

    public void updateProduct(String id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId().equals(id)) {
                products.set(i, updatedProduct);
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId().equals(id)) {
                products.remove(i);
                System.out.println("Product deleted successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        System.out.println("Product List:");
        for (Product product : products) {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("-------------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a product");
            System.out.println("2. Update a product");
            System.out.println("3. Delete a product");
            System.out.println("4. Display all products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the product ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter the product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the product price: ");
                    double price = scanner.nextDouble();

                    Product newProduct = new Product(id, name, price);
                    productManager.addProduct(newProduct);
                    break;

                case 2:
                    System.out.print("Enter the product ID to update: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Enter the updated product name: ");
                    String updatedName = scanner.nextLine();

                    System.out.print("Enter the updated product price: ");
                    double updatedPrice = scanner.nextDouble();

                    Product updatedProduct = new Product(updateId, updatedName, updatedPrice);
                    productManager.updateProduct(updateId, updatedProduct);
                    break;

                case 3:
                    System.out.print("Enter the product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    productManager.deleteProduct(deleteId);
                    break;

                case 4:
                    productManager.displayProducts();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // Add an empty line for better readability
        }
    }
}

