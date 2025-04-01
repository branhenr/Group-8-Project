package com.Group8.Fork.ShareBackEndAPI.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "SELECT * FROM users c WHERE c.username LIKE %?1%", nativeQuery = true)

    List<User> getUserByUsername(String username);
}
