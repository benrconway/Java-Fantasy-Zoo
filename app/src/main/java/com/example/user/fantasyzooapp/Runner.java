package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.facilities.*;
import com.example.user.fantasyzooapp.animals.*;
import com.example.user.fantasyzooapp.food.*;
import com.example.user.fantasyzooapp.outsourcing.*;
import com.example.user.fantasyzooapp.people.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by user on 26/09/2017.
 */

public class Runner {

    private Zoo zoo;
    private Breeder breeder;
    private Construction contractor;
    private GeneralPublic generalPublic;
    private RecruitmentAgency agencyRep;
    private FoodSupplier foodSupplier;
    private Scanner scannerInside;

    public Runner() {
        scannerInside = new Scanner(System.in);
        zoo = new Zoo();
        breeder = new Breeder();
        contractor = new Construction();
        agencyRep = new RecruitmentAgency();
        generalPublic = new GeneralPublic();
        foodSupplier = new FoodSupplier();

    }
    public void nextAction() {
        System.out.println("type command: ");
        String command = scannerInside.nextLine();
        switch (command) {
            case "demo":
                demo();
                break;
            case "help":
                help();
                break;
            case "built":
                built();
                break;
            case "RAMPAGE":
                rampage();
                break;
            default:
                System.out.println("404");

        }

    }

//    private void rampage() {
//        String result = zoo.rampage();
//        System.out.println(result);
//        zoo.bankrupt();
//    }

    private void built() {
        String buildings = new String();
        int counter = 1;
        for(Building building: zoo.getStructures()){
            Environment environement = (Environment) building;
            int animalsInside = environement.getAnimals().size();
            String toAdd = String.format("Building Number: %d: has %d animal(s) inside.\n", counter, animalsInside);
            buildings += toAdd;
            counter++;
        }
        System.out.println("Structures currently in the Playground:");
        System.out.println(buildings);
    }

    public void whatToDo() {
        String rules = "You are now the manager of Monster's Playground. \nYour mission should you" +
                "choose to accept it is to survive. You need to keep your animals and public happy, " +
                "your competitors will be knocking at your door. \nKeep yourself safe and MAKE LOTS" +
                " OF MONEY! \n" +
                "\n" +
                "";
        System.out.println(rules);
    }

    public void help() {
        String help = "A list of helpful commands: \n" +
                "- animalCatalogue - shows a list of indexed animals from the local breeder" +
                " with their price and size. \n" +
                "- buyAnimal(index) - you will use your funds to save this poor fantastic being from" +
                " a life of toil and servitude with the breeder into the wonderful static zoo life..." +
                "- animalsInStorage - shows a list of bought animals that don't yet have an enclosure. \n"+
                "- transferAnimal(animalIndex, buildingIndex) - when bought an animal is kept out of" +
                "customer sight, this command will move your animal into an enclosure, or between them" +
                "... just in case you want to move it into a new home. Maybe a bigger one?" +
                "\n" +
                "- built - shows a list of structures in your current version of Monster's Playground.\n" +
                "- buildingCatalogue - shows a list of indexed buildings with their price and size. \n" +
                "- buyBuilding(index) - will buy the building based on the index listed in the catalogue. \n" +
                "\n" +
                "- foodCatalogue - shows a catalogue of food available from your local Tesco.\n " +
                "- restockMeat(index) - replace index with how many units of meat you want to buy in. \n" +
                "- restockVegetables(index) - replace index with how many units of vegetation you want to buy in. \n" +
                "- ressuplyVegetables(buildingIndex, quantity) - replace index with the building to be resupplied" +
                "and quantity with how much they will receive.\n" +
                "- resupplyMeat(buildingIndex, quantity) - choose your building by index and send them" +
                "your prescribed quantity of meat.\n" +
                "- feedAnimals - will send staff around your zoo to feed all the animals. Hope you have enough food.\n" +
                "\n" +
                "- openForBusiness - open the gates and get some local yokels in the doors to spend their money.\n" +
                "- closingTime -  move the people along, close the exhibits and the gates... count your earnings. \n" +
                "- endOfDay - kick your shoes off for the day and rest till tomorrow starts again.\n"+
                "\n" +
                "And just in case you have an angry animal break out....\n" +
                "- calmDown - sends your magical staff out to attempt to calm any animals loose in the grounds.\n" +
                "- scareOff - send out your staff to try to drive the animal away.\n" +
                "\n";
        System.out.println(help);
    }

