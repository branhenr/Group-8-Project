package com.Group8.Fork.ShareBackEndAPI.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
