package com.solvd.homework30nov2023.designPatterns.builder;

public class Mascot {

    private String name;
    private String specie;
    private String status;
    private String placeOfOrigin;
    private int age;
    private int cageId;
    private int tagId;

    public String getName() {
        return name;
    }

    public String getSpecie() {
        return specie;
    }

    public String getStatus() {
        return status;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public int getAge() {
        return age;
    }

    public int getCageId() {
        return cageId;
    }

    public int getTagId() {
        return tagId;
    }

    @Override
    public String toString() {
        return "Mascot{" +
                "name='" + name + '\'' +
                ", specie='" + specie + '\'' +
                ", status='" + status + '\'' +
                ", placeOfOrigin='" + placeOfOrigin + '\'' +
                ", age=" + age +
                ", cageId=" + cageId +
                ", tagId=" + tagId +
                '}';
    }

    public static Builder builder() {
        return new Builder(new Mascot());
    }

    public static class Builder {
        private final Mascot mascot;

        public  Builder(Mascot mascot) {
            this.mascot = mascot;
        }

        public Builder name(String name) {
            mascot.name = name;
            return this;
        }

        public Builder specie(String specie) {
            mascot.specie = specie;
            return this;
        }

        public Builder status(String status) {
            mascot.status = status;
            return this;
        }

        public Builder placeOfOrigin(String placeOfOrigin) {
            mascot.placeOfOrigin = placeOfOrigin;
            return this;
        }

        public Builder age(int age) {
            mascot.age = age;
            return this;
        }

        public Builder cageId(int cageId) {
            mascot.cageId = cageId;
            return this;
        }

        public Builder tagId(int tagId) {
            mascot.tagId = tagId;
            return this;
        }

        public Mascot build() {
            return mascot;
        }
    }
}
