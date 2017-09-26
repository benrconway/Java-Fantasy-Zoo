package com.example.user.fantasyzooapp.animals;

import com.example.user.fantasyzooapp.food.Flesh;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Carnivore extends Animal {
    private ArrayList<Flesh> belly;

    public Carnivore(String name, Enum<Size> size, int value){
        super(name, size, value);
        belly = new ArrayList<>();
    }

    public ArrayList<Flesh> getBelly() {
        return belly;
    }

    public void eat(Flesh food){
        belly.add(food);
    }

    public void sleep(){
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
