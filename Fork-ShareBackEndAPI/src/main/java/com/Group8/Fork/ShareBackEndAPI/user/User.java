package com.Group8.Fork.ShareBackEndAPI.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

     private int userID;

     private String username;
     private String email;
     private String password;

     public  User(int userID, String username, String email, String password) {
         this.userID = userID;
         this.username = username;
         this.email = email;
         this.password = password;
     }

     public User (String username, String email, String password) {
         this.username = username;
         this.email = email;
         this.password = password;
     }

     public User() { }

    // Getters

    public int getUserID() {
         return userID;
     }
     public String getUsername() {
         return username;
     }
     public String getEmail() {
         return email;
     }

     public String getPassword() {
         return password;
     }

     // Setters

    public void setUserID( int userID)  {
         this.userID = userID;
    }

    public void setUsername (String username) {
         this.username = username;
    }

    public void setEmail (String email) {
         this.email = email;

    }

    public void setPassword (String password) {
         this.password = password;
    }

}
