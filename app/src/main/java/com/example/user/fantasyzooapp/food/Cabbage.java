package com.example.user.fantasyzooapp.food;

/**
 * Created by user on 22/09/2017.
 */

public class Cabbage implements Edible, Vegetation {
    private int value;

    public Cabbage(){
        this.value = 5;
    }

    @Override
    public int getValue() {
        return value;
    }
}
