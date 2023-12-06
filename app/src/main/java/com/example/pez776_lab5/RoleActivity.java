package com.example.pez776_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pez776_lab5.model.User;


public class RoleActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
        setUpButton();
        Display();

    }

    private void Display(){
        Intent intent = getIntent();
        TextView nameView = findViewById(R.id.realname);
        User newUser = null;
        //User newUser = intent.getParcelableExtra("user"); // Assuming you passed the User object with "userKey"

        nameView.setText(name);

        TextView rolesView = findViewById(R.id.roles);

    }
    private void setUpButton() {

        Button act1 = findViewById(R.id.act1);
        act1.setOnClickListener(this);

        Button act2 = findViewById(R.id.act2);
        act2.setOnClickListener(this);

        Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v.getId()==R.id.act1){
            intent = new Intent(this,ActActivity.class);
            intent.putExtra("actnum",1);
            startActivity(intent);
        }
        else if(v.getId()==R.id.act2){
            intent = new Intent(this,ActActivity.class);
            intent.putExtra("actnum",2);
            startActivity(intent);
        }
        else if(v.getId()==R.id.logout){
           intent = new Intent(this,MainActivity.class);
           startActivity(intent);
        }

    }
}