package com.example.user.fantasyzooapp.outsourcing;

import com.example.user.fantasyzooapp.facilities.Zoo;
import com.example.user.fantasyzooapp.people.Customer;

import java.util.ArrayList;

/**
 * Created by user on 25/09/2017.
 */

public class GeneralPublic {
    private Customer customer;
    private ArrayList<Customer> people;

    public GeneralPublic() {
        this.people = new ArrayList<>();
        setUpAwaitingPublic();
    }

    public void setUpAwaitingPublic() {
        customer = new Customer(500, 60);
        people.add(customer);
    }

    public void enter(Zoo zoo) {
        if(zoo.areTheGatesOpen()) {
            Customer person = people.get(0);
            zoo.sellTicket(person);
        }
    }
}
