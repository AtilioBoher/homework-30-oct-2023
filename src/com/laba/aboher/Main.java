package com.laba.aboher;


import com.laba.aboher.exceptions.*;
import com.laba.aboher.interfaces.*;
import com.laba.aboher.models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        homework2023oct30();
//        homework2023nov2();
//        homework2023nov6();
        try {
            homework2023nov9();
        } catch (InvalidHealthException ihe) {
            System.out.println("Exception setting health: " + ihe);
        }
    }

    private static void homework2023oct30() {
        System.out.println("INDIVIDUAL ANIMAL TEST:\n" +
                "------------------------------------------------------------");
        System.out.println("\nDog:");
        Dog firulais = new Dog("Golden Retriever", "Domestic",6);
        firulais.makeNoise();
        firulais.move();

        System.out.println("\nCat:");
        Cat carlie = new Cat("Bobcat", "Wild", 6);
        carlie.makeNoise();
        carlie.move();

        System.out.println("\nLion:");
        Lion susan = new Lion("Lion", "Wild", 6);
        susan.makeNoise();
        susan.move();

        System.out.println("\nCrocodile:");
        Crocodile coco = new Crocodile("Crocodile", "Wild", 6);
        coco.makeNoise();
        coco.move();
        coco.swim();

        System.out.println("\nElephant:");
        // rupert is endangered, it can't be hunted
        Elephant rupert = new Elephant("Asian Elephant", "Endangered", 6);
        rupert.makeNoise();
        rupert.move();

        System.out.println("\nCapybara:");
        Capybara jim = new Capybara("Capybara", "Wild", 6);
        jim.makeNoise();
        jim.move();


        // cocoa and jim had been capture and they both are in the zoo now, they
        // can not be hunted anymore
        coco.setStatus("Zoo");
        jim.setStatus("Zoo");
        // coco has been injured in the capture process, a veterinarian will
        // heal him later.
        try {
            coco.setHealth(30);
        } catch (InvalidHealthException e) {
            System.out.println("Exception setting health: " + e);
        }

        System.out.println("""

                 HUNTER TEST:
                ------------------------------------------------------------""");

        Riffle riffle = new Riffle(70);
        Hunter john = new Hunter("John", 40, riffle);

        try {
            john.huntAnimal(susan); // susan is wild, it can be hunted
        } catch (NoWildAnimalException e) {
            System.out.println("Exception: " + e);
        }
        try {
            john.huntAnimal(coco);  // cooc is in the zoo, it can't be hunted
        } catch (NoWildAnimalException e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("""

                 VETERINARIAN TEST:
                ------------------------------------------------------------""");

        Syringe syringe = new Syringe();
        Veterinarian michael = new Veterinarian("Michael", 40, syringe);
        michael.healAnimal(coco);
        // Now that coco is well, it can't be healed if we try again because
        // his health is 100% now.
        // We load the syringe before trying.
        michael.getSyringe().setLoaded(true);
        michael.healAnimal(coco);

        System.out.println("""

                 USE OF ANIMAL ARRAY TEST:
                ------------------------------------------------------------""");

        Animal[] animals = {firulais, carlie, susan, coco, rupert, jim};
        for (Animal animal : animals) {
            System.out.println("\nAnimal: " + animal.getSpecie());
            animal.makeNoise();
            animal.move();
        }
    }

    public static void homework2023nov2() {
        Dog firulais = new Dog("Golden Retriever", "Domestic", 6);
        Dog dummyFirulais = new Dog("Golden Retriever", "Domestic", 6);

        Cat carlie = new Cat("Bobcat", "Wild", 6);
        Cat dummyCarlie = new Cat("Bobcat", "Wild", 6);

        Lion susan = new Lion("Lion", "Wild", 6);
        Lion dummySusan = new Lion("Lion", "Wild", 6);

        Crocodile coco = new Crocodile("Crocodile", "Wild", 6);
        Crocodile dummyCoco = new Crocodile("Crocodile", "Wild", 6);

        Elephant rupert = new Elephant("Asian Elephant", "Endangered", 6);
        Elephant dummyRupert = new Elephant("Asian Elephant", "Endangered", 6);

        Capybara jim = new Capybara("Capybara", "Wild", 6);
        Capybara dummyJim = new Capybara("Capybara", "Wild", 6);
        try {
            dummyJim.setHealth(75); // to test if the equals() method works properly
        } catch (InvalidHealthException e) {
            System.out.println("Exception setting health: " + e);
        }

        System.out.println("""

                 Example of use of polymorphism. Each Animal have its own
                 implementation of the method speak() and move() which
                 overrides the abstract method from the abstract Animal class:
                ------------------------------------------------------------""");

        Animal[] animals = {firulais, carlie, susan, coco, rupert, jim};
        Animal[] dummyAnimals = {dummyFirulais, dummyCarlie, dummySusan,
                dummyCoco, dummyRupert, dummyJim};
        int i = 0;
        for (Animal animal : animals) {
            System.out.println("\nCall animal.getSpecie(): " + animal.getSpecie());
            System.out.print("Call animal.speak(): ");
            animal.makeNoise();
            System.out.print("Call animal.move(): ");
            animal.move();
            System.out.println("Call toString(): " + animal);
            System.out.println("Call hashCode(): " + animal.hashCode());
            System.out.println("Call dummyAnimal.hashCode(): " + dummyAnimals[i].hashCode());
            System.out.println("Call animal.equals(dummyAnimal): " + animal.equals(dummyAnimals[i]));
            i++;
        }
    }

    public static void homework2023nov6() {
        // Animals
        Dog firulais = new Dog("Golden Retriever", "Domestic", 6);
        Cat carlie = new Cat("Bobcat", "Wild", 6);
        Lion susan = new Lion("Lion", "Wild", 6);
        Crocodile coco = new Crocodile("Crocodile", "Wild", 6);
        Elephant rupert = new Elephant("Asian Elephant", "Endangered", 6);
        Capybara jim = new Capybara("Capybara", "Wild", 6);
        Eagle jeremy = new Eagle("Eagle","Wild", 6);
        Nightingale rose = new Nightingale("Nightingale","Wild", 6);
        // Humans
        // Hunter
        Riffle riffle = new Riffle(70);
        Hunter john = new Hunter("John", 40, riffle);
        // Veterinarian
        Syringe syringe = new Syringe();
        Veterinarian michael = new Veterinarian("Michael", 40, syringe);

        System.out.println("""

                 Polymorphism was used in the previous home-task, in this block
                 we'll use interfaces. Lets start with IRun interface, which
                 humans and animals alike implement.
                """);
        IRun[] runners = {firulais, carlie, susan, coco, rupert, jim, john, michael};
        for (IRun runner : runners) {
            runner.run();
        }

        System.out.println("""
                ------------------------------------------------------------
                ------------------------------------------------------------
                 IFly interface:
                 
                """);
        IFly[] flyers = {jeremy, rose};
        for (IFly flyer : flyers) {
            flyer.fly();
        }

        System.out.println("""
                ------------------------------------------------------------
                ------------------------------------------------------------
                 IPet interface:
                 
                """);
        // I defined two petter objects and two pettable objects.
        IPet[] petters = {john, michael};
        Pettable[] pettables = {firulais, carlie};
        int i = 0;
        for(IPet petter : petters) {
            petter.pet(pettables[i]);
            i++;
        }

        System.out.println("""
                ------------------------------------------------------------
                ------------------------------------------------------------
                 IKillPrey interface:
                 
                """);
        IKillPrey[] hunters = {susan, coco};
        for(IKillPrey hunter : hunters) {
            hunter.killPray();
        }

        System.out.println("""
                ------------------------------------------------------------
                ------------------------------------------------------------
                 Test static field:
                 
                """);
        System.out.println("Cats instantiated till now: " + Cat.getNumberOfCats() +
                "\nI'll instantiate some more:");
        for (i = 0; i < 5; i++) {
            carlie = new Cat("Bobcat", "Wild", 6);
            System.out.println("Cats instantiated till now: " + Cat.getNumberOfCats());
        }
    }

    private static void homework2023nov9() throws InvalidHealthException {
        Dog spike = new Dog("Golden Retriever", "Domestic", 6);

        System.out.println("""
                 \n\n\n                 
                 ------------------------------------------------------------
                 ------------------------------------------------------------
                 Try with resources:
                ------------------------------------------------------------""");
//        Try with resource
        int age = 0;
        System.out.println("Enter the new age of Spike:");
        try (Scanner sc = new Scanner(System.in)) {
            age = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("""
                 \n\n\n                 
                 ------------------------------------------------------------
                 ------------------------------------------------------------
                 InvalidAgeException TEST:
                ------------------------------------------------------------""");
        try {
            spike.setAge(age);
        } catch (InvalidAgeException iae) {
            System.out.println("Exception setting age: " + iae);
        }



        System.out.println("""
                 \n\n\n                 
                 ------------------------------------------------------------
                 ------------------------------------------------------------
                 NoWildAnimalException TEST:
                ------------------------------------------------------------""");

        Lion susan = new Lion("Lion", "Wild", 6);

        Riffle riffle = new Riffle(70);
        Hunter john = new Hunter("John", 40, riffle);

        try {
            john.huntAnimal(susan); // susan is wild, it can be hunted
        } catch (NoWildAnimalException e) {
            System.out.println("Exception: " + e);
        }
        try {
            john.huntAnimal(spike);  // spike is domestic, it can't be hunted
        } catch (NoWildAnimalException e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("""
                 \n\n\n
                 ------------------------------------------------------------
                 ------------------------------------------------------------
                 InvalidHungerException TEST:
                ------------------------------------------------------------""");

        try {
            spike.setHunger(105);
        } catch (InvalidHungerException e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("""
                 \n\n\n
                 ------------------------------------------------------------
                 ------------------------------------------------------------
                 InvalidTirednessException TEST:
                ------------------------------------------------------------""");

        try {
            spike.setTiredness(-5);
        } catch (InvalidTirednessException e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("""
                 \n\n\n
                 ------------------------------------------------------------
                 ------------------------------------------------------------
                 InvalidHealthException TEST (this one is not
                 dealt here, but is thrown to the calling method):
                ------------------------------------------------------------""");
//        pass the exception to the calling method
        spike.setHealth(101);
    }
}
