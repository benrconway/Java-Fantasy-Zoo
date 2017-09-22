package com.example.user.fantasyzooapp.people;

/**
 * Created by user on 22/09/2017.
 */

public abstract class Person {
    private String name;
    private int wallet;
    private int skill;

    public Person(String name, int wallet, int skill){
        this.name = name;
        this.wallet = wallet;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public int getWallet() {
        return wallet;
    }

    public int getSkill() {
        return skill;
    }
}
