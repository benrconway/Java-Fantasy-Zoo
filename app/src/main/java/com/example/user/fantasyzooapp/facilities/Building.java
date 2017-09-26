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
    private ArrayList<Customer> floorSpace;
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

    public ArrayList<Customer> getFloorSpace() {
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

    public void enterBuilding(Customer person) {
        if(doorsOpen && !buildingIsFull()) {
            floorSpace.add(person);
        }
    }

    public void goToStation(Staff staff) {
        if(!stationIsFull()) {
            workers.add(staff);
        }
    }

    public Customer leaveBuilding(Customer person) {
        Customer customer = person;
        floorSpace.remove(person);
        return customer;
    }

    public void leaveStation(Staff staff) {
        workers.remove(staff);
    }

    public ArrayList<Customer> evacuate() {
        ArrayList<Customer> customersToLeave = getFloorSpace();
        floorSpace.clear();
        return customersToLeave;
    }

    public void secureFloorSpace() {
        closeDoors();
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


    public Customer getCustomer(int index) {
        return floorSpace.get(index);
    }

    public Staff getStaff(int index) {
        return workers.get(index);
    }

}
