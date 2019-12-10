package com.example.budget20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class cost extends AppCompatActivity implements Serializable{
    public HashMap<Date, Purchase> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        setTitle("Expenses");

        Intent intent = getIntent();
        map = (HashMap<Date, Purchase>)intent.getSerializableExtra("map");

        Button calendarFromCost = findViewById(R.id.calendarFromCost);
        calendarFromCost.setOnClickListener(unused-> toCalendar());

        Button addFromCost = findViewById(R.id.addFromCost);
        addFromCost.setOnClickListener(unused-> toadd());
    }

    public void toCalendar() {
        Intent toCalendar = new Intent(this, calendar.class);
        toCalendar.putExtra("map", map);
        startActivity(toCalendar);
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
        finish();
    }
    public void toadd() {
        Intent toadd = new Intent(this, addExpense.class);
        toadd.putExtra("map", map);
        startActivity(toadd);
        overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
        finish();
    }


}
