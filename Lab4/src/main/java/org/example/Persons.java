package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Persons {

    private String firstName;
    private String lastName;
    private boolean isDrive;
    private int age;
    public Persons(String firstName, String lastName, boolean isDrive, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDrive = isDrive;
        this.age=age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isDrive() {
        return isDrive;
    }

    public void setDrive(boolean drive) {
        isDrive = drive;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isDrive=" + isDrive +
                ", age=" + age +
                '}';
    }
    public static LinkedList<Persons> getSortedDrivers(List<Persons> personsList){
        List<Persons> driversList = personsList.stream()
                .filter(Persons::isDrive)
                .sorted(Comparator.comparingInt(Persons::getAge))
                .collect(Collectors.toList());
        LinkedList<Persons> linkedList = new LinkedList<>(driversList);
        return linkedList;
    }
    public static Set<Persons> getSortedPassanger(List<Persons> personsList){
        List<Persons> passangersList = personsList.stream()
                .filter(person -> !person.isDrive)
                .collect(Collectors.toList());
        TreeSet<Persons> passangersTreeSet = new TreeSet<>(Comparator.comparing(Persons::getFirstName).thenComparing(Persons::getLastName));
        passangersTreeSet.addAll(passangersList);
        return passangersTreeSet;
    }



}
