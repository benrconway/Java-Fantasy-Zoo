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
}
