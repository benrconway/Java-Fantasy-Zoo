package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.facilities.Zoo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
//    roaming = new ArrayList<>();
//    vegetableStock = new ArrayList<>();
//    meatStock = new ArrayList<>();
//    loose = new ArrayList<>();
//    built = new ArrayList<>();
//    contractor = new Construction();
//    recruiter = new RecruitmentAgency();
//    publicLiasonOfficer = new RiffRaff();

    @Test
    public void canRetrieveDetails() {
        assertEquals(false, zoo.areTheGatesOpen());
        assertEquals(100, zoo.getCustomerCapacity());
        assertEquals(10, zoo.getTicketPrice());
        assertEquals(1_000_000, zoo.getFunds());
        assertEquals(0, zoo.getDay());
        assertEquals(0, zoo.getRoaming().size());
        assertEquals(0, zoo.getMeatStock().size());
        assertEquals(0, zoo.getLoose().size());
        assertEquals(0, zoo.getBuilt().size());
        assertEquals(0, zoo.getVegetableStock().size());
    }


}
