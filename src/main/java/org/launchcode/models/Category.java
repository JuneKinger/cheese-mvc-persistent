package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// map the class to an RD table and its fields to table columns
@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

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
}
