package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

// Many-to-many relationship - different menu samplers to different cheeses
@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @ManyToMany
    List<Cheese> cheeses = new ArrayList<>();

    // default constructor
    public Menu() {}

    // we want to be able to add items to our menu
    public void addItem(Cheese item) {
        cheeses.add(item);
    }

    public Menu(String name) {
        this.name = name;
    }

    // getters and setters although cheeses should not have a setter as we
    // do not want to change it from outside of this class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

}
