package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.animals.Carnivore;
import com.example.user.fantasyzooapp.animals.Herbivore;
import com.example.user.fantasyzooapp.animals.Omnivore;
import com.example.user.fantasyzooapp.animals.Size;
import com.example.user.fantasyzooapp.food.Cabbage;
import com.example.user.fantasyzooapp.food.Meat;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 22/09/2017.
 */

public class AnimalTest {


    Cabbage cabbage;
    Meat meat;

    @Before
    public void before(){
        omnivore = new Omnivore("George", Size.HUGE, 5000);
        carnivore = new Carnivore("Pamela", Size.MEDIUM, 2000);
        herbivore = new Herbivore("Salazah", Size.SMALL, 500);
        meat = new Meat();
        cabbage = new Cabbage();
    }

    @Test
    public void canGetAnimalDetails(){
        omnivore
    }

}
