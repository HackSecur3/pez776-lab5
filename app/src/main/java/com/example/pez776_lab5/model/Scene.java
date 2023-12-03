package com.example.pez776_lab5.model;

import java.util.ArrayList;

public class Scene {

    private int id;

    private String title;

    private ArrayList<Role> ScRoles;

    public Scene(int id, String title,ArrayList<Role> ScRoles){
        this.id = id;
        this.title = title;
        this.ScRoles = ScRoles;
    }

    public void getId(int id){
        this.id =id;
    }

    public int getId(){
        return this.id;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setRoles(ArrayList<Role> Roles){
        this.ScRoles = Roles;
    }

    public ArrayList<Role>ScRoles(ArrayList<Role> ScRoles){
        return this.ScRoles;
    }
    public void addRole(Role role){
        ScRoles.add(role);
    }
}
