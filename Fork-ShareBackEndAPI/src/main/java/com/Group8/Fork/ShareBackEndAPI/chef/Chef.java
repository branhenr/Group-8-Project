package com.Group8.Fork.ShareBackEndAPI.chef;

import com.Group8.Fork.ShareBackEndAPI.recipe.Recipe;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chefs")
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chefId;

    private String username;

    private String email;

    private String password;

    public Chef(int chefId, String username, String email, String password){
        this.chefId = chefId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Chef(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Chef(){

    }

    public Chef(int chefId) {this.chefId = chefId; }

    //getter methods
    public int getChefId(){
        return chefId;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    //setter methods
    public void setChefId(int chefId){
        this.chefId = chefId;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
