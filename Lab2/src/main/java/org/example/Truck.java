package org.example;

/**
 * Represents a truck vehicle used for transportation.
 * A truck is a type of vehicle with a certain capacity for transporting goods.
 */
public class Truck extends Vehicle{
    private final int capacity;
    /**
     * Constructs a new truck with the given name and capacity.
     *
     * @param name the name of the truck
     * @param capacity the capacity of the truck for transporting goods
     */
    public Truck(String name, int capacity) {
        super(name);
        this.capacity=capacity;
    }
    /**
     * Retrieves the capacity of the truck for transporting goods.
     *
     * @return the capacity of the truck for transporting goods
     */
    public int getCapacity() {
        return capacity;
    }

}
