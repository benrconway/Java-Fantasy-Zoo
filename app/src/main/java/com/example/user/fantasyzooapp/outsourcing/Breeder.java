package com.example.user.fantasyzooapp.outsourcing;

import com.example.user.fantasyzooapp.animals.Animal;
import com.example.user.fantasyzooapp.animals.Bunyip;
import com.example.user.fantasyzooapp.animals.Dragon;
import com.example.user.fantasyzooapp.animals.Size;
import com.example.user.fantasyzooapp.animals.Unicorn;
import com.example.user.fantasyzooapp.facilities.Zoo;

import java.util.ArrayList;

/**
 * Created by user on 25/09/2017.
 */

public class Breeder {

    private ArrayList<Animal> collection;
    private int savings;

    public Breeder(){
        this.savings = 10_000;
        this.collection = new ArrayList<>();
        setUpCollection();
    }

    public void setUpCollection() {
        Dragon hugeDragon = new Dragon("Caul", Size.HUGE, 30_000);
        Dragon largeDragon = new Dragon("Tom", Size.LARGE, 3_000);
        Dragon mediumDragon = new Dragon("Talitha", Size.MEDIUM, 900);
        Dragon smallDragon = new Dragon("Korinth", Size.SMALL, 500);
        collection.add(hugeDragon);
        collection.add(largeDragon);
        collection.add(mediumDragon);
        collection.add(smallDragon);

        Unicorn hugeUnicorn = new Unicorn("Swift", Size.HUGE, 40_000);
        Unicorn largeUnicorn = new Unicorn("Alessandra", Size.LARGE, 4000);
        Unicorn mediumUnicorn = new Unicorn("Debby", Size.MEDIUM, 2000);
        Unicorn smallUnicorn = new Unicorn("River", Size.SMALL, 1000);
        collection.add(hugeUnicorn);
        collection.add(largeUnicorn);
        collection.add(mediumUnicorn);
        collection.add(smallUnicorn);

        Bunyip hugeBunyip = new Bunyip("Kookoo", Size.HUGE, 15_000);
        Bunyip largeBunyip = new Bunyip("Tlacktock", Size.LARGE, 1500);
        Bunyip mediumBunyip = new Bunyip("Jimmy", Size.MEDIUM, 650);
        Bunyip smallBunyip = new Bunyip("Big Greg", Size.SMALL, 300);
        collection.add(hugeBunyip);
        collection.add(largeBunyip);
        collection.add(mediumBunyip);
        collection.add(smallBunyip);
    }

    public int getSavings() {
        return savings;
    }

    public ArrayList<Animal> getCollection() {
        return collection;
    }

    public void sell(Animal animal, Zoo zoo){
        Animal animalSold = retrieveAnimal(animal);
        zoo.buy(animalSold);
        savings += animalSold.getValue();
    }

    private Animal retrieveAnimal(Animal animal) {
        Animal animalToFind = null;
        for (Animal animalInCollection: collection) {
            if (animal == animalInCollection){
                animalToFind = animalInCollection;
            }
        }
        return animalToFind;
    }
}
