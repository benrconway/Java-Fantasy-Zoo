package com.example.user.fantasyzooapp.animals;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Animal {

    private String name;
    private Enum<Size> size;
    private int value;


    public Animal(String name, Enum<Size> size, int value){
        this.name = name;
        this.size = size;
        this.value = value;
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

    abstract void sleep();

    abstract boolean isHungry();

}
