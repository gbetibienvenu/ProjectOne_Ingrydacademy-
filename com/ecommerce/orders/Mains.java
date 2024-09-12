package com.ecommerce.orders;

import ecommerce.Customer;
import ecommerce.Product;
import java.util.ArrayList;
import java.util.List;

public class Mains {
        public static void main(String[] args) {
            // Create Products
            Product product1 = new Product(101, "Laptop", 800);
            Product product2 = new Product(102, "Smartphone", 500);
            Product product3 = new Product(103, "Headphones", 50);

            // Create a Customer
            Customer customer = new Customer(201, "John Doe");

            // Add Products to Shopping Cart
            customer.addToCart(product1);
            customer.addToCart(product2);
            customer.addToCart(product3);

            // Display total cost
            System.out.println("Total Cart Cost: $" + customer.calculateTotalCost());

            // Create an Order
            List<Product> products = new ArrayList<>(customer.getShoppingCart());
            Order order = new Order(301, customer, products);

            // Display Order Summary
            System.out.println(order.getOrderSummary());
        }
}
