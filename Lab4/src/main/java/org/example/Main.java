package org.example;

import com.github.javafaker.Faker;

import java.sql.Struct;
import java.util.*;

public class Main {
    public static  void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();
        List<Persons> personsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            boolean isDriver = random.nextBoolean();
            int minVarsta = 18;
            int maxVarsta = 75;
            int age = random.nextInt(maxVarsta- minVarsta) +minVarsta; //de pus interval
            personsList.add(new Persons(firstName, lastName, isDriver, age));
        }
        System.out.println("List of persons: ");
        for (Persons persons : personsList) {
            System.out.println(persons);
        }
        LinkedList<Persons> sortedDriversList = Persons.getSortedDrivers(personsList);
        System.out.println("\n Lista soferi soratati dupa varsta: \n");
        for(Persons driver : sortedDriversList){
            System.out.println(driver);
        }

        Set<Persons> sortedPassengersSet = Persons.getSortedPassanger(personsList);
        System.out.println(" \n TreeSetul de pasageri sortati dupa nume: \n");
        for(Persons passenger: sortedPassengersSet){
            System.out.println(passenger);
        }


    }
}