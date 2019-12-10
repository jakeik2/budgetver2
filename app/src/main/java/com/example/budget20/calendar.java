package com.example.budget20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.io.Serializable;

public class calendar extends AppCompatActivity implements Serializable {
    public HashMap<Date, Purchase> map;
    public Date selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Calendar");

        Intent intent = getIntent();
        map = (HashMap<Date, Purchase>)intent.getSerializableExtra("map");

        setContentView(R.layout.activity_calendar);
        CalendarView calendarView = findViewById(R.id.CalendarView);
        TextView purchases = findViewById(R.id.Purchases);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                selected = new Date(year, month + 1, dayOfMonth);
                //System.out.println("calendar: " + map.get(selected).toString());
                for (HashMap.Entry<Date, Purchase> entry : map.entrySet()) {
                    if (entry.getKey().equals(selected)) {
                        purchases.setText(entry.getValue().toString());
                    }
                }

            }
        });
        Button toAddFromCalendar = findViewById(R.id.addFromCost);
        toAddFromCalendar.setOnClickListener(unused-> toAddExpense());

        Button costFromCalendar = findViewById(R.id.calendarFromCost);
        costFromCalendar.setOnClickListener(unused-> toCost());
    }
    public void toAddExpense() {
        Intent addE = new Intent(this, addExpense.class);
        addE.putExtra("map", map);
        startActivity(addE);
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
        finish();
    }
    public void toCost() {
        Intent toCost = new Intent(this, cost.class);
        toCost.putExtra("map", map);
        startActivity(toCost);
        overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
        finish();
    }

}
