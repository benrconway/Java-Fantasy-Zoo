package com.example.user.fantasyzooapp.outsourcing;

import com.example.user.fantasyzooapp.food.Cabbage;
import com.example.user.fantasyzooapp.food.Edible;
import com.example.user.fantasyzooapp.food.Flesh;
import com.example.user.fantasyzooapp.food.Meat;
import com.example.user.fantasyzooapp.food.Vegetation;

import java.util.ArrayList;

/**
 * Created by user on 26/09/2017.
 */

public class FoodSupplier {
    private ArrayList<Vegetation> vegetableStock;
    private ArrayList<Flesh> fleshStock;

    public FoodSupplier() {
        fleshStock = new ArrayList<>();
        vegetableStock = new ArrayList<>();
        setUpStock();
    }

    public ArrayList<Flesh> getMeatStock() {
        return fleshStock;
    }

    public void setUpStock() {
        Meat meat = new Meat();
        Cabbage cabbage = new Cabbage();
        fleshStock.add(meat);
        vegetableStock.add(cabbage);
    }

    public Vegetation getVegetable() {
        return vegetableStock.get(0);
    }
}
