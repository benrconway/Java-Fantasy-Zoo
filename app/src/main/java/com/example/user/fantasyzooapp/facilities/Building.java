package com.example.user.fantasyzooapp.facilities;

import com.example.user.fantasyzooapp.people.Person;
import com.example.user.fantasyzooapp.people.Staff;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Building {
    private int value;
    private int customerCapacity;
    private int staffCapacity;
    private ArrayList<Person> floorSpace;
    private ArrayList<Staff> workers;

    public Building(int value, int customerCapacity, int staffCapacity){
        this.value = value;
        this.customerCapacity = customerCapacity;
        this.staffCapacity = staffCapacity;
        this.floorSpace = new ArrayList<>();
        this.workers = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public int getCustomerCapacity() {
        return customerCapacity;
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

    public void enterBuilding(Person person) {
        floorSpace.add(person);
    }

    public void goToStation(Staff staff) {
        workers.add(staff);
    }

    public void leaveBuilding(Person person) {
        floorSpace.remove(person);
    }

    public void leaveStation(Staff staff) {
        workers.remove(staff);
    }
}
