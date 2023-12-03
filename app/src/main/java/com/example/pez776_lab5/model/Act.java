package com.example.pez776_lab5.model;

import android.content.res.AssetManager;
import android.renderscript.ScriptGroup;
import android.util.Log;

import com.example.pez776_lab5.ActActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Act {

    private int num;

    private ArrayList<Scene> Scenes;

    public Act(int num, ArrayList<Scene> Scenes){
        this.num = num;
        this.Scenes = Scenes;
    }

    public void setNum(int num){
        this.num = num;
    }

    public int getNum(){
        return this.num;
    }

    public void setScenes(ArrayList<Scene> Scenes){
        this.Scenes = Scenes;
    }

    public ArrayList<Scene> getScenes(){
        return this.Scenes;
    }

    public void loadAct(ActActivity activity,int num){
        AssetManager manager = activity.getAssets();;
        InputStream stream;
        int counter = 1;
        try {
            if (num == 1) {
                stream = manager.open("act1.txt");
            } else {
                stream = manager.open("act2.txt");
            }
            Scanner scan = new Scanner(stream);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.trim().split(":");
                String title =parts[0].trim();
                String[] characters = parts[1].trim().split(",");
                ArrayList<Role>characterlist = new ArrayList<>();
                for(String character:characters){
                    Role newRole = new Role(character);
                    characterlist.add(newRole);
                }
                Scene newScene = new Scene(counter++,title,characterlist);
                Scenes.add(newScene);
            }
            Act newAct = new Act(num,Scenes);
        }catch(FileNotFoundException e){
            Log.d("File Exception", "File not Found");

        } catch (IOException e) {
            Log.d("File Exception", "IO Exception");
            throw new RuntimeException(e);
        }
    }

}
