package com.ecommerce.orders;

import ecommerce.Customer;
import ecommerce.Product;
import java.util.List;

public class Order {

        private int orderID;
        private Customer customer;
        private List<Product> products;
        private double totalAmount;

        // Constructor
        public Order(int orderID, Customer customer, List<Product> products) {
            this.orderID = orderID;
            this.customer = customer;
            this.products = products;
            this.totalAmount = calculateTotalAmount();
        }

        // Method to calculate the total amount
        private double calculateTotalAmount() {
            double total = 0;
            for (Product product : products) {
                total += product.getPrice();
            }
            return total;
        }

        // Generate order summary
        public String getOrderSummary() {
            StringBuilder summary = new StringBuilder("Order ID: " + orderID + "\nCustomer: " + customer.getName() + "\nProducts:\n");
            for (Product product : products) {
                summary.append(product.toString()).append("\n");
            }
            summary.append("Total Amount: $").append(totalAmount);
            return summary.toString();
        }
}
