package com.example.user.fantasyzooapp.facilities;

import com.example.user.fantasyzooapp.animals.Animal;
import com.example.user.fantasyzooapp.animals.Size;
import com.example.user.fantasyzooapp.people.*;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class Environment extends Building {
    private ArrayList<Animal> animals;
    private ArrayList<Person> gallery;
    private ArrayList<Staff> keepers;
    private Enum<Size> size;

    public Environment(int value, int customerCapacity, int staffCapactity, Enum<Size> size){
        super(value, customerCapacity, staffCapactity);
        this.size = size;
        this.animals = new ArrayList<>();
        this.gallery = new ArrayList<>();
        this.keepers = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Person> getGallery() {
        return gallery;
    }

    public ArrayList<Staff> getKeepers() {
        return keepers;
    }

    public Enum<Size> getSize() {
        return size;
    }
}
