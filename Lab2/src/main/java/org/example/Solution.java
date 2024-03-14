package org.example;

import java.time.LocalTime;
import java.util.*;
/**
 * Represents a solution to the vehicle routing problem.
 */
public class Solution {

    private Problem problem;

    /**
     * Retrieves the list of allocations representing the solution.
     *
     * @return the list of allocations representing the solution
     */
    public List<Allocation> getAllocation() {
        return allocation;
    }

    private List<Allocation> allocation;

    /**
     * Constructs a new solution for the given problem instance.
     *
     * @param problem the problem instance for which the solution is generated
     * @param allocation the initial list of allocations representing the solution
     */
    public Solution(Problem problem, List<Allocation> allocation) {
        this.problem = problem;
        this.allocation = allocation;
    }
    /**
     * Solves the vehicle routing problem by allocating clients to vehicles.
     * The solution process considers client time windows.
     */
    public void solve(){
        Vehicle[] vehicles = problem.getVehicles();
        List<Client> clients = problem.getClients();

        //sortez clientii in ordinea de vizitare
        List<Client> sortedClients = new ArrayList<>(clients);
        sortedClients.sort(Comparator.comparing(Client::getMinTime));

        for (Vehicle vehicle: vehicles){
            Allocation currentAllocation = new Allocation(vehicle.getName(), new ArrayList<>());
            LocalTime currentTime = LocalTime.of(8,0);//pp ca incepe de la 8 programul

            System.out.println("heyyy: "+ vehicle.getName());

            //aloc clienti in ordinea lor de vizitare
            for (Client client: clients){
                System.out.println("sadd: "+ client.getName());
                if(!currentAllocation.isFull() && client.getMinTime().isAfter(currentTime)){
                    currentAllocation.addClient(client);
                    currentTime = client.getMaxTime();
                }
            }
            System.out.println("ajunge aici macar? "+ vehicle.getName());
            allocation.add(currentAllocation); //adaug alocarea la lista de alocari
        }

    }


}