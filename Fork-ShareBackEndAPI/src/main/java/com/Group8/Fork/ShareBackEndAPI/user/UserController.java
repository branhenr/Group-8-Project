package com.Group8.Fork.ShareBackEndAPI.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    //show all users
    @GetMapping("/all")
    public Object getAllUsers(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    // show by userID
    @GetMapping("/{userID}")
    public Object getOneUser(@PathVariable int userID) {
        return new ResponseEntity<>(service.getUserByID(userID), HttpStatus.OK);
    }

    //show by username
    @GetMapping("/username")
    public Object getUserByUsername(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getUsersByUsername(search), HttpStatus.OK);
    }

    //create new user
    @PostMapping("/new")
    public Object addNewUser(@RequestBody User user){
    service.addNewUser(user);
    return new ResponseEntity<>(service.getAllUsers(), HttpStatus.CREATED);
    }

    //edit acc
    @PutMapping("/update/{userID}")
    public Object updateUser(@PathVariable int userID, @RequestBody User user) {
    service.updateUser(userID, user);
    return new ResponseEntity<>(service.getUserByID(userID), HttpStatus.CREATED);
    }

    //DELETE acc
    @DeleteMapping("/delete/{userID}")
    public Object deleteUserByID(@PathVariable int userID) {
    service.deleteUserById(userID);
    return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
 }
}