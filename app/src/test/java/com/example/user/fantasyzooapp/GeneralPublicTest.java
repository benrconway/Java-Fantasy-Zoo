package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.outsourcing.GeneralPublic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 25/09/2017.
 */

public class GeneralPublicTest {

    GeneralPublic riffRaff;

    @Before
    public void before() {
        riffRaff = new GeneralPublic();
    }

    @Test
    public void hasArrayOfCustomers() {
        assertEquals(1, riffRaff.getPublic().size());
    }
}
