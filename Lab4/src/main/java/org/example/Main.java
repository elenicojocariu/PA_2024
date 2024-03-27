package org.example;

import com.github.javafaker.Faker;

import java.sql.Struct;
import java.util.*;

import static org.example.Problem.destinationsForDrivers;
import static org.example.Problem.greedyAlgorithm;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();
        List<Persons> personsList = new ArrayList<>();
        List<Destinatie> destinatieList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            boolean isDriver = random.nextBoolean();
            int minVarsta = 18;
            int maxVarsta = 75;
            int age = random.nextInt(maxVarsta - minVarsta) + minVarsta; //de pus interval


            personsList.add(new Persons(firstName, lastName, isDriver, age));
        }
        System.out.println("List of persons: ");
        for (Persons persons : personsList) {
            System.out.println(persons);
        }
        LinkedList<Persons> sortedDriversList = Persons.getSortedDrivers(personsList);
        System.out.println("\n Lista soferi soratati dupa varsta: \n");
        for (Persons driver : sortedDriversList) {
            System.out.println(driver);
        }

        Set<Persons> sortedPassengersSet = Persons.getSortedPassanger(personsList);
        System.out.println(" \n TreeSetul de pasageri sortati dupa nume: \n");
        for (Persons passenger : sortedPassengersSet) {
            System.out.println(passenger);
        }

        for (int i = 0; i < 6; i++) {
            String address = faker.address().fullAddress();
            destinatieList.add(new Destinatie(address));
        }
        System.out.println("Toate destinatiile: ");
        for (Destinatie destinatie : destinatieList) {
            System.out.println(destinatie.getAddress());
        }
        System.out.println("Atriburire: \n");
        for (Persons person : personsList) {
            Random random1 = new Random();
            int randomNumber = random1.nextInt(destinatieList.size());
            //String address = faker.address().fullAddress();
            //Destinatie destinatie = new Destinatie(address);
            person.addDestination(destinatieList.get(randomNumber));
            System.out.println(person.getFirstName() + " " + person.getLastName() + " Destinatie: " + person.getDestinationsList());
        }

        List<Destinatie> destinationsForDrivers = destinationsForDrivers(personsList);
        System.out.println("\n Destinatiile soferilor: \n");
        for (Destinatie destinatie : destinationsForDrivers) {
            System.out.println(destinatie.getAddress());
        }

        Map<Destinatie, List<Persons>> destinationsAndPeople = Problem.destinationsAndPeople(personsList);
        System.out.println("\n Dictionarul cu destinatiile si personale care vor sa mearga acolo: \n ");
        for (Map.Entry<Destinatie, List<Persons>> entry : destinationsAndPeople.entrySet()) {
            Destinatie destination = entry.getKey();
            List<Persons> people = entry.getValue();
            System.out.println("Destinația: " + destination.getAddress());
            System.out.println("Persoanele care doresc să meargă acolo:");
            for (Persons person : people) {
                System.out.println("- " + person.getFirstName() + " " + person.getLastName());
            }
            System.out.println();
        }

        greedyAlgorithm(personsList);
    }
}