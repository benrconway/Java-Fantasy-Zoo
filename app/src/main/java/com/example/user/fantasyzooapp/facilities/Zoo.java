package com.example.user.fantasyzooapp.facilities;

import com.example.user.fantasyzooapp.animals.Animal;
import com.example.user.fantasyzooapp.food.Flesh;
import com.example.user.fantasyzooapp.food.Vegetation;
import com.example.user.fantasyzooapp.outsourcing.Breeder;
import com.example.user.fantasyzooapp.outsourcing.Building;
import com.example.user.fantasyzooapp.outsourcing.Construction;
import com.example.user.fantasyzooapp.outsourcing.FoodSupplier;
import com.example.user.fantasyzooapp.outsourcing.RecruitmentAgency;
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
//    private int staffCounter;
//    private int customerCounter;

    private ArrayList<Person> roaming;
    private ArrayList<Vegetation> vegetableStock;
    private ArrayList<Flesh> meatStock;
    private ArrayList<Animal> loose;
    private ArrayList<Animal> outBack;
    private ArrayList<Building> structures;
    private ArrayList<Staff> hired;

//    private ArrayList<Building> beingBuilt;

    public Zoo() {
        gatesAreOpen = false;
        customerCapacity = 100;
        ticketPrice = 10;
        funds = 1_000_000;
        day = 0;
//        staffCounter = 0;
//        customerCounter = 0;
        hired = new ArrayList<>();
        outBack = new ArrayList<>();
        roaming = new ArrayList<>();
        vegetableStock = new ArrayList<>();
        meatStock = new ArrayList<>();
        loose = new ArrayList<>();
        structures = new ArrayList<>();
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

    public ArrayList<Animal> getOutBack() {
        return outBack;
    }

    public ArrayList<Person> getRoaming() {
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

    public ArrayList<Staff> getHired() {
        return hired;
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
        outBack.add(animal);
    }

    public void addStructureByIndex(int index, Construction contractor) {
        Building building = contractor.buildByIndex(index);
        funds -= building.getValue();
        structures.add(building);

    }

    public void hireStaff(RecruitmentAgency representative) {
        Staff staff = representative.transferStaff();
        hired.add(staff);
        funds -= staff.getWallet();
    }

    public void restockVegetables(int quantity, FoodSupplier foodSupplier) {
        Vegetation food = null;
        for(int index = 0; index < quantity; index ++) {
            food = foodSupplier.getVegetable();
            vegetableStock.add(food);
        }

        funds -= (quantity * food.getValue());

    }
}
