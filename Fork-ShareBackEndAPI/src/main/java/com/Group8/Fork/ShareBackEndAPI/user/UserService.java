package com.Group8.Fork.ShareBackEndAPI.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserbyID (int userID) {
        return userRepository.findByID(userID).orElse(null);
    }

    public List<User> getUsersByUsername(String username) {
        return userRepository.getUsersByUsername(username);
    }

    // add new user
    public void addNewUser(User user) {
        userRepository.save(user);
    }

//update user acc
    public void updateUser(int userID, User user) {
        User existing = getUserByID(userID);
        existing.setUserId(user.getUserID());
        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());

        }

        // delete acc

    public void deleteUserById(int userID) {

    }
}


}
