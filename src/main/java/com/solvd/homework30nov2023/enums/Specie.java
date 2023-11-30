package com.solvd.homework30nov2023.enums;

public enum Specie {
    CAPYBARA("Capybara", "Rodent") {
        @Override
        public String getInfo()  {
            return """
                    The capybara or greater capybara is a giant cavy rodent
                     native to South America. It is the largest living rodent
                     and a member of the genus Hydrochoerus.
                     The only other extant member is the lesser capybara.
                    """;
        }
    },
    CAT("Cat", "Mammal"){
        @Override
        public String getInfo()  {
            return """
                    The cat, commonly referred to as the domestic cat or house
                    cat, is the only domesticated species in the family Felidae.
                    Recent advances in archaeology and genetics have shown that
                    the domestication of the cat occurred in the Near East around
                    7500 BC.
                    """;
        }
    },
    CROCODILE("Crocodile", "Reptile"),
    DOG("Dog", "Mammal"),
    EAGLE("Eagle", "Bird"),
    ELEPHANT("Elephant", "Mammal"),
    LION("Lion", "Mammal"),
    NIGHTINGALE("Nightingale", "Bird");


    final private String name;
    final private String type;

    Specie(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getInfo() {
        return "Default information";
    }
}
