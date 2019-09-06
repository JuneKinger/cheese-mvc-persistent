package org.launchcode.models.forms;

import org.launchcode.models.Cheese;
import org.launchcode.models.Menu;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {

    // the following 2 fields renders the form
    private Menu menu;

    // renders the drop down in add-item
    private Iterable<Cheese> cheeses;


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Iterable<Cheese> getCheeses() {
        return cheeses;
    }

    public void setCheeses(Iterable<Cheese> cheeses) {
        this.cheeses = cheeses;
    }

    // the following 2 fields accesses the form - passes in to post handler
    // specifies the 2 objects
    @NotNull
    private int menuId;
    @NotNull
    private int cheeseId;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    // default constructor is needed for model binding to work
    public AddMenuItemForm() {
    }

    // constructor to accept and set values for menu and cheeses
    public AddMenuItemForm(Menu menu, Iterable<Cheese> cheeses) {
        this.menu = menu;
        this.cheeses = cheeses;
    }
}
