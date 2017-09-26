package com.example.user.fantasyzooapp.animals;

import com.example.user.fantasyzooapp.behaviours.Dangerous;

/**
 * Created by user on 22/09/2017.
 */

public class Bunyip extends Omnivore implements Dangerous {
    public Bunyip(String name, Enum<Size> size, int value){
        super(name, size, value);
    }

    @Override
    public int breakOutModifier() {
        return getSize().ordinal() * 10;
    }

    public int breakOut(){
        return breakOutModifier();
    }
}
