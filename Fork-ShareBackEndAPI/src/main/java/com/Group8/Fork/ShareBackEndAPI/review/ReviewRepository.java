package com.Group8.Fork.ShareBackEndAPI.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
}
