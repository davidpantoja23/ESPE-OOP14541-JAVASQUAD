/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.billing_system_maven.model;

import org.bson.Document;

/**
 *
 * @author Jenniffer Marquez, Javasquad, DCCO-ESPE
 */
public class Producto {

    private String id;
    private String nombre;
    private String descripcion;
    private float precio;
    private String categoria;
    private int stock;
    private String ingreso;
    private String egreso;

    public Producto(String id, String nombre, String descripcion, float precio, String categoria, int stock, String ingreso, String egreso) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the ingreso
     */
    public String getIngreso() {
        return ingreso;
    }

    /**
     * @param ingreso the ingreso to set
     */
    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return the egreso
     */
    public String getEgreso() {
        return egreso;
    }

    /**
     * @param egreso the egreso to set
     */
    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

    public Document toDocument() {
        return new Document("id", this.id)
                .append("nombre", this.nombre)
                .append("descripcion", this.descripcion)
                .append("precio", this.precio)
                .append("categoria", this.categoria)
                .append("stock", this.stock)
                .append("ingreso", this.ingreso)
                .append("egreso", this.egreso);
    }

}
