package com.Group8.Fork.ShareBackEndAPI.recipe;

import com.Group8.Fork.ShareBackEndAPI.chef.Chef;
import jakarta.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;

    private String name;

    private int prepTime;

    private String description;

    private String diet;

    @ManyToOne
    @JoinColumn(name = "chefId")
    private Chef chef;


    public Recipe(int recipeId, String name, int prepTime, String description, String diet, Chef chef){
        this.recipeId = recipeId;
        this.name = name;
        this.prepTime = prepTime;
        this.description = description;
        this.diet = diet;
        this.chef = chef;
    }

    public Recipe(String name, int prepTime, String description, String diet, Chef chef){
        this.name = name;
        this.prepTime = prepTime;
        this.description = description;
        this.diet = diet;
        this.chef = chef;
    }

    public Recipe(){

    }

    //getter methods
    public int getRecipeId(){
        return recipeId;
    }

    public int getPrepTime(){
        return prepTime;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getDiet(){
        return diet;
    }

    public Chef getChef(){
        return chef;
    }

    //setter methods
    public void setRecipeId(int recipeId){
        this.recipeId = recipeId;
    }

    public void setPrepTime(int prepTime){
        this.prepTime = prepTime;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setDiet(String diet){
        this.diet = diet;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

}
