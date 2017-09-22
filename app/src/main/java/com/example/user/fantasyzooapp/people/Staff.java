package com.example.user.fantasyzooapp.people;

/**
 * Created by user on 22/09/2017.
 */

public class Staff extends Person implements Keeper{

    private int wage;

    public Staff(String name, int wallet, int wage, int skill){
        super(name, wallet, skill);
        this.wage = wage;
    }

    public int getWage() {
        return wage;
    }
}
