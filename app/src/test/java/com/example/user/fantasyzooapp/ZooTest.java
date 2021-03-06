package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.animals.Herbivore;
import com.example.user.fantasyzooapp.facilities.Environment;
import com.example.user.fantasyzooapp.facilities.Zoo;
import com.example.user.fantasyzooapp.outsourcing.Breeder;
import com.example.user.fantasyzooapp.outsourcing.Construction;
import com.example.user.fantasyzooapp.outsourcing.FoodSupplier;
import com.example.user.fantasyzooapp.outsourcing.RecruitmentAgency;
import com.example.user.fantasyzooapp.outsourcing.GeneralPublic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 25/09/2017.
 */

public class ZooTest {

    Zoo zoo;
    Breeder breeder;
    Construction contractor;
    RecruitmentAgency agencyRep;
    FoodSupplier foodSupplier;
    GeneralPublic generalPublic;

    @Before
    public void before() {
        zoo = new Zoo();
        zoo.openGates();
        breeder = new Breeder();
        contractor = new Construction();
        agencyRep = new RecruitmentAgency();
        foodSupplier = new FoodSupplier();
        generalPublic = new GeneralPublic();
    }

    @Test
    public void canRetrieveDetails() {
        assertEquals(true, zoo.areTheGatesOpen());
        assertEquals(20, zoo.getCustomerCapacity());
        assertEquals(10, zoo.getTicketPrice());
        assertEquals(1_000_000, zoo.getFunds());
        assertEquals(0, zoo.getDay());
        assertEquals(0, zoo.getRoaming().size());
        assertEquals(0, zoo.getMeatStock().size());
        assertEquals(0, zoo.getLoose().size());
        assertEquals(0, zoo.getStructures().size());
        assertEquals(0, zoo.getVegetableStock().size());
    }

    @Test
    public void zooCanBuyFromBreeder() {
        //Buying a Huge Dragon which costs 30,000
        zoo.buyAnimalByIndex(0, breeder);
        assertEquals(1, zoo.getAnimalStorage().size());
        assertEquals(40_000, breeder.getSavings());
        assertEquals(970_000, zoo.getFunds());
    }

    @Test
    public void zooCanBuyInBuilding() {
        //Buying a huge environment for the dragon
        zoo.addStructureByIndex(0, contractor);
        assertEquals(1, zoo.getStructures().size());
        assertEquals(970_000, zoo.getFunds());

    }

    @Test
    public void zooCanHireStaff() {
        zoo.hireStaff(agencyRep);
        assertEquals(1, zoo.getAtWork().size());
        assertEquals(999_700, zoo.getFunds());
    }

    @Test
    public void canBuyInFoodStocks() {
        zoo.restockVegetables(10, foodSupplier);
        zoo.restockMeat(20, foodSupplier);
        assertEquals(10, zoo.getVegetableStock().size());
        assertEquals(20, zoo.getMeatStock().size());
        assertEquals(999_750, zoo.getFunds());
    }

    @Test
    public void generalPublicCanEnterZoo() {
        generalPublic.enter(zoo);
        assertEquals(1, zoo.getRoaming().size());
        assertEquals(10, zoo.getDailyTakings());
        assertEquals(490, zoo.getRoaming().get(0).getWallet());
        assertEquals(1, zoo.getCustomerCounter());
    }

    @Test
    public void keepingGatesClosedKeepsOutCustomers() {
        zoo.closeGates();
        generalPublic.enter(zoo);
        assertEquals(0, zoo.getRoaming().size());
    }

    @Test
    public void canAssignStaffToEnvironment() {
        zoo.hireStaff(agencyRep);
        zoo.addStructureByIndex(2, contractor);
        zoo.workAt(0, 0);
        assertEquals(1, zoo.structure(0).getWorkers().size());
        assertEquals(0, zoo.getAtWork().size());
    }

    @Test
    public void canReturnStaffToAtWork() {
        zoo.hireStaff(agencyRep);
        zoo.addStructureByIndex(2, contractor);
        zoo.workAt(0, 0);
        zoo.staffLeaveStation(0, 0);
        assertEquals(0, zoo.structure(0).getWorkers().size());
        assertEquals(1, zoo.getAtWork().size());
    }

    @Test
    public void peopleInZooCanEnterEnvironment() {
        zoo.addStructureByIndex(2, contractor);
        zoo.openForBusiness();
        generalPublic.enter(zoo);
        zoo.enter(zoo.customer(0), 0);
        assertEquals(1, zoo.structure(0).getFloorSpace().size());
        assertEquals(0, zoo.getRoaming().size());
    }

    @Test
    public void canTransferAnimalFromOutBackToEnvironment() {
        zoo.addStructureByIndex(0, contractor);
        zoo.buyAnimalByIndex(2, breeder);
        zoo.transfer(0, 0);
    }

    @Test
    public void canRestockEnclosuresMeatSupplies() {
        zoo.addStructureByIndex(3, contractor);
        zoo.restockMeat(10, foodSupplier);
        zoo.resupplyMeat(0, 10);
        Environment environment = (Environment) zoo.structure(0);
        assertEquals(10, environment.getMeatLocker().size());
    }

@Test
    public void canRestockEnclosuresVegSupplies() {
        zoo.addStructureByIndex(3, contractor);
        zoo.restockVegetables(10, foodSupplier);
        zoo.resupplyVegetables(0, 10);
        Environment environment = (Environment) zoo.structure(0);
        assertEquals(10, environment.getLarder().size());
    }

    @Test
    public void peopleInZooCanLeaveEnvironment() {
        zoo.addStructureByIndex(2, contractor);
        zoo.openForBusiness();
        generalPublic.enter(zoo);
        zoo.enter(zoo.customer(0), 0);
        zoo.customerExitsBuilding(0, 0);
        assertEquals(0, zoo.structure(0).getFloorSpace().size());
        assertEquals(1, zoo.getRoaming().size());
    }

    @Test
    public void zooUpdatesAsPeopleLeave(){
        generalPublic.enter(zoo);
        generalPublic.enter(zoo);
        generalPublic.enter(zoo);
        generalPublic.leave(0, zoo);
        assertEquals(2, zoo.getRoaming().size());
        assertEquals(2, zoo.getCustomerCounter());
    }

    @Test
    public void runtheZooForADay(){
        zoo.addStructureByIndex(2, contractor);
        zoo.addStructureByIndex(2, contractor);
        zoo.buyAnimalByIndex(7, breeder);
        zoo.transfer(0, 0);
        zoo.restockVegetables(1, foodSupplier);
        zoo.resupplyVegetables(1,1);
        Environment enclosure = (Environment) zoo.structure(0);
        Herbivore herbivore = (Herbivore) enclosure.animal(0);
        enclosure.feedHerbivore(herbivore);
        zoo.hireStaff(agencyRep);
        zoo.hireStaff(agencyRep);
        zoo.hireStaff(agencyRep);
        zoo.openForBusiness();
        zoo.openGates();
        for(int index = 0; index < 19; index++) {
            generalPublic.enter(zoo);
        }
        zoo.closeUpZoo();
        zoo.endOfDay();
        assertEquals(988135, zoo.getFunds());
        assertEquals(80, zoo.getCustomerCapacity());
        assertEquals(false, zoo.areTheGatesOpen());
        assertEquals(false, zoo.structure(0).checkIfOpen());
        assertEquals(0, herbivore.getBelly().size());
    }



//    @Test



}
