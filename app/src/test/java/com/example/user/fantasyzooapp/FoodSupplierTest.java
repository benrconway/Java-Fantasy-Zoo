package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.outsourcing.FoodSupplier;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 26/09/2017.
 */

public class FoodSupplierTest {
    FoodSupplier shop;

    @Before
    public void before() {
        shop = new FoodSupplier();
    }

    @Test
    public void hasFoodArrays() {
        assertEquals(1, shop.getFleshStock().size());
        assertEquals(1, shop.getVegetableStock().size());
    }
 }
