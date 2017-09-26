package com.example.user.fantasyzooapp.outsourcing;

import com.example.user.fantasyzooapp.facilities.Building;
import com.example.user.fantasyzooapp.facilities.Zoo;
import com.example.user.fantasyzooapp.people.Customer;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by user on 25/09/2017.
 */

public class GeneralPublic {
    private ArrayList<Customer> people;

    public GeneralPublic() {
        this.people = new ArrayList<>();
        setUpAwaitingPublic();
    }

    public void setUpAwaitingPublic() {
        Customer customer = new Customer(500, 60);
        people.add(customer);
    }

    public ArrayList<Customer> getPeople() {
        return people;
    }

    public void enter(Zoo zoo) {
        if(zoo.areTheGatesOpen()) {
            Customer person = people.get(0);
            zoo.sellTicket(person);
        }
    }

    public static void leave(int index, Zoo zoo) {
        if(zoo.areTheGatesOpen()) {
            zoo.customerLeaves(index);
        }

    }

}
