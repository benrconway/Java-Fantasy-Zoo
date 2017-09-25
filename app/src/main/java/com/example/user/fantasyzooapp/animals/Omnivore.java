package com.example.user.fantasyzooapp.animals;

import com.example.user.fantasyzooapp.food.Edible;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Omnivore extends Animal {
    private ArrayList<Edible> belly;

    public Omnivore(String name, Enum<Size> size, int value){
        super(name, size, value);
        this.belly = new ArrayList<>();
    }

    public ArrayList<Edible> getBelly() {
        return belly;
    }

    public void eat(Edible food){
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
