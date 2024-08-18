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
import org.bson.Document;

public class MongoDbManager {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    static {
        mongoClient = MongoClients.create("mongodb+srv://Jenni:Jenni@cluster0.tjpvdfr.mongodb.net/");
        database = mongoClient.getDatabase("Aristeo");
    }

    private static MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public static void addProduct(Product product) {
        MongoCollection<Document> collection = getCollection("Products");
        Document document = new Document("id", product.getId())
            .append("name", product.getName())
            .append("price", product.getPrice())
            .append("stock", product.getStock());
        collection.insertOne(document);
    }

    public static void createCustomer(Customer customer) {
        MongoCollection<Document> collection = getCollection("Customers");
        Document document = new Document("dni", customer.getDni())
            .append("name", customer.getName())
            .append("email", customer.getEmail())
            .append("phone", customer.getPhone());
        collection.insertOne(document);
    }

    public static void saveUser(User user) {
        MongoCollection<Document> collection = getCollection("Users");
        Document document = new Document("username", user.getUsername())
            .append("password", user.getPassword()) 
            .append("role", user.getRole());
        collection.insertOne(document);
    }

    public static User findUserByUsername(String username) {
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
