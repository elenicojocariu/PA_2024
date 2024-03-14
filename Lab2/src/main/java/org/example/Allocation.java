package org.example;

import java.util.List;

/**
 * Represents an allocation of clients to a vehicle.
 * An allocation contains a list of clients assigned to a specific vehicle.
 */
public class Allocation extends Vehicle{

    private List<Client> assignedClients;
    /**
     * Constructs a new allocation with the given name and list of assigned clients.
     *
     * @param name the name of the vehicle associated with this allocation
     * @param assignedClients the list of clients assigned to the vehicle
     */
    public Allocation(String name, List<Client> assignedClients) {
        super(name);
        this.assignedClients=assignedClients;
    }

    /**
     * Retrieves the list of clients assigned to the vehicle.
     *
     * @return the list of clients assigned to the vehicle
     */
    public List<Client> getAssignedClients() {
        return assignedClients;
    }
    /**
     * Adds a client to the list of assigned clients.
     *
     * @param client the client to be added to the list of assigned clients
     */
    public void addClient(Client client){

        assignedClients.add(client);
    }
    /**
     * Checks if the allocation is full, i.e., if there are no more clients to be assigned.
     *
     * @return true if the allocation is full; false otherwise
     */
    public boolean isFull(){

        return getAssignedClients().isEmpty();
    }
}
