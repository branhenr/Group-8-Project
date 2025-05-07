package com.Group8.Fork.ShareBackEndAPI.recipe;

import com.Group8.Fork.ShareBackEndAPI.chef.Chef;
import com.Group8.Fork.ShareBackEndAPI.chef.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

//@RestController
@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private  ChefService chefService;

    //return all recipes
    @GetMapping("/all")
    public Object getAllRecipes(Model model){
        //return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
        model.addAttribute("recipeList", recipeService.getAllRecipes());
        model.addAttribute("title", "All recipes");
        return "recipe/recipe-list";
    }

    //return a single recipe
    @GetMapping("/{recipeId}")
        public Object getOneRecipe(@PathVariable int recipeId, Model model){
            //return new ResponseEntity<>(recipeService.getRecipeById(recipeId), HttpStatus.OK);
            model.addAttribute("recipe", recipeService.getRecipeById(recipeId));
            model.addAttribute("title", "Recipe #: " + recipeId);
            return "recipe/recipe-details";
        }


    //return all recipes by diet
    @GetMapping("/diet/{diet}")
    public Object getRecipesByDiet(@PathVariable String diet){
        return new ResponseEntity<>(recipeService.getRecipesByDiet(diet), HttpStatus.OK);
    }

    //show form to create a new recipe
    @GetMapping("/createForm")
    public String showCreateForm(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        model.addAttribute("title", "Create New Recipe");
        return "recipe/recipe-create";
    }

    //creating a new recipes
    @PostMapping("/new")
    public Object addNewRecipe(Recipe recipe, Model model){
       // if (recipe.getChef().getChefId() == -1)
         //   recipe.setChef(null);
        recipeService.addNewRecipe(recipe);
        //return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.CREATED);
        return"redirect:/recipes/all";
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
            //return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
            return "redirect:/recipes/all";
        }
}
