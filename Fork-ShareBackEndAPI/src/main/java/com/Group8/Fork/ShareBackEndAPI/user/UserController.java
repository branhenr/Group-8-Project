package com.Group8.Fork.ShareBackEndAPI.user;


import com.Group8.Fork.ShareBackEndAPI.chef.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService service;

    //show all users
    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getAllUsers());
        model.addAttribute("title", "All Users");
        return "user-list";
    }


    // show by userID
    @GetMapping("/{userID}")
    public String getOneUser(@PathVariable int userID, Model model) {
        model.addAttribute("user", service.getUserByID(userID));
        model.addAttribute("title", "User Profile #" + userID);
        return "user-details";
    }


    //show by username
    @GetMapping("/username")
    public Object getUserByUsername(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getUsersByUsername(search), HttpStatus.OK);
    }


    // Show form to create a new user
    @GetMapping("/createForm")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Create New User");
        return "user-create";
    }

    // create new user
    @PostMapping("/new")
    public Object addNewUser(User user, Model model) {
        service.addNewUser(user);
        return "redirect:/users/all"; // redirects to user-list.ftlh

    }


    //edit acc
        @GetMapping("/update/{userID}")
        public String showUpdateForm ( @PathVariable int userID, Model model){
            model.addAttribute("user", service.getUserByID(userID));
            model.addAttribute("title", "Update User #" + userID);
            return "user-update";
        }

    //updating an existing user
    @PostMapping("/update/{userID}")
    public Object updateUser(@PathVariable int userID, User user ){
        service.updateUser(userID, user);
        return "redirect:/users/" + userID;
    }

        //DELETE acc
        @GetMapping("/delete/{userID}")
        public String deleteUser ( @PathVariable int userID){
            service.deleteUserById(userID);
            return "redirect:/users/all";
        }


        //save recipe
        @PostMapping("/{userID}/save-recipe/{recipeId}")
        public String saveRecipe ( @PathVariable int userID, @PathVariable int recipeId){
            service.saveRecipeForUser(userID, recipeId);
            return "redirect:/users/saved?userID=" + userID;
        }

        //unsave recipe // get matches html limits
        @GetMapping("/{userID}/unsave-recipe/{recipeId}")
        public String unsaveRecipe ( @PathVariable int userID, @PathVariable int recipeId){
            service.unsaveRecipeForUser(userID, recipeId);
            return "redirect:/users/saved?userID=" + userID;
        }



    }
