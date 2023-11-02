package com.laba.aboher;


import com.laba.aboher.models.*;

public class Main {
    public static void main(String[] args) {
//        homework2023oct30();
        homework2023nov2();

    }

    private static void homework2023oct30() {
        System.out.println("INDIVIDUAL ANIMAL TEST:\n" +
                "------------------------------------------------------------");
        System.out.println("\nDog:");
        Dog firulais = new Dog("Golden Retriever", "Domestic");
        firulais.speak();
        firulais.move();

        System.out.println("\nCat:");
        Cat carlie = new Cat("Bobcat", "Wild");
        carlie.speak();
        carlie.move();

        System.out.println("\nLion:");
        Lion susan = new Lion("Lion", "Wild");
        susan.speak();
        susan.move();

        System.out.println("\nCrocodile:");
        Crocodile coco = new Crocodile("Crocodile", "Wild");
        coco.speak();
        coco.move();
        coco.swim();

        System.out.println("\nElephant:");
        // rupert is endangered, it can't be hunted
        Elephant rupert = new Elephant("Asian Elephant", "Endangered");
        rupert.speak();
        rupert.move();

        System.out.println("\nCapybara:");
        Capybara jim = new Capybara("Capybara", "Wild");
        jim.speak();
        jim.move();


        // cocoa and jim had been capture and they both are in the zoo now, they
        // can not be hunted anymore
        coco.setStatus("Zoo");
        jim.setStatus("Zoo");
        // coco has been injured in the capture process, a veterinarian will
        // heal him later.
        coco.setHealth(30);

        System.out.println("""

                 HUNTER TEST:
                ------------------------------------------------------------""");

        Riffle riffle = new Riffle(70);
        Hunter john = new Hunter("John", riffle);

        john.huntAnimal(susan); // susan is wild, it can be hunted
        john.huntAnimal(coco);  // cooc is in the zoo, it can't be hunted

        System.out.println("""

                 VETERINARIAN TEST:
                ------------------------------------------------------------""");

        Syringe syringe = new Syringe();
        Veterinarian michael = new Veterinarian("Michael", syringe);
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
            animal.speak();
            animal.move();
        }
    }

    public static void homework2023nov2() {
        Dog firulais = new Dog("Golden Retriever", "Domestic");
        Dog dummyFirulais = new Dog("Golden Retriever", "Domestic");

        Cat carlie = new Cat("Bobcat", "Wild");
        Cat dummyCarlie = new Cat("Bobcat", "Wild");

        Lion susan = new Lion("Lion", "Wild");
        Lion dummySusan = new Lion("Lion", "Wild");

        Crocodile coco = new Crocodile("Crocodile", "Wild");
        Crocodile dummyCoco = new Crocodile("Crocodile", "Wild");

        Elephant rupert = new Elephant("Asian Elephant", "Endangered");
        Elephant dummyRupert = new Elephant("Asian Elephant", "Endangered");

        Capybara jim = new Capybara("Capybara", "Wild");
        Capybara dummyJim = new Capybara("Capybara", "Wild");
        dummyJim.setHealth(75); // to test if the equals() method works properly

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
            animal.speak();
            System.out.print("Call animal.move(): ");
            animal.move();
            System.out.println("Call toString(): " + animal);
            System.out.println("Call hashCode(): " + animal.hashCode());
            System.out.println("Call dummyAnimal.hashCode(): " + dummyAnimals[i].hashCode());
            System.out.println("Call animal.equals(dummyAnimal): " + animal.equals(dummyAnimals[i]));
            i++;
        }
    }
}
