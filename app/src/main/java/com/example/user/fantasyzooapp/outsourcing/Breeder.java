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
    private Dragon hugeDragon;
    private Dragon largeDragon;
    private Dragon mediumDragon;
    private Dragon smallDragon;
    private Unicorn hugeUnicorn;
    private Unicorn largeUnicorn;
    private Unicorn mediumUnicorn;
    private Unicorn smallUnicorn;
    private Bunyip hugeBunyip;
    private Bunyip largeBunyip;
    private Bunyip mediumBunyip;
    private Bunyip smallBunyip;

    private ArrayList<Animal> collection;
    private int savings;

    public Breeder(){
        this.savings = 10_000;
        this.collection = new ArrayList<>();
        setUpCollection();
    }

    public void setUpCollection() {
        hugeDragon = new Dragon("Caul", Size.HUGE, 30_000);
        largeDragon = new Dragon("Tom", Size.LARGE, 3_000);
        mediumDragon = new Dragon("Talitha", Size.MEDIUM, 900);
        smallDragon = new Dragon("Korinth", Size.SMALL, 500);
        collection.add(hugeDragon);
        collection.add(largeDragon);
        collection.add(mediumDragon);
        collection.add(smallDragon);

        hugeUnicorn = new Unicorn("Swift", Size.HUGE, 40_000);
        largeUnicorn = new Unicorn("Alessandra", Size.LARGE, 4000);
        mediumUnicorn = new Unicorn("Debby", Size.MEDIUM, 2000);
        smallUnicorn = new Unicorn("River", Size.SMALL, 1000);
        collection.add(hugeUnicorn);
        collection.add(largeUnicorn);
        collection.add(mediumUnicorn);
        collection.add(smallUnicorn);

        hugeBunyip = new Bunyip("Kookoo", Size.HUGE, 15_000);
        largeBunyip = new Bunyip("Tlacktock", Size.LARGE, 1500);
        mediumBunyip = new Bunyip("Jimmy", Size.MEDIUM, 650);
        smallBunyip = new Bunyip("Big Greg", Size.SMALL, 300);
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

//    public void sell(Animal animal, Zoo zoo){
//        Animal animalSold = retrieveAnimal(animal);
//        zoo.buy(animalSold);
//        savings += animalSold.getValue();
//    }

//    private Animal retrieveAnimal(Animal animal) {
//        Animal animalToFind = null;
//        for (Animal animalInCollection: collection) {
//            if (animal == animalInCollection){
//                animalToFind = animalInCollection;
//            }
//        }
//        return animalToFind;
//    }

    public Animal getFromCollection(int indexOfAnimal) {
        return collection.get(indexOfAnimal);
    }

    public void getPaid(int value) {
        savings += value;
    }
}
