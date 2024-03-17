package org.example;

public class Statue extends Attraction {

    public Statue(String name, String description) {
        super(name, description);
    }

    @Override
    public int compareTo(Attraction o) {
        return 0;
    }
}
