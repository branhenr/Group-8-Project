package com.Group8.Fork.ShareBackEndAPI.recipe;

import com.Group8.Fork.ShareBackEndAPI.chef.Chef;
import com.Group8.Fork.ShareBackEndAPI.chef.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private  ChefService chefService;

    //return all recipes
    @GetMapping("/all")
    public Object getAllRecipes(){
        return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
    }

    //creating a new recipes
    @PostMapping("/new")
    public Object addNewRecipe(Recipe recipe){
        recipeService.addNewRecipe(recipe);
        return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
    }
}
