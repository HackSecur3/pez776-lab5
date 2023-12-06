package com.example.pez776_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pez776_lab5.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText userName;

    private EditText password;

    private Button loginButton;

    private ArrayList<User> Users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupEditText();
        setUpButton();
    }



    private void setupEditText() {
        this.userName = findViewById(R.id.userName);
        this.password = findViewById(R.id.password);

        this.userName.getText().clear();
        this.password.getText().clear();
    }

    private void setUpButton() {
        this.loginButton = findViewById(R.id.loginbutton);
        this.loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        User newUser = new User();
        newUser.loadUser(this);
        boolean valid = newUser.validate(this.userName.getText().toString().toLowerCase(),this.password.getText().toString().toLowerCase());
        if(!valid){
            Toast.makeText(this,"Incorrect username or password",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent roleActivtyIntent = new Intent(MainActivity.this,RoleActivity.class);
            roleActivtyIntent.putExtra("name",newUser.getUser(this.userName.getText().toString().toLowerCase()).getRealname());
            startActivity(roleActivtyIntent);
        }
    }
}