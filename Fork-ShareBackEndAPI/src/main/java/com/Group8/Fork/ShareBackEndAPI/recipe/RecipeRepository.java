package com.Group8.Fork.ShareBackEndAPI.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    List<Recipe> getRecipesByDiet(String diet);

    @Query(value = "SELECT * FROM RECIPES r WHERE r.chef_id = ?1", nativeQuery = true)
    List<Recipe> getRecipeByChefId(int chefId);



}
