package com.example.pez776_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pez776_lab5.model.Act;
import com.example.pez776_lab5.model.Scene;

import java.util.ArrayList;


public class ActActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);

        DisplayAct();
    }

    public void DisplayAct(){
        int num=0;
        Intent intent = getIntent();
        intent.getIntExtra("actnum",num);
        if(num==1){
            TextView actView = findViewById(R.id.act);
            actView.setText("Act 1");
        }
        else if (num==2){
            TextView actView = findViewById(R.id.act);
            actView.setText("Act 2");
        }
            Act act1 = new Act(num);
            act1.loadAct(this, num);
            TextView sceneView = findViewById(R.id.scenes);
            sceneView.setText(act1.toString());
    }
}