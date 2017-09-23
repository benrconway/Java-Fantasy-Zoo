package com.example.user.fantasyzooapp.people;

import com.example.user.fantasyzooapp.facilities.Building;
import com.example.user.fantasyzooapp.facilities.Environment;

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

    public static void evacuate(Building building) {
        building.evacuate();
    }
}
