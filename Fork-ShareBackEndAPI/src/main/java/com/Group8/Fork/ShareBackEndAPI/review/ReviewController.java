package com.Group8.Fork.ShareBackEndAPI.review;

import com.Group8.Fork.ShareBackEndAPI.recipe.Recipe;
import com.Group8.Fork.ShareBackEndAPI.recipe.RecipeService;
import com.Group8.Fork.ShareBackEndAPI.chef.Chef;
import com.Group8.Fork.ShareBackEndAPI.chef.ChefService;
import com.Group8.Fork.ShareBackEndAPI.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private  ChefService chefService;


    @Autowired
    private UserService userService;


    @GetMapping("/all")

    //return all reviews
    public Object getAllReviews(){
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    //return review by Id
    @GetMapping("/{reviewId}")
    public Object getOneReview(@PathVariable int reviewId){
        return new ResponseEntity<>(reviewService.getReviewById(reviewId), HttpStatus.OK);
    }

    //create a new review
    @PostMapping("/new")
    public Object addNewReview(@RequestBody Review review) {
        reviewService.addNewReview(review);
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.CREATED);
    }

    //delete a review
    @DeleteMapping("/delete/{reviewId}")
    public Object deleteReviewById(@PathVariable int reviewId){
        reviewService.deleteReviewById(reviewId);
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    //update a review
    @PutMapping("/update/{reviewId}")
    public Object updateReview(@PathVariable int reviewId, @RequestBody Review review){
        reviewService.updateReview(reviewId, review);
        return new ResponseEntity<>(reviewService.getReviewById(reviewId), HttpStatus.CREATED);
    }
}
