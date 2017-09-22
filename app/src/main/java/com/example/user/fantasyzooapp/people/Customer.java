package com.example.user.fantasyzooapp.people;

/**
 * Created by user on 22/09/2017.
 */

public class Customer extends Person implements Consumer{
    public Customer(String name, int wallet, int skill){
        super(name, wallet, skill);
    }
}
