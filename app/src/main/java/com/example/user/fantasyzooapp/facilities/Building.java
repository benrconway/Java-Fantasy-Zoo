package com.example.user.fantasyzooapp.facilities;

import com.example.user.fantasyzooapp.food.Flesh;
import com.example.user.fantasyzooapp.people.Customer;
import com.example.user.fantasyzooapp.people.Person;
import com.example.user.fantasyzooapp.people.Staff;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Building {
    private int value;
    private int viewingCapacity;
    private int staffCapacity;
    private boolean doorsOpen;
    private ArrayList<Person> floorSpace;
    private ArrayList<Staff> workers;

    public Building(int value, int viewingCapacity, int staffCapacity){
        this.doorsOpen = false;
        this.value = value;
        this.viewingCapacity = viewingCapacity;
        this.staffCapacity = staffCapacity;
        this.floorSpace = new ArrayList<>();
        this.workers = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public int getViewingCapacity() {
        return viewingCapacity;
    }

    public int getStaffCapacity() {
        return staffCapacity;
    }

    public ArrayList<Person> getFloorSpace() {
        return floorSpace;
    }

    public ArrayList<Staff> getWorkers() {
        return workers;
    }

    public boolean checkIfOpen() { return doorsOpen; }

    public void openDoors() {
        doorsOpen = true;
    }

    public void closeDoors() {
        doorsOpen = false;
    }

    public void enterBuilding(Person person) {
        if(doorsOpen && !buildingIsFull()) {
            floorSpace.add(person);
        }
    }

    public void goToStation(Staff staff) {
        if(!stationIsFull()) {
            workers.add(staff);
        }
    }

    public void leaveBuilding(Person person) {
        floorSpace.remove(person);
    }

    public void leaveStation(Staff staff) {
        workers.remove(staff);
    }

    public void evacuate() {
        ArrayList<Person> customersToLeave = checkForCustomers();
        for(Person customer: customersToLeave) {
            floorSpace.remove(customer);
        }
    }
//
//    public void secureWorkSpace() {
//        for (Staff staff: workers) {
//            staff.leaveStation();
//        }
//
//    }

    public void secureFloorSpace() {
        ArrayList<Person> staffToLeave = checkFloorForStaff();
        for(Person staff: staffToLeave) {
            floorSpace.remove(staff);
        }
        closeDoors();
    }

    public ArrayList<Person> checkForCustomers(){
        ArrayList<Person> customersToLeave = new ArrayList<>();
        for(Person person: floorSpace) {
            if(person instanceof Customer) {
                customersToLeave.add(person);
            }
        }
        return customersToLeave;
    }

    public ArrayList<Person> checkFloorForStaff(){
        ArrayList<Person> staffToLeave = new ArrayList<>();
        for(Person person: floorSpace) {
            if(person instanceof Staff) {
                staffToLeave.add(person);
            }
        }
        return staffToLeave;
    }

    public boolean buildingIsFull() {
        boolean isFull = false;
        if(floorSpace.size() >= viewingCapacity) {
            isFull = true;
        }
        return isFull;
    }

    public boolean stationIsFull() {
        boolean isFull = false;
        if(workers.size() >= staffCapacity){
            isFull = true;
        }
        return isFull;
    }


}
