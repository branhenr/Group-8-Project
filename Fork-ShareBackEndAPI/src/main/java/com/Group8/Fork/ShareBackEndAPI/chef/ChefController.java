package com.Group8.Fork.ShareBackEndAPI.chef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.Group8.Fork.ShareBackEndAPI.recipe.Recipe;
import com.Group8.Fork.ShareBackEndAPI.recipe.RecipeService;


//@RestController
@Controller
@RequestMapping("/chefs")
public class ChefController {

    @Autowired
    private ChefService service;

    @Autowired
    private RecipeService recipeService;

    //return all chefs
    @GetMapping("/all")
    public Object getAllChefs(Model model) {
        //return new ResponseEntity<>(service.getAllChefs(), HttpStatus.OK);
        model.addAttribute("chefList", service.getAllChefs());
        model.addAttribute("title", "All Chefs");
        return "chef-list";
    }

    //return a chef by Id
    @GetMapping("/{chefId}")
    public Object getOneChef(@PathVariable int chefId, Model model){
        //return new ResponseEntity<>(service.getChefById(chefId), HttpStatus.OK);
        model.addAttribute("chef", service.getChefById(chefId));
        model.addAttribute("chefRecipesList", recipeService.getRecipesByChef(chefId));
        model.addAttribute("title", "Chef #: " + chefId);
        return "chef-details";
    }

    //return chef by name
    @GetMapping("/name")
    public Object getChefsByName(@RequestParam(name = "search", defaultValue = "") String search){
        return new ResponseEntity<>(service.getChefsByName(search), HttpStatus.OK);
    }

    //show form to create a profile for chef
    @GetMapping("/createForm")
    public String showCreateForm(Model model){
        Chef chef = new Chef();
        model.addAttribute("chef", chef);
        model.addAttribute("title", "Create New Chef");
        return "chef-create";
    }


    //creating a new chef
    @PostMapping("/new")
    public Object addNewChef(Chef chef, Model model) {
        service.addNewChef(chef);
        //return new ResponseEntity<>(service.getAllChefs(), HttpStatus.CREATED);
        return "redirect:/chefs/all";
    }

    //show update form
    @GetMapping("/update/{chefId}")
    public Object showUpdateForm(@PathVariable int chefId, Model model){
        model.addAttribute("chef", service.getChefById(chefId));
        model.addAttribute("title", "Update Chef #: " + chefId);
        return "chef-update";
    }

    //updating an existing chef
    @PostMapping("/update/{chefId}")
    public Object updateChef(@PathVariable int chefId, Chef chef ){
        service.updateChef(chefId, chef);
        //return new ResponseEntity<>(service.getChefById(chefId), HttpStatus.CREATED);
        return "redirect:/chefs/" + chefId;
    }

    //delete a chef
    @GetMapping("/delete/{chefId}")
    public Object deleteChefById(@PathVariable int chefId){
        for (Recipe recipe : recipeService.getRecipesByChef(chefId))
            recipeService.deleteRecipeById(recipe.getRecipeId());
        service.deleteChefById(chefId);
        //return new ResponseEntity<>(service.getAllChefs(), HttpStatus.OK);
        return "redirect:/chefs/all";
    }

}
