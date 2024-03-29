package com.example.budget20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class calendar extends AppCompatActivity implements Serializable {
    public HashMap<Date, ArrayList<Purchase>> map;
    public Date selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Calendar");

        Intent intent = getIntent();
        map = (HashMap<Date, ArrayList<Purchase>>)intent.getSerializableExtra("map");

        if (map == null) {
            map = new HashMap<Date, ArrayList<Purchase>>();
        }

        setContentView(R.layout.activity_calendar);
        CalendarView calendarView = findViewById(R.id.CalendarView);
        TextView purchases1 = findViewById(R.id.Purchases1);
        TextView purchases2 = findViewById(R.id.Purchases2);
        TextView purchases3 = findViewById(R.id.Purchases3);
        TextView purchases4 = findViewById(R.id.Purchases4);
        TextView purchases5 = findViewById(R.id.Purchases5);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Log.d("as", "dateChanged");
                selected = new Date(year, month + 1, dayOfMonth);
                //System.out.println("calendar: " + map.get(selected).toString());
                for (HashMap.Entry<Date, ArrayList<Purchase>> entry : map.entrySet()) {
                    Log.d("as1", "looping through map");

                    for (int i = 0; i < entry.getValue().size(); i++) {
                        Log.d("as2", "looping through arrayList");

                        if (entry.getKey().equals(selected)) {
                            if (entry.getValue().size() < 1) {
                                purchases1.setText("");
                            } else {
                                purchases1.setText(entry.getValue().get(0).toString());
                            }
                            if (entry.getValue().size() < 2) {
                                purchases2.setText("");
                            } else {
                                purchases2.setText(entry.getValue().get(1).toString());
                            }
                            if (entry.getValue().size() < 3) {
                                purchases3.setText("");
                            } else {
                                purchases3.setText(entry.getValue().get(2).toString());
                            }
                            if (entry.getValue().size() < 4) {
                                purchases4.setText("");
                            } else {
                                purchases4.setText(entry.getValue().get(3).toString());
                            }
                            if (entry.getValue().size() < 5) {
                                purchases5.setText("");
                            } else {
                                purchases5.setText(entry.getValue().get(4).toString());
                            }
                        }
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
