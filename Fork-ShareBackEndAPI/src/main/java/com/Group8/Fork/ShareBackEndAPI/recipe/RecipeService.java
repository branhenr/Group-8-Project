package com.Group8.Fork.ShareBackEndAPI.recipe;

import com.Group8.Fork.ShareBackEndAPI.chef.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ChefRepository chefRepository;

    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(int recipeId){
        return recipeRepository.findById(recipeId).orElse(null);
    }

    public List<Recipe> getRecipesByDiet(String diet){
        return recipeRepository.getRecipesByDiet(diet);
    }

    public void addNewRecipe(Recipe recipe){
        recipeRepository.save(recipe);
    }

    public void updateRecipe(int recipeId, Recipe recipe){
        recipeRepository.save(recipe);
    }

    public void updateRecipe( Recipe recipe){
        recipeRepository.save(recipe);
    }


    public void deleteRecipeById(int recipeId){
        recipeRepository.deleteById(recipeId);
    }

    public List<Recipe> getRecipesByChef(int chefId){
        return recipeRepository.getRecipeByChefId(chefId);
    }
}
