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

    public void addNewRecipe(Recipe recipe){
        recipeRepository.save(recipe);
    }
}
