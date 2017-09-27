package com.example.user.fantasyzooapp.people;

import com.example.user.fantasyzooapp.facilities.Building;
import com.example.user.fantasyzooapp.facilities.Zoo;

/**
 * Created by user on 22/09/2017.
 */

public class Keeper extends Person implements Staff{

    private int wage;

    public Keeper(int wallet, int wage, int skill){
        super(wallet, skill);
        this.wage = wage;
    }

    public int getWage() {
        return wage;
    }

    public static void evacuate(Building building) {
        building.evacuate();
    }

    public static void secureGallery(Building building) {
        building.secureFloorSpace();
    }


}
