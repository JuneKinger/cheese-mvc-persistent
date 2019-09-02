package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    // creates a field categoryDao of type CategoryDao
    // This object will be what will interact with objects stored in the database
    // Spring will creates a class that implements CategoryDao and put one of those
    // objects in the categoryDao field when the application starts up
    // Every controller class that you want to have access to the persistent collections
    // defined within categoryDao needs this code to be added
    @Autowired
    private CategoryDao categoryDao;

    // the index handler /category should retrieve the list of all categories
    // - done via the categoryDao object - findAll() returns/retrieves an iterable
    // of all Category objects managed by categoryDao

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("title", "Categories");
        return "category/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("title", "Add Category");
        // use default constructor to create a new Category object into the view
        // with key "category" - note the omission of a key argument!
        model.addAttribute("category", new Category());
        return "category/add";
    }

    // pass object category across to the view add.html
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Category category, Errors errors) {

        if (errors.hasErrors()) {
            return "category/add";
        }
        categoryDao.save(category);
        return "redirect:";
    }
}
