package com.example.user.fantasyzooapp.animals;

import java.util.Random;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Animal {

    private String name;
    private Enum<Size> size;
    private int value;
    private int happiness;


    public Animal(String name, Enum<Size> size, int value){
        this.name = name;
        this.size = size;
        this.value = value;
        this.happiness = 100;
    }

    public String getName() {
        return name;
    }

    public Enum<Size> getSize() {
        return size;
    }

    public int getValue() {
        return value;
    }

    public int getHappiness() {
        return happiness;
    }

    public abstract void sleep();

    public abstract boolean isHungry();


    public void adjustHappiness(int value) {
        happiness += value;
    }
}
