package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.animals.Bunyip;
import com.example.user.fantasyzooapp.animals.Carnivore;
import com.example.user.fantasyzooapp.animals.Dragon;
import com.example.user.fantasyzooapp.animals.Herbivore;
import com.example.user.fantasyzooapp.animals.Omnivore;
import com.example.user.fantasyzooapp.animals.Size;
import com.example.user.fantasyzooapp.animals.Unicorn;
import com.example.user.fantasyzooapp.food.Cabbage;
import com.example.user.fantasyzooapp.food.Meat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class AnimalTest {

    Bunyip bunyip;
    Unicorn unicorn;
    Dragon dragon;
    Cabbage cabbage;
    Meat meat;

    @Before
    public void before(){
        bunyip = new Bunyip("George", Size.MEDIUM, 5000);
        dragon = new Dragon("Pamela", Size.HUGE, 2000);
        unicorn = new Unicorn("Salazah", Size.SMALL, 500);
        meat = new Meat();
        cabbage = new Cabbage();
    }

    @Test
    public void canGetAnimalDetails(){
        assertEquals("George", bunyip.getName());
        assertEquals(Size.MEDIUM, bunyip.getSize());
        assertEquals(5000, bunyip.getValue());
        assertEquals("Pamela", dragon.getName());
        assertEquals(Size.HUGE, dragon.getSize());
        assertEquals(2000, dragon.getValue());
        assertEquals("Salazah", unicorn.getName());
        assertEquals(Size.SMALL, unicorn.getSize());
        assertEquals(500, unicorn.getValue());
    }

    @Test
    public void carnivoreCanEatMeat(){
        dragon.eat(meat);
        assertEquals(1, dragon.getBelly().size());
    }

    @Test
    public void herbivoreCanEatVegetation(){
        unicorn.eat(cabbage);
        assertEquals(1, unicorn.getBelly().size());
    }

    @Test
    public void omnivoreCanEatAnythingEdible(){
        bunyip.eat(meat);
        bunyip.eat(cabbage);
        assertEquals(2, bunyip.getBelly().size());
    }

    @Test
    public void dragonCanFly(){
        String result = dragon.fly();
        assertEquals("The dragon takes a deep breath and launches into the air", result);
    }
}
