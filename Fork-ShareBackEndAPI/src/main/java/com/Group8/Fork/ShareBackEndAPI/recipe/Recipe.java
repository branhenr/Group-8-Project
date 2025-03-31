package com.Group8.Fork.ShareBackEndAPI.recipe;

import com.Group8.Fork.ShareBackEndAPI.chef.Chef;
import jakarta.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;

    private int prepTime;

    private String name;

    private String foodType;

    private String diet;

    @ManyToOne
    @JoinColumn(name = "chefId")
    private Chef chef;

    public Recipe(int recipeId, int prepTime, String name, String foodType, String diet){
        this.recipeId = recipeId;
        this.prepTime = prepTime;
        this.name = name;
        this.foodType = foodType;
        this.diet = diet;
    }

    public Recipe(int recipeId, int prepTime, String name, String foodType, String diet, Chef chef){
        this.recipeId = recipeId;
        this.prepTime = prepTime;
        this.name = name;
        this.foodType = foodType;
        this.diet = diet;
        this.chef = chef;
    }

    public Recipe( int prepTime, String name, String foodType, String diet, Chef chef){
        this.prepTime = prepTime;
        this.name = name;
        this.foodType = foodType;
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

    public String getFoodType(){
        return foodType;
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

    public void setFoodType(String foodType){
        this.foodType = foodType;
    }

    public void setDiet(String diet){
        this.diet = diet;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    @Override
    public String toString(){
        return "Recipes{" +
                "recipeID = " + recipeId +
                ", prepTime=" + prepTime +
                ", name ='" + name + '\'' +
                ", foodType ='" + foodType + '\'' +
                ", diet ='" + diet + '\'' +
                ", chef =" + chef +
                '}';
    }

}
