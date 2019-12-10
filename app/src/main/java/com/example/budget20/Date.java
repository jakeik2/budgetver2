package com.example.budget20;

import java.io.Serializable;

public class Date implements Serializable {
    private int year;
    private int month;
    private int dayOfMonth;
    public Date(int setYear, int setMonth, int setDayOfMonth) {
        year = setYear;
        month = setMonth;
        dayOfMonth = setDayOfMonth;
    }
    public void setDate(int setYear, int setMonth, int setDayOfMonth) {
        year = setYear;
        month = setMonth;
        dayOfMonth = setDayOfMonth;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDayOfMonth() {
        return dayOfMonth;
    }
    public boolean equals(Date newDate) {
        if (newDate.getYear() == year && newDate.getMonth() == month && newDate.getDayOfMonth() == dayOfMonth) {
            return true;
        }
        return false;
    }
    public String toString() {
        return year + ", " + month + ", " + dayOfMonth;
    }
    public int hashCode() {
        return year + month + dayOfMonth;
    }
}
