package com.example.budget20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Calendar;
import java.util.HashMap;
import java.io.Serializable;

public class addExpense extends AppCompatActivity implements Serializable {
    public HashMap<Date, Purchase> map;
    public Date currentDate;
    public Purchase purchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        Intent intent = getIntent();
        map = (HashMap<Date, Purchase>)intent.getSerializableExtra("map");

        setTitle("Add Charges");

        Button calendarFromAdd = findViewById(R.id.addFromCost);
        calendarFromAdd.setOnClickListener(unused-> toCalendar());

        Button costFromAdd = findViewById(R.id.calendarFromCost);
        costFromAdd.setOnClickListener(unused-> toCost());

        if (map == null) {
            map = new HashMap<Date, Purchase>();
        }
        DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                currentDate = new Date(year, month + 1, dayOfMonth);
                //map.put(currentDate, purchase);
//                map.put(currentDate, purchase);
//                System.out.println(map.get(currentDate).toString());
            }
        });

        Button addAllItems = findViewById(R.id.additemstocal);
        addAllItems.setOnClickListener(v -> {
            EditText thing = findViewById(R.id.thing);
            EditText cost = findViewById(R.id.cost);
            String thingString = thing.getText().toString();
            Double costDouble = Double.parseDouble(cost.getText().toString());

            purchase = new Purchase(thingString, costDouble);
            //System.out.println("add expense: " + currentDate.toString());
            map.put(currentDate, purchase);
        });

    }
    public void toCalendar() {
        Intent toCalendar = new Intent(this, calendar.class);
        toCalendar.putExtra("map", map);
        startActivity(toCalendar);
        overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
        finish();
    }
    public void toCost() {
        Intent toCost = new Intent(this, cost.class);
        toCost.putExtra("map", map);
        startActivity(toCost);
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
        finish();
    }

}

