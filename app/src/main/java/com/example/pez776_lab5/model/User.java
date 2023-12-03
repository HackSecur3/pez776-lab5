package com.example.pez776_lab5.model;

import android.content.res.AssetManager;
import android.util.Log;

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

public class User {

    private String username;

    private String password;

    private String realname;

    private ArrayList<Role> Roles;

    private ArrayList<User> Users = new ArrayList<User>();

    public User(String username,String password,String realname,ArrayList<Role> Roles){
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.Roles = Roles;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setRealname(String realname){
        this.realname = realname;
    }

    public String getRealname(){
        return this.realname;
    }
    public void setRoles(ArrayList<Role> Roles){
        this.Roles = Roles;
    }
    public ArrayList<Role> getRoles(){
        return this.Roles;
    }


    public static int[] countFieldsPerLine(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            // Create an array to store the field counts for each line
            int[] fieldCounts = new int[getLineCount(filePath)];

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(","); // Change the delimiter if necessary

                int fieldCount = fields.length;
                fieldCounts[lineNumber++] = fieldCount;
            }

            return fieldCounts;
        }
    }

    public static int getLineCount(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }

    public void loadUser(MainActivity activity) {
        AssetManager manager = activity.getAssets();
        int count =0;
        try {
            InputStream stream = manager.open("users.csv");
            Scanner scanner = new Scanner(stream);
            int[] fieldCounts = countFieldsPerLine("user.csv");
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.trim().split(",");
                String username = lineSplit[0].trim();
                String password = lineSplit[1].trim();
                String realname = lineSplit[2].trim();
                if(fieldCounts[count] == 4){
                    Role newcharacter1 = new Role(lineSplit[3].trim());
                    Roles.add(newcharacter1);
                    Role newcharacter2 = new Role(lineSplit[4].trim());
                    Roles.add(newcharacter2);
                } else {
                    Role newcharacter = new Role(lineSplit[3].trim());
                    Roles.add(newcharacter);
                }
                User newuser = new User(username,password,realname,Roles);
                Users.add(newuser);
                count++;
            }
        } catch (FileNotFoundException e) {
            Log.d("File Exception", "File not Found");
        } catch (IOException e) {
            Log.d("File Exception", "IO Exception");
        }
    }


    public boolean ValidateUser(String username,String password) {
        for (User User : Users) {
            if(User.getUsername()==username){
                if(User.getPassword()==password){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return false;
    }
}
