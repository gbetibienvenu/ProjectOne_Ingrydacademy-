package ecommerce;
import java.util.ArrayList;
import java.util.List;
public class Customer {
        private int customerID;
        private String name;
        private List<Product> shoppingCart;

        // Constructor
        public Customer(int customerID, String name) {
            this.customerID = customerID;
            this.name = name;
            this.shoppingCart = new ArrayList<>();
        }

        // Methods to add and remove products from cart
        public void addToCart(Product product) {
            shoppingCart.add(product);
        }

        public void removeFromCart(Product product) {
            shoppingCart.remove(product);
        }

        // Calculate total cost
        public double calculateTotalCost() {
            double total = 0;
            for (Product product : shoppingCart) {
                total += product.getPrice();
            }
            return total;
        }

        // Getters and Setters
        public int getCustomerID() { return customerID; }
        public String getName() { return name; }

        public List<Product> getShoppingCart() {
            return shoppingCart;
        }

        @Override
        public String toString() {
            return "Customer ID: " + customerID + ", Name: " + name;
        }
}
