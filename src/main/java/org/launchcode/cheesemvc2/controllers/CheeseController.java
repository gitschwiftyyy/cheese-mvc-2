package org.launchcode.cheesemvc2.controllers;

import org.launchcode.cheesemvc2.models.Cheese;
import org.launchcode.cheesemvc2.models.CheeseType;
import org.launchcode.cheesemvc2.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by schwifty on 10/27/17.
 */
@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    //static ArrayList<HashMap> cheeses = new ArrayList<>();

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", cheeseDao.findAll());
        return "cheese/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("cheese", new Cheese());
        model.addAttribute("title", "Add Cheese");
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese, Model model) {

        if (newCheese.getName().length() < 3 || newCheese.getName().length() > 15) {
            model.addAttribute("nameError", "Name must be between 3-15 characters");

            if (newCheese.getDescription().length() < 1) {
                model.addAttribute("descriptionError", "Add a description");

            }
            model.addAttribute("cheese", new Cheese());
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }

        if (newCheese.getDescription().length() < 1) {
            model.addAttribute("descriptionError", "Add a description");

            if (newCheese.getName().length() < 3 || newCheese.getName().length() > 15) {
                model.addAttribute("nameError", "Name must be between 3-15 characters");

            }
            model.addAttribute("cheese", new Cheese());
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }

        cheeseDao.save(newCheese);


        return "redirect:";
    }

    @RequestMapping(value="remove", method = RequestMethod.GET)
    public String removeCheeseForm(Model model) {

        model.addAttribute("title", "Remove Cheeses");
        model.addAttribute("cheeses", cheeseDao.findAll());
        return "cheese/remove";
    }
    @RequestMapping(value="remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            cheeseDao.delete(cheeseId);
        }
        return "redirect:";
    }

//    @RequestMapping(value="edit/{id}", method = RequestMethod.GET)
//    public String displayEditForm(Model model, @PathVariable int id) {
//        Cheese cheese = CheeseData.getById(id);
//        model.addAttribute("title", "Edit Cheese");
//        model.addAttribute("cheese", cheese);
//        return "cheese/edit";
//    }
//
//    @RequestMapping(value = "edit", method = RequestMethod.POST)
//    public String processEditForm(int id, @RequestParam String name, @RequestParam String description) {
//        Cheese cheese = CheeseData.getById(id);
//        cheese.setName(name);
//        cheese.setDescription(description);
//
//        return "redirect:";
//    }
}
