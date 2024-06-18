/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.billingsystem.model;

/**
 *
 * @author Simone Medina, JavaSquad, DCCO-ESPE
 */
public class TypeOfId {
    private int id;
    private String typeName;
    private String idNumber;

    public TypeOfId(int id, String typeName, String idNumber) {
        this.id = id;
        this.typeName = typeName;
        this.idNumber = idNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}