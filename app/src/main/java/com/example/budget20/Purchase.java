package com.example.budget20;

import java.io.Serializable;

public class Purchase implements Serializable {
    private String thing;
    private double cost;
    public Purchase(String setThing, double setCost) {
        thing = setThing;
        cost = setCost;
    }
    public void setPurchase(String setThing, double setCost) {
        thing = setThing;
        cost = setCost;
    }
    public double getCost() {
        return cost;
    }
    public String toString() {
        return thing + ": " + cost;
    }
}
