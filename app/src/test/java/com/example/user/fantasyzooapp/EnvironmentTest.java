package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.animals.Bunyip;
import com.example.user.fantasyzooapp.animals.Dragon;
import com.example.user.fantasyzooapp.animals.Size;
import com.example.user.fantasyzooapp.animals.Unicorn;
import com.example.user.fantasyzooapp.facilities.Environment;
import com.example.user.fantasyzooapp.people.Customer;
import com.example.user.fantasyzooapp.people.Staff;

import org.junit.Before;

/**
 * Created by user on 22/09/2017.
 */

public class EnvironmentTest {
    Environment environment1;
//    Environment environment2;
//    Environment environment3;
//    Environment environment4;
    Staff staff1;
    Staff staff2;
    Customer customer1;
    Customer customer2;
    Dragon dragon;
    Unicorn unicorn1;
    Unicorn unicorn2;
    Unicorn unicorn3;
    Bunyip bunyip;

    @Before
    public void before(){
        staff1 = new Staff("George", 500, 100, 70);
        staff2 = new Staff("Pamela", 1000, 150, 80);
        customer1 = new Customer("Yobbo", 10000, 40);
        customer2 = new Customer("Robbo", 5000, 60);
        dragon = new Dragon("Talia", Size.LARGE, 3000);
        unicorn1 = new Unicorn("Blaze", Size.SMALL, 600);
        unicorn2 = new Unicorn("Thunder", Size.MEDIUM, 700);
        unicorn3 = new Unicorn("Bog", Size.SMALL, 600);
        bunyip = new Bunyip("Terry", Size.MEDIUM, 1000);
    }

}
