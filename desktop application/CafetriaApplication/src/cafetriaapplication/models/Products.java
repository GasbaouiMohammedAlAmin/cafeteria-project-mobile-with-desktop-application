/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafetriaapplication.models;

/**
 *
 * @author amine gasa
 */
public class Products {
    int id	;
    String designation;
   float price;
   String description;

    public Products(int id, String designation, float price, String description) {
        this.id = id;
        this.designation = designation;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