    public void demo() {
        zoo.addStructureByIndex(0, contractor);
        zoo.buyAnimalByIndex(0, breeder);
//        zoo.transfer(0, 0);
        zoo.addStructureByIndex(0, contractor);
        zoo.buyAnimalByIndex(1, breeder);
//        zoo.transfer(0, 1);
        zoo.addStructureByIndex(0, contractor);
        zoo.buyAnimalByIndex(2, breeder);
        zoo.allYourBase();
//        zoo.transfer(0, 2);
        zoo.buyAnimalByIndex(3, breeder);
//        zoo.transfer(0, 2);
        zoo.addStructureByIndex(0, contractor);
        zoo.buyAnimalByIndex(4, breeder);
//        zoo.transfer(0, 3);
        zoo.buyAnimalByIndex(5, breeder);
//        zoo.transfer(0, 3);
        zoo.buyAnimalByIndex(6, breeder);
//        zoo.transfer(0, 3);
        zoo.buyAnimalByIndex(7, breeder);
//        zoo.transfer(0, 3);

        zoo.allYourBase();

        zoo.addStructureByIndex(0, contractor);
        zoo.buyAnimalByIndex(8, breeder);
//        zoo.transfer(0, 4);
        zoo.addStructureByIndex(0, contractor);
        zoo.buyAnimalByIndex(9, breeder);
//        zoo.transfer(0, 5);
        zoo.buyAnimalByIndex(10, breeder);
//        zoo.transfer(0, 5);
        zoo.addStructureByIndex(2, contractor);
        zoo.buyAnimalByIndex(11, breeder);

        zoo.restockVegetables(100, foodSupplier);
        zoo.restockMeat(100, foodSupplier);
        zoo.hireStaff(agencyRep);
        zoo.hireStaff(agencyRep);
        zoo.hireStaff(agencyRep);
        zoo.openForBusiness();
        zoo.openGates();
        for(int index = 0; index < 19; index++) {
            generalPublic.enter(zoo);
        }
    }

    public void rampage(){
        Random dm = new Random();
        String result = new String();
        ArrayList<Animal> animalsPresent = new ArrayList<>();
        for (Animal animal: zoo.getAnimalStorage()) {
            animalsPresent.add(animal);
        }

        for (Building building: zoo.getStructures()) {
            Environment environement = (Environment) building;
            for (Animal animal: environement.getAnimals()){
                animalsPresent.add(animal);
            }
        }

        for (Animal animal: animalsPresent) {
            int randomness = dm.nextInt(10);
            String first = String.format("%s\'s eyes glow red.\n", animal.getName());
            result += first;
            if(randomness > 4 ) {
                String second = String.format("%s has been consumed by rage and breaks free!\n", animal.getName());
                result += second;
            }else {
                String second = String.format("%s shudders and shakes, the glow of the blood moon " +
                        "waning from its eyes.\n", animal.getName());
                result += second;
            }
        }
        System.out.println("The Blood Moon rises...");
        System.out.println(result);
        String endOfDays = "\nYou wander through the shattered ashes of your zoo after the Blood Moon." +
                "\nMayhaps we should have listened to Dr Malcolm.";
        System.out.println(endOfDays);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        zoo.bankrupt();
    }


    public static void main(String[] args) {
        Random dm = new Random();
        Runner runner = new Runner();
        Scanner scanner = new Scanner(System.in);
        runner.whatToDo();
        System.out.println("What is the name of our new Manager?");
        String name = scanner.nextLine();
        String msg = String.format("\nWelcome %s, your zoo awaits.\n" +
                "if you get lost, try calling 'help'.", name);
        System.out.println(msg);
        while(runner.zoo.getFunds() >0)
        runner.nextAction();
    }
}

