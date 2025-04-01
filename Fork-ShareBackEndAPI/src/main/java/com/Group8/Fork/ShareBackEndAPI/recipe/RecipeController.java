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

    //return a single recipe
    @GetMapping("/{recipeId}")
        public Object getOneRecipe(@PathVariable int recipeId){
            return new ResponseEntity<>(recipeService.getRecipeById(recipeId), HttpStatus.OK);
        }


    //return all recipes by diet
    @GetMapping("/diet/{diet}")
    public Object getRecipesByDiet(@PathVariable String diet){
        return new ResponseEntity<>(recipeService.getRecipesByDiet(diet), HttpStatus.OK);
    }

    //creating a new recipes
    @PostMapping("/new")
    public Object addNewRecipe(@RequestBody Recipe recipe){
        recipeService.addNewRecipe(recipe);
        return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.CREATED);
    }

    //update an existing recipe
    @PutMapping("/update/{recipeId}")
    public Object updateRecipe(@PathVariable int recipeId, @RequestBody Recipe recipe){
        recipeService.updateRecipe(recipeId, recipe);
        return new ResponseEntity<>(recipeService.getRecipeById(recipeId), HttpStatus.CREATED);
    }

    //delete an existing recipe
    @DeleteMapping("/delete/{recipeId}")
        public Object deleteRecipeById(@PathVariable int recipeId){
            recipeService.deleteRecipeById(recipeId);
            return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
        }
}
