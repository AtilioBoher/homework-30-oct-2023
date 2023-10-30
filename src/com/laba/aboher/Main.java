package com.laba.aboher;


import com.laba.aboher.models.*;

public class Main {
    public static void main(String[] args) {
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
}
