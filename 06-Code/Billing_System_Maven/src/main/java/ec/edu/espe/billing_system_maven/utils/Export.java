/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.billing_system_maven.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import java.util.List;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.billing_system_maven.model.Cajero;
import ec.edu.espe.billing_system_maven.model.Cliente;
import ec.edu.espe.billing_system_maven.model.Factura;
import ec.edu.espe.billing_system_maven.model.Producto;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Jenniffer Marquez, Javasquad, DCCO-ESPE
 */
public class Export {
    public static void guardarClienteEnMongoDB(Cliente cliente) {
        String uri = "mongodb+srv://Jenni:Jenni@cluster0.tjpvdfr.mongodb.net/";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("oop");
            MongoCollection<Document> collection = database.getCollection("Cliente");
            collection.insertOne(cliente.toDocument());
            System.out.println("Cliente guardado en MongoDB");
        } catch (Exception e) {
            System.err.println("Error al guardar el cliente en MongoDB: " + e.getMessage());
        }
    }
    
    public static void guardarFacturaEnMongoDB(Factura factura) {
        String uri = "mongodb+srv://Jenni:Jenni@cluster0.tjpvdfr.mongodb.net/";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("oop");
            MongoCollection<Document> collection = database.getCollection("Factura");
            collection.insertOne(factura.toDocument());
            System.out.println("Factura guardada en MongoDB");
        } catch (Exception e) {
            System.err.println("Error al guardar la factura en MongoDB: " + e.getMessage());
        }
    }
    
     public static void guardarProductoEnMongoDB(Producto producto) {
        String uri = "mongodb+srv://Jenni:Jenni@cluster0.tjpvdfr.mongodb.net/";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("oop");
            MongoCollection<Document> collection = database.getCollection("Producto");
            collection.insertOne(producto.toDocument());
            System.out.println("Producto guardado en MongoDB");
        } catch (Exception e) {
            System.err.println("Error al guardar el producto en MongoDB: " + e.getMessage());
        }
    }
     
    private static final String CONNECTION_STRING = "mongodb+srv://Jenni:Jenni@cluster0.tjpvdfr.mongodb.net/";
    private static final String DATABASE_NAME = "oop";
    private static final String COLLECTION_NAME = "Cajero";
    
    public static void saveCajero(Cajero cajero) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            Document document = new Document("id", cajero.getId())
                                    .append("nombre", cajero.getNombre())
                                    .append("email", cajero.getEmail())
                                    .append("contraseña", cajero.getContraseña());
            collection.insertOne(document);
            System.out.println("Cajero guardado en MongoDB");
        } catch (Exception e) {
            System.err.println("Error al guardar el cajero en MongoDB: " + e.getMessage());
        }
    }

    // Método para validar el login
    public static boolean validateLogin(String email, String contraseña) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            Document query = new Document("email", email)
                                .append("contraseña", contraseña);
            Document result = collection.find(query).first();
            return result != null;
        } catch (Exception e) {
            System.err.println("Error al validar el login en MongoDB: " + e.getMessage());
            return false;
        }
    }

    
    }

    
