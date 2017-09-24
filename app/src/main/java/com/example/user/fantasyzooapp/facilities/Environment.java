package com.example.user.fantasyzooapp.facilities;

import com.example.user.fantasyzooapp.animals.Animal;
import com.example.user.fantasyzooapp.animals.Size;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class Environment extends Building {
    private ArrayList<Animal> animals;
    private Enum<Size> size;

    public Environment(int value, int viewingCapacity, int staffCapactity, Enum<Size> size){
        super(value, viewingCapacity, staffCapactity);
        this.size = size;
        this.animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public Enum<Size> getSize() {
        return size;
    }

    public void takeIn(Animal animal){
       if(isEnvironmentCorrectSize(animal.getSize())) {
            animals.add(animal);
        }
    }

    public void remove(Animal animal) {
        animals.remove(animal);
    }

    public boolean isEnvironmentCorrectSize(Enum<Size> animalSize){
        boolean isBigEnough = false;
            if(animalSize.ordinal() <= size.ordinal()){
                isBigEnough = true;
            }
        return isBigEnough;
    }


}
