package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.people.Customer;
import com.example.user.fantasyzooapp.people.Staff;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class PeopleTest {

    Staff staff;
    Customer customer;

    @Before
    public void before(){
        staff = new Staff("Tom", 500, 100, 60);
        customer = new Customer("Gail", 3000, 40);
    }

    @Test
    public void canGetDetails(){
        assertEquals("Tom", staff.getName());
        assertEquals(500, staff.getWallet());
        assertEquals(100, staff.getWage());
        assertEquals(60, staff.getSkill());
        assertEquals("Gail", customer.getName());
        assertEquals(3000, customer.getWallet());
        assertEquals(40, customer.getSkill());
    }




}
