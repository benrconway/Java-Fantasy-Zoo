package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.animals.Animal;
import com.example.user.fantasyzooapp.facilities.Zoo;
import com.example.user.fantasyzooapp.outsourcing.Breeder;
import com.example.user.fantasyzooapp.animals.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 25/09/2017.
 */

public class BreederTest {
    Breeder breeder;
    Zoo zoo;

    @Before
    public void before(){
        breeder = new Breeder();
    }

    @Test
    public void hasSavings() {
        assertEquals(10_000, breeder.getSavings());
    }

    @Test
    public void hasCollection() {
        assertEquals(12, breeder.getCollection().size());
        assertEquals(hugeDragon, breeder.getCollection().get(0));
    }

    @Test
    public void canCheckCollectionForAnimal() {
        breeder.findAnimalByIndex();
    }

    @Test
    public void canSellAnimal(){
        breeder.sell(mediumDragon, zoo);
        assertEquals(10_900, breeder.getSavings());
    }
}
