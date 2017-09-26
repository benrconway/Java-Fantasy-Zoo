package com.example.user.fantasyzooapp.animals;

import com.example.user.fantasyzooapp.food.Vegetation;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Herbivore extends Animal {
    private ArrayList<Vegetation> belly;

    public Herbivore(String name, Enum<Size> size, int value){
        super(name, size, value);
        this.belly = new ArrayList<>();
    }

    public ArrayList<Vegetation> getBelly() {
        return belly;
    }

    public void eat(Vegetation food){
        belly.add(food);
    }

    public void sleep() {
        belly.clear();
    }

    public boolean isHungry() {
        boolean hungry = false;
        if (belly.size() <= 1) {
            hungry = true;
        }
        return hungry;
    }

}
