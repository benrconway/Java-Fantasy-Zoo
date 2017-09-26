package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.facilities.*;
import com.example.user.fantasyzooapp.animals.*;
import com.example.user.fantasyzooapp.food.*;
import com.example.user.fantasyzooapp.outsourcing.*;
import com.example.user.fantasyzooapp.people.*;

/**
 * Created by user on 26/09/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Breeder breeder = new Breeder();
        Construction contractor = new Construction();
        RecruitmentAgency agencyRep = new RecruitmentAgency();
        FoodSupplier foodSupplier = new FoodSupplier();
        GeneralPublic generalPublic = new GeneralPublic();
        Zoo zoo = new Zoo();

        zoo.addStructureByIndex(2, contractor);
        zoo.addStructureByIndex(2, contractor);
        zoo.buyAnimalByIndex(7, breeder);
        zoo.transfer(0, 0);
        zoo.restockVegetables(100, foodSupplier);
        zoo.resupplyVegetables(1,100);

        zoo.hireStaff(agencyRep);
        zoo.hireStaff(agencyRep);
        zoo.hireStaff(agencyRep);
        zoo.openForBusiness();
        zoo.openGates();
        for(int index = 0; index < 19; index++) {
            generalPublic.enter(zoo);
        }

        zoo.enter(zoo.customer(0), 0);
        Environment enclosure = (Environment) zoo.structure(0);
        for(int index = 0; index < 7; index++) {
            enclosure.annoyTheAnimal(0);
        }
        while(enclosure.getAnimals().size() > 1){
        zoo.feedingTime(0, 0);
        }
        System.out.println("Breakout can occur");
    }
}
