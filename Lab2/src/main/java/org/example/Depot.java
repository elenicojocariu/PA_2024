package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents a depot where vehicles are stationed.
 *  A depot has a name and can store a list of vehicles
 */
public class Depot {

    private String name;
    private List<Vehicle> vehicles;

    /**
     * Constructs a new depot with the given name.
     * Initializes the list of vehicles to an empty ArrayList.
     *
     * @param name the name of the depot
     */
    public Depot(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    /**
     * Retrieves the name of the depot.
     *
     * @return the name of the depot
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the depot.
     *
     * @param name the new name for the depot
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Retrieves the list of vehicles from depot.
     *
     * @return the list of vehicles from depot
     */

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    /**
     * Sets the list of vehicles  at the depot.
     *
     * @param vehicles the new list of vehicles  at the depot
     */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


   /* @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    } */

    /**
     * Returns a string representation of the depot.
     * The string includes the depot's name and a list of vehicles stationed at the depot.
     *
     * @return a string representation of the depot
     */
   @Override
   public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("Depot{name='").append(name).append("', vehicles=[");

       for (int i = 0; i < vehicles.size(); i++) {
           stringBuilder.append(vehicles.get(i).getName());
           if (i < vehicles.size() - 1) {
               stringBuilder.append(", ");
           }
       }

       stringBuilder.append("]}");
       return stringBuilder.toString();
   }
    /**
     * Indicates whether some other object is "equal to" this one.
     * This method checks if the specified object is also a Depot object,
     * and if so, whether it has the same name and list of vehicles as this Depot object.
     *
     * @param o the reference object with which to compare
     * @return true if this object is the same as the o argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name) && Objects.equals(vehicles, depot.vehicles);
    }

    //bidirectioanal


    @Override
    public int hashCode() {
        return Objects.hash(name, vehicles);
    }


}


