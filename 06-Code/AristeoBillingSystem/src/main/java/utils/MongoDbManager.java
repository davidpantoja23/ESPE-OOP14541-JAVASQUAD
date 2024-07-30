/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.aristeobillingsystem.model.Customer;
import ec.edu.espe.aristeobillingsystem.model.Product;
import org.bson.Document;


/**
 *
 * @author ASUS
 */
public class MongoDbManager {
    private static MongoClient mongoClient;
    private static MongoDatabase dataBase;
    private static MongoCollection<Document> collection;
    
    static{
        MongoClientURI uri = new MongoClientURI("mongodb+srv://damorillo3:damorillo3@cluster0.f4bek4r.mongodb.net/?retryWrites=true&w=majority");
        mongoClient = new MongoClient(uri);
        dataBase = mongoClient.getDatabase("Aristeo");
        collection = dataBase.getCollection("Admin");
        collection = dataBase.getCollection("Products");
    } 
    
    public static void addProduct(Product product) {
        Document document = new Document("id", product.getId()).append("name", product.getName()).append("price", product.getPrice()).append("stock", product.getStock());
        collection.insertOne(document);
    }
    
    
}
