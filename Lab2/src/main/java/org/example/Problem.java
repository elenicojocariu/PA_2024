package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a problem instance involving clients and depots.
 * A problem consists of a set of clients to be visited and a set of depots from which vehicles operate.
 */
public class Problem {
    private Depot[] depots;

    private List<Client> clients;

    /**
     * Retrieves the vehicles available for operations.
     *
     * @return an array of vehicles available for operations
     */
    public Vehicle[] getVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();

        for (Depot depot : depots) {
            if (depot.getVehicles() != null) {
                for (Vehicle vehicle : depot.getVehicles())
                    allVehicles.add(vehicle);
            }
        }
        return allVehicles.toArray(allVehicles.toArray(new Vehicle[0])); //convertesc din lista in array
    }

    /**
     * Constructs a new problem instance with the given list of clients.
     *
     * @param clients the list of clients to be visited
     */
    public Problem(List<Client> clients) {
        this.clients = clients;
        this.depots = new Depot[0];
    }
    /**
     * Retrieves the list of clients to be visited.
     *
     * @return the list of clients to be visited
     */
    public List<Client> getClients() {
        return clients;
    }
    public void setDepots(Depot[] depots) {
        this.depots = depots;
    }


}
