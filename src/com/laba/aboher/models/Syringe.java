package com.laba.aboher.models;

public class Syringe {

    private boolean loaded;

    public  Syringe() {
        loaded = true;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
}
