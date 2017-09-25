package com.example.user.fantasyzooapp.outsourcing;

import com.example.user.fantasyzooapp.people.Customer;

import java.util.ArrayList;

/**
 * Created by user on 25/09/2017.
 */

public class RiffRaff {
    private Customer customer;
    private ArrayList<Customer> riffRaff;

    public RiffRaff() {
        this.riffRaff = new ArrayList<>();
        setUpAwaitingPublic();
    }

    public void setUpAwaitingPublic() {
        customer = new Customer(5000, 60);
        riffRaff.add(customer);
    }
}
