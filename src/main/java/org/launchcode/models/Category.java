package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

// This Category class is used to categorize cheese objects to allow users to
// create new categories themselves

// @Entity maps the class to an RD table and its fields to table columns
@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    // list will represent the list of all items in a given category
    // one-to-many relationship established with foreign key category_id
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();

    // hibernate uses constructors to create objects from the
    // data retrieved from the database
    public Category() { }

    // a constructor that accepts a parameter to set name
    public Category(String name) {
        this.name = name;
    }

    // no setter for id since other classes should not be able to change our ID!
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // used in cheeseController value = "remove" to get list of cheeses for a given category
    // to remove them from data layer
    public List<Cheese> getCheeses() {
        return cheeses;
    }
}
