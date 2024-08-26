/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.aristeobillingsystem.model.Customer;
import ec.edu.espe.aristeobillingsystem.model.Product;
import ec.edu.espe.aristeobillingsystem.model.User;
import java.util.List;
import java.util.ArrayList;
import org.bson.Document;

public class MongoDbManager {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    static {
        try {
            mongoClient = MongoClients.create("mongodb+srv://Jenni:Jenni@cluster0.tjpvdfr.mongodb.net/");
            database = mongoClient.getDatabase("Aristeo");
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con MongoDB: " + e.getMessage(), e);
        }
    }

    private static MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public static void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }

        MongoCollection<Document> collection = getCollection("Products");
        Document document = new Document("id", product.getId())
            .append("name", product.getName())
            .append("price", product.getPrice())
            .append("stock", product.getStock());
        collection.insertOne(document);
    }

    public static List<Product> getAllProducts() {
        MongoCollection<Document> collection = getCollection("Products");
        List<Product> products = new ArrayList<>();
        for (Document doc : collection.find()) {
            int id = doc.getInteger("id", -1); 
            String name = doc.getString("name");
            
            Object value = doc.get("price");
            double price = 0.0;
            if (value instanceof Double) {
                price = (Double) value;
            } else if (value instanceof Integer) {
                price = ((Integer) value).doubleValue();
            }
            
            int stock = doc.getInteger("stock", 0); 
            products.add(new Product(id, name, price, stock));
        }
        return products;
    }

    public static void removeProduct(int productId) {
        MongoCollection<Document> collection = getCollection("Products");
        Document query = new Document("id", productId);
        collection.deleteOne(query);
    }
    
    public static void createCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }

        MongoCollection<Document> collection = getCollection("Customers");
        Document document = new Document("dni", customer.getDni())
            .append("name", customer.getName())
            .append("email", customer.getEmail())
            .append("phone", customer.getPhone());
        collection.insertOne(document);
    }
    public static void addCustomer(Customer customer) {
        MongoCollection<Document> collection = database.getCollection("Customers");
        Document doc = new Document("dni", customer.getDni())
                .append("name", customer.getName())
                .append("email", customer.getEmail())
                .append("phone", customer.getPhone());
        collection.insertOne(doc);
    }
    public static void removeCustomer(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI del cliente no puede ser nulo o vacío.");
        }

        MongoCollection<Document> collection = getCollection("Customers");
        Document query = new Document("dni", dni);
        collection.deleteOne(query);
    }

    public static List<Customer> getAllCustomers() {
        MongoCollection<Document> collection = getCollection("Customers");
        List<Customer> customers = new ArrayList<>();
        for (Document doc : collection.find()) {
            String dni = doc.getString("dni");
            String name = doc.getString("name");
            String email = doc.getString("email");
            String phone = doc.getString("phone");
            customers.add(new Customer(dni, name, email, phone));
        }
        return customers;
    }

    public static void saveUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }

        MongoCollection<Document> collection = getCollection("Users");
        Document document = new Document("username", user.getUsername())
            .append("password", user.getPassword()) 
            .append("role", user.getRole());
        collection.insertOne(document);
    }

    public static User findUserByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede ser nulo o vacío.");
        }

        MongoCollection<Document> collection = getCollection("Users");
        Document query = new Document("username", username);
        Document userDoc = collection.find(query).first();

        if (userDoc != null) {
            String password = userDoc.getString("password");
            String role = userDoc.getString("role");
            return new User(username, password, role);
        }
        return null;
    }
}
