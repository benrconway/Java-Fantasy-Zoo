package com.example.user.fantasyzooapp.facilities;

import com.example.user.fantasyzooapp.animals.Animal;
import com.example.user.fantasyzooapp.animals.Size;
import com.example.user.fantasyzooapp.food.Flesh;
import com.example.user.fantasyzooapp.food.Vegetation;
import com.example.user.fantasyzooapp.people.Customer;
import com.example.user.fantasyzooapp.people.Person;
import com.example.user.fantasyzooapp.people.Staff;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 25/09/2017.
 */

public class Zoo {

    Random dm;

    private boolean gatesAreOpen;
    private int customerCapacity;
    private int ticketPrice;
    private int funds;
    private int day;
//    private int staffCounter;
//    private int customerCounter;

    private Environment hugeEnvironment;
    private Environment largeEnvironment;
    private Environment mediumEnvironment;
    private Environment smallEnvironment;

    private Staff staff;
    private Customer customer;

    private ArrayList<Person> roaming;
    private ArrayList<Person> generalPublic;
    private ArrayList<Staff> awaitingHire;
    private ArrayList<Vegetation> vegetableStock;
    private ArrayList<Flesh> meatStock;
    private ArrayList<Animal> loose;
    private ArrayList<Building> built;
    private ArrayList<Building> canBeBuilt;
//    private ArrayList<Building> beingBuilt;

    public Zoo() {
        gatesAreOpen = false;
        customerCapacity = 100;
        ticketPrice = 10;
        funds = 1_000_000;
        day = 0;
//        staffCounter = 0;
//        customerCounter = 1;


        roaming = new ArrayList<>();
        vegetableStock = new ArrayList<>();
        meatStock = new ArrayList<>();
        loose = new ArrayList<>();
        built = new ArrayList<>();
        setUpBuildingList();
        setUpStaffApplications();
        setUpAwaitingPublic();
    }

    private void setUpBuildingList() {
        hugeEnvironment = new Environment(30_000, 200, 50, Size.HUGE);
        largeEnvironment = new Environment(10_000, 100, 20, Size.LARGE);
        mediumEnvironment = new Environment(5_000, 30, 10, Size.MEDIUM);
        smallEnvironment = new Environment(2_000, 15, 5, Size.SMALL);
        canBeBuilt.add(hugeEnvironment);
        canBeBuilt.add(largeEnvironment);
        canBeBuilt.add(mediumEnvironment);
        canBeBuilt.add(smallEnvironment);
    }

    public void setUpStaffApplications() {
        staff = new Staff(300, 50, 65);
        awaitingHire.add(staff);
    }

    public void setUpAwaitingPublic() {
        customer = new Customer(5000, 60);
        generalPublic.add(customer);
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

    public void openGates() {
        gatesAreOpen = true;
    }

    public void closeGates() {
        gatesAreOpen = false;
    }

}
