package com.Group8.Fork.ShareBackEndAPI.chef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


//@RestController
@Controller
@RequestMapping("/chefs")
public class ChefController {

    @Autowired
    private ChefService service;

    //return all chefs
    @GetMapping("/all")
    public Object getAllChefs(Model model) {
        //return new ResponseEntity<>(service.getAllChefs(), HttpStatus.OK);
        model.addAttribute("chefList", service.getAllChefs());
        model.addAttribute("title", "All Chefs");
        return "chef-list";
    }

    //return a chef by Id
    @GetMapping("/{chefId}")
    public Object getOneChef(@PathVariable int chefId, Model model){
        //return new ResponseEntity<>(service.getChefById(chefId), HttpStatus.OK);
        model.addAttribute("chef", service.getChefById(chefId));
        model.addAttribute("title", "Chef #: " + chefId);
        return "chef-details";
    }

    //return chef by name
    @GetMapping("/name")
    public Object getChefsByName(@RequestParam(name = "search", defaultValue = "") String search){
        return new ResponseEntity<>(service.getChefsByName(search), HttpStatus.OK);
    }

    //show form to create a profile for chef
    @GetMapping("/createForm")
    public String showCreateForm(Model model){
        Chef chef = new Chef();

    }


    //creating a new chef
    @PostMapping("/new")
    public Object addNewChef(@RequestBody Chef chef) {
        service.addNewChef(chef);
        return new ResponseEntity<>(service.getAllChefs(), HttpStatus.CREATED);
    }

    //updating an existing chef
    @PutMapping("/update/{chefId}")
    public Object updateChef(@PathVariable int chefId, @RequestBody Chef chef){
        service.updateChef(chefId, chef);
        return new ResponseEntity<>(service.getChefById(chefId), HttpStatus.CREATED);
    }

    //delete a chef
    @DeleteMapping("/delete/{chefId}")
    public Object deleteChefById(@PathVariable int chefId){
        service.deleteChefById(chefId);
        return new ResponseEntity<>(service.getAllChefs(), HttpStatus.OK);
    }

}
