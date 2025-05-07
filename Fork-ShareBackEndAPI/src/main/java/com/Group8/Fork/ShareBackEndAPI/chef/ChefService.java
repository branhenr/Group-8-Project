package com.Group8.Fork.ShareBackEndAPI.chef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefService {

    @Autowired
    private ChefRepository chefRepository;

    public List <Chef> getAllChefs(){
        return chefRepository.findAll();
    }

    public Chef getChefById(int chefId) {
        return chefRepository.findById(chefId).orElse(null);
    }

    public List<Chef> getChefsByName(String name){
        return chefRepository.getChefsByName(name);
    }


    //adding a new chef to database
    public void addNewChef(Chef chef){
        chefRepository.save(chef);
    }

    //updating a chef
    public void updateChef(int chefId, Chef chef){
        chefRepository.save(chef);
    }

    public void updateChef(Chef chef){
        chefRepository.save(chef);
    }

    //deleting a chef
    public void deleteChefById(int chefId){
        chefRepository.deleteById(chefId);
    }
}
