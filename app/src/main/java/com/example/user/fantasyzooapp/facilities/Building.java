package com.example.user.fantasyzooapp.facilities;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Building {
    private int value;
    private int customerCapacity;
    private int staffCapacity;

    public Building(int value, int customerCapacity, int staffCapacity){
        this.value = value;
        this.customerCapacity = customerCapacity;
        this.staffCapacity = staffCapacity;
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
}
