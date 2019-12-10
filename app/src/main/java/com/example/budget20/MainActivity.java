package com.example.budget20;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startGame = findViewById(R.id.startGame);
        startGame.setOnClickListener(unused-> startScreen());
        TextView startTest = findViewById(R.id.startTest);
        startTest.setVisibility(View.VISIBLE);
        startTest.setTextColor(Color.BLACK);

    }
    public void startScreen() {
        Button startGame = findViewById(R.id.startGame);
        startGame.setVisibility(View.GONE);
        ImageView logo = findViewById(R.id.logo);
        logo.setVisibility(View.GONE);
        TextView startTest = findViewById(R.id.startTest);
        startTest.setVisibility(View.GONE);
        Intent calendar = new Intent(this, com.example.budget20.calendar.class);
        startActivity(calendar);
        finish();
    }
}
