package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.animals.Bunyip;
import com.example.user.fantasyzooapp.animals.Dragon;
import com.example.user.fantasyzooapp.animals.Size;
import com.example.user.fantasyzooapp.animals.Unicorn;
import com.example.user.fantasyzooapp.facilities.Environment;
import com.example.user.fantasyzooapp.food.Cabbage;
import com.example.user.fantasyzooapp.food.Meat;
import com.example.user.fantasyzooapp.food.Vegetation;
import com.example.user.fantasyzooapp.people.Customer;
import com.example.user.fantasyzooapp.people.Staff;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class EnvironmentTest {
    Environment largeEnvironment;
    Environment mediumEnvironment;
    Environment smallEnvironment;
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
    Meat meat;
    Cabbage cabbage;

    @Before
    public void before(){
        meat = new Meat();
        cabbage = new Cabbage();
        staff1 = new Staff(500, 100, 70);
        staff2 = new Staff(1000, 150, 80);
        richCustomer = new Customer(10000, 40);
        poorCustomer = new Customer(50, 60);
        largeDragon = new Dragon("Talia", Size.LARGE, 3000);
        smallUnicorn = new Unicorn("Blaze", Size.SMALL, 600);
        mediumUnicorn = new Unicorn("Thunder", Size.MEDIUM, 700);
        largeUnicorn = new Unicorn("Bog", Size.LARGE, 600);
        mediumBunyip = new Bunyip("Terry", Size.MEDIUM, 1000);
        largeEnvironment = new Environment(100, 20, 5, Size.LARGE);
        mediumEnvironment = new Environment(100, 20, 5, Size.MEDIUM);
        smallEnvironment = new Environment(100, 20, 5, Size.SMALL);
        largeEnvironment.takeMeatFromStocks(meat);
        largeEnvironment.takeVegFromStocks(cabbage);
        mediumEnvironment.takeMeatFromStocks(meat);
        mediumEnvironment.takeVegFromStocks(cabbage);
        smallEnvironment.takeVegFromStocks(cabbage);
        largeEnvironment.openDoors();
    }

    @Test
    public void canGetDetails(){
        assertEquals(100, largeEnvironment.getValue());
        assertEquals(20, largeEnvironment.getViewingCapacity());
        assertEquals(5, largeEnvironment.getStaffCapacity());
        assertEquals(Size.LARGE, largeEnvironment.getSize());
        assertEquals(0, largeEnvironment.getAnimals().size());
        assertEquals(0, largeEnvironment.getFloorSpace().size());
        assertEquals(0, largeEnvironment.getWorkers().size());
        assertEquals(1, largeEnvironment.getLarder().size());
        assertEquals(1, largeEnvironment.getMeatLocker().size());
        assertEquals(true, largeEnvironment.checkIfOpen());
    }

    @Test
    public void canTakeInAnimal() {
        largeEnvironment.takeIn(mediumBunyip);
        assertEquals(1, largeEnvironment.getAnimals().size());
    }

    @Test
    public void canRemoveAnimal() {
        largeEnvironment.takeIn(mediumBunyip);
        largeEnvironment.takeIn(smallUnicorn);
        largeEnvironment.remove(mediumBunyip);
        assertEquals(1, largeEnvironment.getAnimals().size());
        assertEquals(smallUnicorn, largeEnvironment.getAnimals().get(0));
    }

    @Test
    public void peopleCanEnterFloorSpace() {
        largeEnvironment.enterBuilding(richCustomer);
        largeEnvironment.enterBuilding(staff1);
        assertEquals(2, largeEnvironment.getFloorSpace().size());
    }

    @Test
    public void staffCanBeSetAsKeepers() {
        largeEnvironment.goToStation(staff1);
        assertEquals(1, largeEnvironment.getWorkers().size());
    }

    @Test
    public void peopleCanLeaveFloorSpace() {
        largeEnvironment.enterBuilding(richCustomer);
        largeEnvironment.enterBuilding(poorCustomer);
        largeEnvironment.enterBuilding(staff1);
        largeEnvironment.leaveBuilding(poorCustomer);
        assertEquals(2, largeEnvironment.getFloorSpace().size());
        assertEquals(richCustomer, largeEnvironment.getFloorSpace().get(0));
        assertEquals(staff1, largeEnvironment.getFloorSpace().get(1));
    }

    @Test
    public void staffCanStopWorkingInThisBuilding() {
        largeEnvironment.goToStation(staff1);
        largeEnvironment.leaveStation(staff1);
        assertEquals(0, largeEnvironment.getWorkers().size());
    }

    @Test
    public void staffCanEvacuateBuilding() {
        largeEnvironment.enterBuilding(richCustomer);
        largeEnvironment.enterBuilding(poorCustomer);
        largeEnvironment.enterBuilding(staff1);
        Staff.evacuate(largeEnvironment);
        assertEquals(1, largeEnvironment.getFloorSpace().size());
    }

    @Test
    public void staffCanSecureBuilding() {
        largeEnvironment.enterBuilding(staff1);
        largeEnvironment.goToStation(staff2);
        Staff.secureGallery(largeEnvironment);
//        Staff.secureStation(largeEnvironment);
        assertEquals(0, largeEnvironment.getFloorSpace().size());
        assertEquals(false , largeEnvironment.checkIfOpen());
    }

    @Test
    public void canLimitVisitorsInViewingArea() {
        for(int index = 0; index < 25; index ++) {
            largeEnvironment.enterBuilding(richCustomer);
        }
        assertEquals(20, largeEnvironment.getFloorSpace().size());
    }

    @Test
    public void canLimitWorkersAtStation() {
        for(int index = 0; index < 8; index ++) {
            largeEnvironment.goToStation(staff1);
        }
        assertEquals(5, largeEnvironment.getWorkers().size());
    }

    @Test
    public void canLimitAnimalBasedOnSize() {
        largeEnvironment.takeIn(largeDragon);
        mediumEnvironment.takeIn(largeDragon);
        smallEnvironment.takeIn(largeDragon);
        mediumEnvironment.takeIn(largeUnicorn);
        smallEnvironment.takeIn(smallUnicorn);
        assertEquals(1,  largeEnvironment.getAnimals().size());
        assertEquals(0, mediumEnvironment.getAnimals().size());
        assertEquals(1, smallEnvironment.getAnimals().size());
    }

    @Test
    public void ensureHerbivoreCarnivoreSeparation() {
        largeEnvironment.takeIn(largeDragon);
        largeEnvironment.takeIn(smallUnicorn);
        assertEquals(1, largeEnvironment.getAnimals().size());
    }

    @Test
    public void testOmnivorePresence(){
        largeEnvironment.takeIn(mediumBunyip);
        largeEnvironment.takeIn(largeDragon);
        mediumEnvironment.takeIn(smallUnicorn);
        mediumEnvironment.takeIn(mediumBunyip);
        assertEquals(2, mediumEnvironment.getAnimals().size());
        assertEquals(1, largeEnvironment.getAnimals().size());
    }

    @Test
    public void canFeedAnimals() {
        largeEnvironment.takeIn(largeDragon);
        mediumEnvironment.takeIn(mediumBunyip);
        smallEnvironment.takeIn(smallUnicorn);
        largeEnvironment.feedCarnivore(largeDragon);
        mediumEnvironment.feedOmnivore(mediumBunyip);
        mediumEnvironment.feedOmnivore(mediumBunyip);
        smallEnvironment.feedHerbivore(smallUnicorn);
        assertEquals(1, largeDragon.getBelly().size());
        assertEquals(2, mediumBunyip.getBelly().size());
        assertEquals(1, smallUnicorn.getBelly().size());
    }



}
