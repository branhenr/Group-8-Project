package com.Group8.Fork.ShareBackEndAPI.chef;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Integer>{

    @Query(value = "select * from chefs c where c.name like %?1% ", nativeQuery = true)
    List<Chef> getChefsByName(String name);


}
