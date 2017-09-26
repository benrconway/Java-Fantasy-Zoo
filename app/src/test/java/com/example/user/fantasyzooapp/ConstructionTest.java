package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.outsourcing.Construction;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 25/09/2017.
 */

public class ConstructionTest {

    Construction contractor;

    @Before
    public void before() {
        contractor = new Construction();
    }

    @Test
    public void contractorHasArrayOfBuildings() {
        assertEquals(4, contractor.getCanBeBuilt().size());
    }
}
