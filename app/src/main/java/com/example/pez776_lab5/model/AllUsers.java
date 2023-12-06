package com.example.pez776_lab5.model;

import java.util.ArrayList;

public class AllUsers {

    private ArrayList<User> Users;


    public AllUsers(){
        this.Users = new ArrayList<>();
    }

    public void AddUser(User user){
        Users.add(user);
    }

}
