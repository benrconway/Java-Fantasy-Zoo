package com.example.user.fantasyzooapp.outsourcing;

import com.example.user.fantasyzooapp.animals.Size;

import java.util.ArrayList;

/**
 * Created by user on 25/09/2017.
 */

public class Construction {

    private ArrayList<Building> canBeBuilt;

    public Construction(){
        canBeBuilt = new ArrayList<>();
        setUpBuildingList();
    }

    public ArrayList<Building> getCanBeBuilt() {
        return canBeBuilt;
    }

    private void setUpBuildingList() {
        Environment hugeEnvironment = new Environment(30_000, 200, 50, Size.HUGE);
        Environment largeEnvironment = new Environment(10_000, 100, 20, Size.LARGE);
        Environment mediumEnvironment = new Environment(5_000, 30, 10, Size.MEDIUM);
        Environment smallEnvironment = new Environment(2_000, 15, 5, Size.SMALL);
        canBeBuilt.add(hugeEnvironment);
        canBeBuilt.add(largeEnvironment);
        canBeBuilt.add(mediumEnvironment);
        canBeBuilt.add(smallEnvironment);
    }

    public Building buildByIndex(int index) {
        return canBeBuilt.get(index);
    }
}
