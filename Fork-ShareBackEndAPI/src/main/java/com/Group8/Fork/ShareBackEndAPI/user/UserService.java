package com.Group8.Fork.ShareBackEndAPI.user;

import com.Group8.Fork.ShareBackEndAPI.recipe.Recipe;
import com.Group8.Fork.ShareBackEndAPI.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByID(int userID) {
        return userRepository.findById(userID).orElse(null);
    }

    public List<User> getUsersByUsername(String username) {
        return userRepository.getUsersByUsername(username);
    }

    // add new user
    public void addNewUser(User user) {
        userRepository.save(user);
    }

//update user acc
    public void updateUser(int userID, User user) {
         userRepository.save(user);
        }

        // delete acc

    public void deleteUserById(int userID) {
        userRepository.deleteById(userID);
    }


    //save recipe
    public void saveRecipeForUser(int userID, int recipeId) {
        User user = getUserByID(userID);
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();
        user.saveRecipe(recipe);
        userRepository.save(user);
    }

   //unsave recipe
    public void unsaveRecipeForUser (int userID, int recipeId) {
        User user = getUserByID(userID);
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();
        user.unsaveRecipe(recipe);
        userRepository.save(user);
    }


    public List<Recipe> getSavedRecipes(int userID) {
        return getUserByID(userID).getSavedRecipes();
    }


    public String getSavedRecipes() {
        return null;
    }
}

