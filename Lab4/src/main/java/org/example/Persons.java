package org.example;

public class Persons {

    private String firstName;
    private String lastName;
    private boolean isDrive;

    public Persons(String firstName, String lastName, boolean isDrive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDrive = isDrive;
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

    @Override
    public String toString() {
        return "Persons{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isDrive=" + isDrive +
                '}';
    }
}
