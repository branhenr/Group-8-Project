package com.Group8.Fork.ShareBackEndAPI.user;

import com.Group8.Fork.ShareBackEndAPI.recipe.Recipe;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

     private int userID;

    @ManyToMany
    @JoinTable(
            name = "user_savedRecipes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
     private List<Recipe> savedRecipes = new ArrayList<>();


    private String username;
     private String email;
     private String password;

     public  User(int userID, String username, String email, String password) {
         this.userID = userID;
         this.username = username;
         this.email = email;
         this.password = password;
     }

     public User (String username, String email, String password) {
         this.username = username;
         this.email = email;
         this.password = password;
     }

     public User() { }

    // Getters

    public int getUserID() {
         return userID;
     }
     public String getUsername() {
         return username;
     }
     public String getEmail() {
         return email;
     }
     public List<Recipe> getSavedRecipes () {
         return savedRecipes;
     }

     public String getPassword() {
         return password;
     }


     // Setters

    public void setUserID( int userID)  {
         this.userID = userID;
    }

    public void setUsername (String username) {
         this.username = username;
    }

    public void setEmail (String email) {
         this.email = email;

    }


    public void setPassword (String password) {
         this.password = password;
    }

    public void setSavedRecipes(List<Recipe> savedRecipes) {
         this.savedRecipes = savedRecipes;
    }

    public void saveRecipe (Recipe recipe) {
         this.savedRecipes.add(recipe);
    }

    public void  unsaveRecipe(Recipe recipe) {
         this.savedRecipes.remove(recipe);
    }

}
