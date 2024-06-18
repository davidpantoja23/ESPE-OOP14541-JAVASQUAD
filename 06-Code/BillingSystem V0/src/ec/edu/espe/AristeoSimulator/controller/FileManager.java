/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.AristeoSimulator.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class FileManager {
    public static void saveObjects(List<Object> objects, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(objects);
            System.out.println("Los objetos se han guardado correctamente en el archivo: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar objetos desde un archivo
    public static List<Object> loadObjects(String fileName) {
        List<Object> objects = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            objects = (List<Object>) ois.readObject();
            System.out.println("Los objetos se han cargado correctamente desde el archivo: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
