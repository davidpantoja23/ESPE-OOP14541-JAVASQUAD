/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.AristeoSimulator.model;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Employer{
    private ind id;
    private String name;
    private String turn;
    
    public Employer(int id, String name, String turn) {
        this.id = id;
        this.name = name;
        this.turn = turn;
    }

    @Override
    public String toString() {
        return "Employer{" + "id=" + id + ", name=" + name + ", turn=" + turn + '}';
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the turn
     */
    public String getTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(String turn) {
        this.turn = turn;
    }
    
}
