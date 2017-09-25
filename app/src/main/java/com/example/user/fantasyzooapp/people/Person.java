package com.example.user.fantasyzooapp.people;

import com.example.user.fantasyzooapp.food.Edible;
import com.example.user.fantasyzooapp.food.Flesh;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Person implements Edible, Flesh {
    private int wallet;
    private int skill;

    public Person(int wallet, int skill){
        this.wallet = wallet;
        this.skill = skill;
    }


    public int getWallet() {
        return wallet;
    }

    public int getSkill() {
        return skill;
    }
}
