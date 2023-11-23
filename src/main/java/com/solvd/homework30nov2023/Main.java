package com.solvd.homework30nov2023;

import com.solvd.homework30nov2023.custom.CustomLinkedList;
import com.solvd.homework30nov2023.exceptions.*;
import com.solvd.homework30nov2023.interfaces.*;
import com.solvd.homework30nov2023.models.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
//        homework2023oct30();
//        homework2023nov2();
//        homework2023nov6();
//        try {
//            homework2023nov9();
//        } catch (InvalidHealthException ihe) {
//            LOGGER.debug("Exception setting health: " + ihe);
//        }
//        homework2023nov13();
        homework2034nov21();
    }

    private static void homework2023oct30() {
        LOGGER.info("INDIVIDUAL ANIMAL TEST:\n" +
                "------------------------------------------------------------");
        LOGGER.info("\nDog:");
        Dog firulais = new Dog("Golden Retriever", "Domestic",6);
        firulais.makeNoise();
        firulais.move();

        LOGGER.info("\nCat:");
        Cat carlie = new Cat("Bobcat", "Wild", 6);
        carlie.makeNoise();
        carlie.move();

        LOGGER.info("\nLion:");
        Lion susan = new Lion("Lion", "Wild", 6);
        susan.makeNoise();
        susan.move();

        LOGGER.info("\nCrocodile:");
        Crocodile coco = new Crocodile("Crocodile", "Wild", 6);
        coco.makeNoise();
        coco.move();
        coco.swim();

        LOGGER.info("\nElephant:");
        // rupert is endangered, it can't be hunted
        Elephant rupert = new Elephant("Asian Elephant", "Endangered", 6);
        rupert.makeNoise();
        rupert.move();

        LOGGER.info("\nCapybara:");
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
            LOGGER.debug("Exception setting health: " + e);
        }

        LOGGER.info("""

                 HUNTER TEST:
                ------------------------------------------------------------""");

        Riffle riffle = new Riffle(70);
        Hunter john = new Hunter("John", 40, riffle);

        try {
            john.huntAnimal(susan); // susan is wild, it can be hunted
        } catch (NoWildAnimalException e) {
            LOGGER.debug("Exception: " + e);
        }
        try {
            john.huntAnimal(coco);  // cooc is in the zoo, it can't be hunted
        } catch (NoWildAnimalException e) {
            LOGGER.debug("Exception: " + e);
        }

        LOGGER.info("""

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

        LOGGER.info("""

                 USE OF ANIMAL ARRAY TEST:
                ------------------------------------------------------------""");

        Animal[] animals = {firulais, carlie, susan, coco, rupert, jim};
        for (Animal animal : animals) {
            LOGGER.info("\nAnimal: " + animal.getSpecie());
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
            LOGGER.debug("Exception setting health: " + e);
        }

        LOGGER.info("""

                 Example of use of polymorphism. Each Animal have its own
                 implementation of the method speak() and move() which
                 overrides the abstract method from the abstract Animal class:
                ------------------------------------------------------------""");

        Animal[] animals = {firulais, carlie, susan, coco, rupert, jim};
        Animal[] dummyAnimals = {dummyFirulais, dummyCarlie, dummySusan,
                dummyCoco, dummyRupert, dummyJim};
        int i = 0;
        for (Animal animal : animals) {
            LOGGER.info("\nCall animal.getSpecie(): " + animal.getSpecie());
            System.out.print("Call animal.speak(): ");
            animal.makeNoise();
            System.out.print("Call animal.move(): ");
            animal.move();
            LOGGER.info("Call toString(): " + animal);
            LOGGER.info("Call hashCode(): " + animal.hashCode());
            LOGGER.info("Call dummyAnimal.hashCode(): " + dummyAnimals[i].hashCode());
            LOGGER.info("Call animal.equals(dummyAnimal): " + animal.equals(dummyAnimals[i]));
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

        LOGGER.info("""

                 Polymorphism was used in the previous home-task, in this block
                 we'll use interfaces. Lets start with IRun interface, which
                 humans and animals alike implement.
                """);
        IRun[] runners = {firulais, carlie, susan, coco, rupert, jim, john, michael};
        for (IRun runner : runners) {
            runner.run();
        }

        LOGGER.info("""
                ------------------------------------------------------------
                ------------------------------------------------------------
                 IFly interface:
                 
                """);
        IFly[] flyers = {jeremy, rose};
        for (IFly flyer : flyers) {
            flyer.fly();
        }

        LOGGER.info("""
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

        LOGGER.info("""
                ------------------------------------------------------------
                ------------------------------------------------------------
                 IKillPrey interface:
                 
                """);
        IKillPrey[] hunters = {susan, coco};
        for(IKillPrey hunter : hunters) {
            hunter.killPray();
        }

        LOGGER.info("""
                ------------------------------------------------------------
                ------------------------------------------------------------
                 Test static field:
                 
                """);
        LOGGER.info("Cats instantiated till now: " + Cat.getNumberOfCats() +
                "\nI'll instantiate some more:");
        for (i = 0; i < 5; i++) {
            carlie = new Cat("Bobcat", "Wild", 6);
            LOGGER.info("Cats instantiated till now: " + Cat.getNumberOfCats());
        }
    }

    private static void homework2023nov9() throws InvalidHealthException {
        Dog spike = new Dog("Golden Retriever", "Domestic", 6);

        LOGGER.info("---------------------Try with resources:--------------------");
//        Try with resource
        int age = 0;
        LOGGER.info("Enter the new age of Spike:");
        try (Scanner sc = new Scanner(System.in)) {
            age = sc.nextInt();
        } catch (Exception e) {
            LOGGER.debug("Exception: " + e);
        }

        LOGGER.info("-------------------InvalidAgeException TEST:----------------");
        try {
            spike.setAge(age);
            LOGGER.debug("Everything went fine");
        } catch (InvalidAgeException iae) {
            LOGGER.debug("Exception setting age: " + iae);
        }



        LOGGER.info("-----------------NoWildAnimalException TEST:---------------");

        Lion susan = new Lion("Lion", "Wild", 6);

        Riffle riffle = new Riffle(70);
        Hunter john = new Hunter("John", 40, riffle);

        try {
            john.huntAnimal(susan); // susan is wild, it can be hunted
        } catch (NoWildAnimalException e) {
            LOGGER.debug("Exception: " + e);
        }
        try {
            john.huntAnimal(spike);  // spike is domestic, it can't be hunted
        } catch (NoWildAnimalException e) {
            LOGGER.debug("Exception: " + e);
        }

        LOGGER.info("------------------InvalidHungerException TEST:--------------");

        try {
            spike.setHunger(105);
        } catch (InvalidHungerException e) {
            LOGGER.debug("Exception: " + e);
        }

        LOGGER.info("----------------InvalidTirednessException TEST:-------------");

        try {
            spike.setTiredness(-5);
        } catch (InvalidTirednessException e) {
            LOGGER.debug("Exception: " + e);
        }

        LOGGER.info("--------InvalidHealthException TEST (this one is not " +
                    "dealt here, but is thrown to the calling method):-----");
//        pass the exception to the calling method
        spike.setHealth(101);
    }

    private static void homework2023nov13() {
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

        LOGGER.info("""

                 ------------------IRun ArrayList--------------------
                """);
        List<IRun> runners = new ArrayList<>();
        runners.add(firulais);
        runners.add(carlie);
        runners.add(carlie); // I can add duplicates
        runners.add(susan);
        runners.add(michael);
        for (IRun runner : runners) {
            runner.run();
        }

        LOGGER.info("""

                 ------------------Animal LinkedList--------------------
                """);
        List<Animal> animals = new LinkedList<>();
        animals.add(firulais);
        animals.add(carlie);
        animals.add(carlie); // I can add duplicates
        animals.add(susan);
        for (Animal animal : animals) {
            animal.move();
        }

        LOGGER.info("""

                 ------------------IFly HashSet--------------------
                """);
        Set<IFly> flyers = new HashSet<>();
        flyers.add(jeremy);
        flyers.add(rose);
        flyers.add(rose); // I can't add duplicates. There will be only two elements on the set
        for (IFly flyer : flyers) {
            flyer.fly();
        }

        LOGGER.info("""

                 --------------IPet and Pettable ArrayList---------------
                """);
        List<IPet> petters = new ArrayList<>();
        petters.add(john);
        petters.add(michael);
        List<Pettable> pettables = new ArrayList<>();
        pettables.add(firulais);
        pettables.add(carlie);

        int i = 0;
        for(IPet petter : petters) {
            petter.pet(pettables.get(i));
            i++;
        }

        LOGGER.info("""

                 --------------------CustomLInkedList-------------------------
                 Code was taken from:
                 https://www.geeksforgeeks.org/how-to-implement-generic-linkedlist-in-java/
                 I did a little bit of refactoring, changing names and access
                 modifiers to put the classes in different files. I also
                 made the CustomLinkedList implement iterable by adding the
                 helper classes and methods that were needed; I've taken those
                 from this source:
                 https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/
                """);
        CustomLinkedList<Animal> customList = new CustomLinkedList<>();
        customList.add(firulais);
        customList.add(carlie);
        customList.add(carlie); // I can add duplicates
        customList.add(susan);
        customList.remove(carlie); // I remove the extra cat

        LOGGER.info("CustomArreyList length: " + customList.length() + "\n");
        LOGGER.info("CustomArreyList toString() method: " + customList + "\n");

        LOGGER.info("CustomArreyList used in a For Each Loop: ");
        for (Animal element : customList) {
            element.move();
        }
    }

    private static void homework2034nov21() {
        File inputFile = new File("src/main/resources/text.txt");
        File outputFile = new File("src/main/resources/count.txt");

        List<String> lines = null;
        try {
            lines = FileUtils.readLines(inputFile);
        } catch (IOException e) {
            LOGGER.error("Exception: " + e);
        }

        String text;
        if(lines != null){
            text = String.join(", ", lines);
        } else {
            text = "default string";
        }

        text = text.replaceAll("[^A-Za-z ]", ""); // leave only words
        text = text.trim().replaceAll(" +", " "); // leave only unique space between words

        String[] words = StringUtils.split(text, " ");

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, ++count);
            } else {
                map.put(word, 1);
            }
        }

        try {
            FileUtils.delete(outputFile);
        } catch (IOException e) {
            LOGGER.error("Exception: " + e);
        }
//
        for (Entry<String, Integer> a: map.entrySet()) {
            try {
                FileUtils.writeStringToFile(
                        outputFile,
                        a.getKey() + " " + a.getValue() + "\n",
                        Charset.defaultCharset(),
                        true);
            } catch (IOException e) {
                LOGGER.error("Exception: " + e);
            }
        }
    }
}
