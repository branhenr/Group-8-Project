package com.Group8.Fork.ShareBackEndAPI.review;

import com.Group8.Fork.ShareBackEndAPI.recipe.Recipe;
import com.Group8.Fork.ShareBackEndAPI.chef.Chef;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    private int rating;

    private String details;

    @ManyToOne
    @JoinColumn(name = "chefId")
    private Chef chef;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;

    public Review(int reviewId, Recipe recipe, Chef chef, int rating, String details){
        this.reviewId = reviewId;
        this.recipe = recipe;
        this.chef = chef;
        this.rating = rating;
        this.details = details;
    }

    public Review( Recipe recipe, Chef chef, int rating, String details){
        this.recipe = recipe;
        this.chef = chef;
        this.rating = rating;
        this.details = details;
    }

    public Review(){

    }

    //getter methods
    public int getReviewId() {
        return reviewId;
    }

    public Chef getChef() {
        return chef;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public int getRating() {
        return rating;
    }

    public String getDetails() {
        return details;
    }

    //setter methods
    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
