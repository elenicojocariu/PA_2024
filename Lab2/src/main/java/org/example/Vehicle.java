package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a vehicle used for transportation.
 * This is an abstract class defining common attributes and behavior for vehicles.
 */

public abstract class Vehicle {

    private String name;
    private Depot depot;

    /**
     * Constructs a new vehicle with the given name.
     *
     * @param name the name of the vehicle
     */
    public Vehicle(String name) {
        this.name = name;
    }
    /**
     * Retrieves the name of the vehicle.
     *
     * @return the name of the vehicle
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the vehicle.
     *
     * @param name the new name of the vehicle
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the vehicle.
     *
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", depot=" + depot +
                '}';
    }
    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return true if this object is the same as the o argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(name, vehicle.name);
    }
    /**
     * Returns a hash code value for the vehicle.
     *
     * @return a hash code value for the vehicle
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Sets the depot where the vehicle is stationed.
     * Note: This method should only be used in bidirectional relationships.
     *
     * @param depot the depot where the vehicle is stationed
     */
    public void setDepot(Depot depot) {
        this.depot = depot;
    }
}
//Indicatii lab:
    //fara setter depo si schimbarile prin intermediul clasei depo
    //unidirectional -> mai putine info
    //bidirectional -> in exemplu

//va deveni clasa abstracta