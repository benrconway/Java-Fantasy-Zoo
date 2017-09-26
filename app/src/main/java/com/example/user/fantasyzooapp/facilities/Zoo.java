package com.example.user.fantasyzooapp.facilities;

import com.example.user.fantasyzooapp.animals.Animal;
import com.example.user.fantasyzooapp.food.Flesh;
import com.example.user.fantasyzooapp.food.Vegetation;
import com.example.user.fantasyzooapp.outsourcing.Breeder;
import com.example.user.fantasyzooapp.outsourcing.Construction;
import com.example.user.fantasyzooapp.outsourcing.FoodSupplier;
import com.example.user.fantasyzooapp.outsourcing.RecruitmentAgency;
import com.example.user.fantasyzooapp.people.Customer;
import com.example.user.fantasyzooapp.people.Person;
import com.example.user.fantasyzooapp.people.Staff;

import java.util.ArrayList;

/**
 * Created by user on 25/09/2017.
 */

public class Zoo {

//    Random dm;

    private boolean gatesAreOpen;
    private int customerCapacity;
    private int ticketPrice;
    private int funds;
    private int day;
    private int dailyTakings;
//    private int staffCounter;
//    private int customerCounter;

    private ArrayList<Customer> roaming;
    private ArrayList<Vegetation> vegetableStock;
    private ArrayList<Flesh> meatStock;
    private ArrayList<Animal> loose;
    private ArrayList<Animal> animalStorage;
    private ArrayList<Building> structures;
    private ArrayList<Environment> enclosures;
    private ArrayList<Staff> atWork;

//    private ArrayList<Building> beingBuilt;

    public Zoo() {
        gatesAreOpen = false;
        customerCapacity = 100;
        ticketPrice = 10;
        funds = 1_000_000;
        day = 0;
        dailyTakings = 0;
//        staffCounter = 0;
//        customerCounter = 0;
        atWork = new ArrayList<>();
        animalStorage = new ArrayList<>();
        roaming = new ArrayList<>();
        vegetableStock = new ArrayList<>();
        meatStock = new ArrayList<>();
        loose = new ArrayList<>();
        structures = new ArrayList<>();
        enclosures = new ArrayList<>();
    }


    public boolean areTheGatesOpen() {
        return gatesAreOpen;
    }

    public int getCustomerCapacity() {
        return customerCapacity;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getFunds() {
        return funds;
    }

    public int getDay() {
        return day;
    }

    public ArrayList<Animal> getAnimalStorage() {
        return animalStorage;
    }

    public ArrayList<Customer> getRoaming() {
        return roaming;
    }

    public ArrayList<Vegetation> getVegetableStock() {
        return vegetableStock;
    }

    public ArrayList<Flesh> getMeatStock() {
        return meatStock;
    }

    public ArrayList<Animal> getLoose() {
        return loose;
    }

    public ArrayList<Building> getStructures() {
        return structures;
    }

    public ArrayList<Staff> getAtWork() {
        return atWork;
    }

    public int getDailyTakings() {
        return dailyTakings;
    }

    public void openGates() {
        gatesAreOpen = true;
    }

    public void closeGates() {
        gatesAreOpen = false;
    }

    public void buyAnimalByIndex(int index, Breeder breeder) {
        Animal animal = breeder.getFromCollection(index);
        breeder.getsPaid(animal.getValue());
        funds -= animal.getValue();
        animalStorage.add(animal);
    }

    public void addStructureByIndex(int index, Construction contractor) {
        Building building = contractor.buildByIndex(index);
        funds -= building.getValue();
        structures.add(building);

    }

    public void hireStaff(RecruitmentAgency representative) {
        Staff staff = representative.transferStaff();
        atWork.add(staff);
        funds -= staff.getWallet();
    }

    public void restockVegetables(int quantity, FoodSupplier foodSupplier) {
        Vegetation food = null;
        for(int index = 0; index < quantity; index++) {
            food = foodSupplier.getVegetable();
            vegetableStock.add(food);
        }
        funds -= (quantity * food.getValue());
    }

    public void restockMeat(int quantity, FoodSupplier foodSupplier) {
        Flesh food = null;
        for(int index = 0; index < quantity; index++) {
            food = foodSupplier.getMeat();
            meatStock.add(food);
        }
        funds -= (quantity * food.getValue());
    }

    public void sellTicket(Customer person) {
        person.buyTicket(ticketPrice);
        dailyTakings += ticketPrice;
        roaming.add(person);
    }

    public Building structure(int index) {
         return structures.get(index);
    }

    public Staff staff(int index) {
        return atWork.get(index);
    }

    public void workAt(Staff staff, Building structure) {
        structure.goToStation(staff);
        atWork.remove(staff);
    }

    public void enter(Customer person, Building structure) {
        structure.enterBuilding(person);
        roaming.remove(person);
    }

    public Customer customer(int index) {
        return roaming.get(index);
    }


    public void openForBusiness() {
        openGates();
        for(Building facility: structures) {
            facility.openDoors();
        }
    }

    public Animal fromAnimalStorage(int index) {
        return animalStorage.get(0);
    }

    public void transfer(Animal animal, Building structure) {
        Environment enclosure = (Environment) structure;
        enclosure.takeIn(animal);
    }

    public void resupplyMeat(Building structure, int quantity) {
        for( int index = 0; index < quantity; index++) {
            transferMeat(structure);
        }

    }
    private void transferMeat(Building structure) {
        Environment enclosure = (Environment) structure;
        Flesh meat = meatStock.remove(0);
        enclosure.addToMeatLocker(meat);
    }

    public void resupplyVegetables(Building structure, int quantity) {
        for( int index = 0; index < quantity; index++) {
            transferVeg(structure);
        }

    }
    private void transferVeg(Building structure) {
        Environment enclosure = (Environment) structure;
        Vegetation vegetable = vegetableStock.remove(0);
        enclosure.addToLarder(vegetable);
    }

    public void customerExitsBuilding(int index, int building) {
        Customer customer = structure(building).getCustomer(index);
        roaming.add(customer);
        structure(building).leaveBuilding(customer);
    }

    public void staffLeaveStation(int index, int building) {
        Staff staff = structure(building).getStaff(index);
        atWork.add(staff);
        structure(building).leaveStation(staff);
    }



//    public void closeUpZoo() {
//        Zoo.clearZooOfCustomers();
//        Staff.secureBuildings();
//        closeGates();
//    }
//
//    private void endOfDay() {
//        Zoo.balanceAccounts();
//        Zoo.turnOutTheLights();
//        day++;
//    }
}
