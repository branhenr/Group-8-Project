package com.Group8.Fork.ShareBackEndAPI.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired

    private UserRepository userRepository;
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
        User existing = getUserByID(userID);
        existing.setUserID(user.getUserID());
        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());


        }

        // delete acc

    public void deleteUserById(int userID) {
        userRepository.deleteByID(userID);
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


}

