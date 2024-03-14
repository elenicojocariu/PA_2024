package org.example;
/**
 * Represents a drone vehicle used for transportation.
 * A drone is a type of vehicle capable of aerial transportation with a maximum flight duration.
 */
public class Drone extends Vehicle{

    private final int maxFlightDuration;
    /**
     * Constructs a new drone with the given name and maximum flight duration.
     *
     * @param name the name of the drone
     * @param maxFlightDuration the maximum flight duration of the drone
     */
    public Drone(String name, int maxFlightDuration) {
        super(name);
        this.maxFlightDuration=maxFlightDuration;
    }
    /**
     * Retrieves the maximum flight duration of the drone.
     *
     * @return the maximum flight duration of the drone
     */
    public int getMaxFlightDuration() {
        return maxFlightDuration;
    }

}
