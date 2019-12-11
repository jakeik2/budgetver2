package com.example.budget20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class cost extends AppCompatActivity implements Serializable{
    public HashMap<Date, ArrayList<Purchase>> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        setTitle("Expenses");

        Intent intent = getIntent();
        map = (HashMap<Date, ArrayList<Purchase>>)intent.getSerializableExtra("map");

        if (map == null) {
            map = new HashMap<Date, ArrayList<Purchase>>();
        }

        TextView daily = findViewById(R.id.dCost);
        TextView weekly = findViewById(R.id.mCost);
        TextView monthly = findViewById(R.id.yCost);

        double allvalues = 0.0;
        for (HashMap.Entry<Date, ArrayList<Purchase>> entry : map.entrySet()) {
            allvalues += entry.getValue().get(0).getCost();
        }
        daily.setText(Double.toString((allvalues/map.size()) ));
        weekly.setText(Double.toString((allvalues/map.size()) * 7));
        monthly.setText(Double.toString((allvalues/map.size()) * 30));

        Button calendarFromCost = findViewById(R.id.calendarFromCost);
        calendarFromCost.setOnClickListener(unused-> toCalendar());

        Button addFromCost = findViewById(R.id.addFromCost);
        addFromCost.setOnClickListener(unused-> toadd());

        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(unused-> crash());
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
    public void crash() {
        finish();
    }
}
