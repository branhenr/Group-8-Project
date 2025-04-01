package com.Group8.Fork.ShareBackEndAPI.review;

import com.Group8.Fork.ShareBackEndAPI.chef.ChefRepository;
import com.Group8.Fork.ShareBackEndAPI.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ChefRepository chefRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Review getReviewById(int reviewId){
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public void addNewReview(Review review){
        reviewRepository.save(review);
    }

    public void deleteReviewById(int reviewId){
        reviewRepository.deleteById(reviewId);
    }

    public void updateReview(int reviewId, Review review){
        Review existing = getReviewById(reviewId);
        reviewRepository.save(existing);
    }
}
