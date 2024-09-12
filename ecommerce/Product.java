package ecommerce;

public class Product {
        private int productID;
        private String name;
        private double price;

        // Constructor
        public Product(int productID, String name, double price) {
            this.productID = productID;
            this.name = name;
            this.price = price;
        }

        // Getters
        public int getProductID() { return productID; }
        public String getName() { return name; }
        public double getPrice() { return price; }

        // Setters
        public void setProductID(int productID) { this.productID = productID; }
        public void setName(String name) { this.name = name; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return "Product ID: " + productID + ", Name: " + name + ", Price: $" + price;
        }
}
