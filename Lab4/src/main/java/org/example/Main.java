package org.example;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static  void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();
        List<Persons> personsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            boolean isDriver = random.nextBoolean();
            personsList.add(new Persons(firstName, lastName, isDriver));
        }
        System.out.println("List of persons: ");
        for (Persons persons : personsList) {
            System.out.println(persons);
        }


    }
}