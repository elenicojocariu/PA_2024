package org.example;

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
}
