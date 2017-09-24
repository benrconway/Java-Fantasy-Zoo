package com.example.user.fantasyzooapp.facilities;

import com.example.user.fantasyzooapp.animals.Animal;
import com.example.user.fantasyzooapp.animals.Carnivore;
import com.example.user.fantasyzooapp.animals.Herbivore;
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
        ArrayList<Animal> animalsToCompare = collectAnimalsForComparison(animal);

       if((areAnimalsCompatibile(animalsToCompare))  &&
               (isEnvironmentCorrectSize(animal.getSize()))) {
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

    public ArrayList<Animal> collectAnimalsForComparison(Animal animal){
        ArrayList<Animal> animalsForComparison = new ArrayList<>();
        for(Animal animalPresent: animals){
            animalsForComparison.add(animalPresent);
        }
        animalsForComparison.add(animal);
        return animalsForComparison;
    }

    public boolean areAnimalsCompatibile(ArrayList<Animal> animalsToBeChecked){
        boolean areCompatible = false;
        ArrayList<Animal> herbivores = new ArrayList<>();
        ArrayList<Animal> carnivores = new ArrayList<>();
        for (Animal animal: animalsToBeChecked){
            if (animal instanceof Carnivore){
                carnivores.add(animal);
            }else{ herbivores.add(animal);}
        }
        if((herbivores.size() == 0) || (carnivores.size() == 0)){
            areCompatible = true;
        }
        return areCompatible;
    }


}
