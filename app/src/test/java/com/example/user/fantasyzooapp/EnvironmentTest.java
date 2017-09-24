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
    Environment environment2;
    Environment environment3;
//    Environment environment4;
    Staff staff1;
    Staff staff2;
    Customer richCustomer;
    Customer poorCustomer;
    Dragon largeDragon;
    Unicorn smallUnicorn;
    Unicorn mediumUnicorn;
    Unicorn largeUnicorn;
    Bunyip mediumBunyip;

    @Before
    public void before(){
        staff1 = new Staff("George", 500, 100, 70);
        staff2 = new Staff("Pamela", 1000, 150, 80);
        richCustomer = new Customer("Yobbo", 10000, 40);
        poorCustomer = new Customer("Robbo", 50, 60);
        largeDragon = new Dragon("Talia", Size.LARGE, 3000);
        smallUnicorn = new Unicorn("Blaze", Size.SMALL, 600);
        mediumUnicorn = new Unicorn("Thunder", Size.MEDIUM, 700);
        largeUnicorn = new Unicorn("Bog", Size.LARGE, 600);
        mediumBunyip = new Bunyip("Terry", Size.MEDIUM, 1000);
        environment1 = new Environment(100, 20, 5, Size.LARGE);
        environment2 = new Environment(100, 20, 5, Size.MEDIUM);
        environment3 = new Environment(100, 20, 5, Size.SMALL);
    }

    @Test
    public void canGetDetails(){
        assertEquals(100, environment1.getValue());
        assertEquals(20, environment1.getViewingCapacity());
        assertEquals(5, environment1.getStaffCapacity());
        assertEquals(Size.LARGE, environment1.getSize());
        assertEquals(0, environment1.getAnimals().size());
        assertEquals(0, environment1.getFloorSpace().size());
        assertEquals(0, environment1.getWorkers().size());
    }

    @Test
    public void canTakeInAnimal() {
        environment1.takeIn(mediumBunyip);
        assertEquals(1, environment1.getAnimals().size());
    }

    @Test
    public void canRemoveAnimal() {
        environment1.takeIn(mediumBunyip);
        environment1.takeIn(smallUnicorn);
        environment1.remove(mediumBunyip);
        assertEquals(1, environment1.getAnimals().size());
        assertEquals(smallUnicorn, environment1.getAnimals().get(0));
    }

    @Test
    public void peopleCanEnterFloorSpace() {
        environment1.enterBuilding(richCustomer);
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
        environment1.enterBuilding(richCustomer);
        environment1.enterBuilding(poorCustomer);
        environment1.enterBuilding(staff1);
        environment1.leaveBuilding(poorCustomer);
        assertEquals(2, environment1.getFloorSpace().size());
        assertEquals(richCustomer, environment1.getFloorSpace().get(0));
        assertEquals(staff1, environment1.getFloorSpace().get(1));
    }

    @Test
    public void staffCanStopWorkingInThisBuilding() {
        environment1.goToStation(staff1);
        environment1.leaveStation(staff1);
        assertEquals(0, environment1.getWorkers().size());
    }

    @Test
    public void staffCanEvacuateBuilding() {
        environment1.enterBuilding(richCustomer);
        environment1.enterBuilding(poorCustomer);
        environment1.enterBuilding(staff1);
        Staff.evacuate(environment1);
        assertEquals(1, environment1.getFloorSpace().size());
    }

    @Test
    public void canLimitVisitorsInViewingArea() {
        for(int index = 0; index < 25; index ++) {
            environment1.enterBuilding(richCustomer);
        }
        assertEquals(20, environment1.getFloorSpace().size());
    }

    @Test
    public void canLimitWorkersAtStation() {
        for(int index = 0; index < 8; index ++) {
            environment1.goToStation(staff1);
        }
        assertEquals(5, environment1.getWorkers().size());
    }

    @Test
    public void canLimitAnimalBasedOnSize() {
        environment1.takeIn(largeDragon);
        environment2.takeIn(largeDragon);
        environment3.takeIn(largeDragon);
        environment2.takeIn(largeUnicorn);
        environment3.takeIn(smallUnicorn);
        assertEquals(1,  environment1.getAnimals().size());
        assertEquals(0, environment2.getAnimals().size());
        assertEquals(1, environment3.getAnimals().size());
    }
}
