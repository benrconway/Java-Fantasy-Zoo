package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.facilities.Zoo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 25/09/2017.
 */

public class ZooTest {

    Zoo zoo;

    @Before
    public void before() {
        zoo = new Zoo();
    }

    @Test
    public void canRetrieveDetails() {
        assertEquals(false, zoo.areTheGatesOpen());
        assertEquals();
    }
}
