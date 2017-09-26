package com.example.user.fantasyzooapp.food;

/**
 * Created by user on 22/09/2017.
 */

public class Meat implements Edible, Flesh {

    private int value;

    public Meat(){
        this.value = 5;
    }

    @Override
    public int getValue() {
        return value;
    }
}

