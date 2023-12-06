package com.example.pez776_lab5.model;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.pez776_lab5.MainActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class User{


    private String username;
    private String password;
    private String realname;

    private ArrayList<Role> Roles;

    private ArrayList<User> Users = new ArrayList<User>();

    public User(String username, String password, String realname) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.Roles = new ArrayList<>();
    }

    public User() {

    }





    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setRoles(ArrayList<Role> Roles) {
        this.Roles = Roles;
    }

    public ArrayList<Role> getRoles() {
        return this.Roles;
    }

    public Role getRole(String realName){
        for(Role role: Roles){
            if(role.getName().equals(realName)){
                return role;
            }
        }
        return null;
    }

    public void loadUser(Activity activity) {
        AssetManager manager = activity.getAssets();
        try {
            InputStream stream = manager.open("users.csv");
            Scanner scanner = new Scanner(stream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.trim().split(",");
                String username = lineSplit[0].trim().toLowerCase();
                String password = lineSplit[1].trim().toLowerCase();
                String realname = lineSplit[2].trim();
                User newUser = new User(username, password, realname);

                for (int i = 3; i < lineSplit.length; ++i) {
                    String roleName = lineSplit[i].trim();
                    Role newRole = new Role(roleName);
                    newUser.getRoles().add(newRole);
                }

                Users.add(newUser);

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            Log.d("File Exception", "File not Found");
        } catch (IOException e) {
            Log.d("File Exception", "IO Exception");
        }
    }

    public User getUser(String userName){
        for (User user : Users) {
            if (user.getUsername().equalsIgnoreCase(userName)) {
                    return user;
            }
        }
        return null;
    }

    public boolean validate(String userName, String password) {
        for (User user : Users) {
            if (user.getUsername().equalsIgnoreCase(userName)) {
                if (user.getPassword().equalsIgnoreCase(password)) {
                    return true;
                }
            }
        }
        return false;
    }


}
