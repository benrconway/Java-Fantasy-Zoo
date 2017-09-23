package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.animals.Bunyip;
import com.example.user.fantasyzooapp.animals.Dragon;
import com.example.user.fantasyzooapp.animals.Size;
import com.example.user.fantasyzooapp.animals.Unicorn;
import com.example.user.fantasyzooapp.facilities.Environment;
import com.example.user.fantasyzooapp.people.Customer;
import com.example.user.fantasyzooapp.people.Staff;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        environment1 = new Environment(100, 20, 5, Size.LARGE);
    }

    @Test
    public void canGetDetails(){
        assertEquals(100, environment1.getValue());
        assertEquals(20, environment1.getCustomerCapacity());
        assertEquals(5, environment1.getStaffCapacity());
        assertEquals(Size.LARGE, environment1.getSize());
        assertEquals(0, environment1.getAnimals().size());
        assertEquals(0, environment1.getFloorSpace().size());
        assertEquals(0, environment1.getWorkers().size());
    }

    @Test
    public void canTakeInAnimal() {
        environment1.takeIn(bunyip);
        assertEquals(1, environment1.getAnimals().size());
    }

    @Test
    public void canRemoveAnimal() {
        environment1.takeIn(bunyip);
        environment1.takeIn(unicorn1);
        environment1.remove(bunyip);
        assertEquals(1, environment1.getAnimals().size());
        assertEquals(unicorn1, environment1.getAnimals().get(0));
    }

    @Test
    public void peopleCanEnterFloorSpace() {
        environment1.enterBuilding(customer1);
        environment1.enterBuilding(staff1);
        assertEquals(2, environment1.getFloorSpace().size());
    }

    @Test
    public void staffCanBeSetAsKeepers() {
        environment1.goToStation(staff1);
        assertEquals(1, environment1.getWorkers().size());
    }

    @Test
    public void peopleCanLeaveFloorSpace() {
        environment1.enterBuilding(customer1);
        environment1.enterBuilding(customer2);
        environment1.enterBuilding(staff1);
        environment1.leaveBuilding(customer2);
        assertEquals(2, environment1.getFloorSpace().size());
        assertEquals(customer1, environment1.getFloorSpace().get(0));
        assertEquals(staff1, environment1.getFloorSpace().get(1));
    }

    @Test
    public void staffCanStopWorkingInThisBuilding() {
        environment1.goToStation(staff1);
        environment1.leaveStation(staff1);
        assertEquals(0, environment1.getWorkers().size());

    }


}
