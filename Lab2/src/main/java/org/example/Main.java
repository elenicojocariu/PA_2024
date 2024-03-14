package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        List<Client> clientList = new ArrayList<>();
        Client client1 = new Client("client1", LocalTime.of(8, 0), LocalTime.of(10, 0), ClientType.REGULAR);
        Client client2 = new Client("Client2", LocalTime.of(9,30), LocalTime.of(11,0), ClientType.PREMIUM);
        clientList.add(client1);
        clientList.add(client2);
        System.out.println("List of clients: " + clientList);



        Depot depot1 = new Depot("Depot1");
        Depot depot2 = new Depot("Depot2");


        //Vehicle vehicle1 = new Vehicle("Vehicle1");
        //Vehicle vehicle2 = new Vehicle("Vehicle2");

        //vehicle1.setDepot(depot1); //depozitul pt vehicule
        //vehicle2.setDepot(depot1);

        //depot1.setVehicles(vehicle1, vehicle2); //vehiculele la depozite



        Truck truck1 = new Truck("Truck1", 10);
        truck1.setName("Truck1");


        Drone drone1 = new Drone("Drone1", 20);
        drone1.setName("Drone1");


        Drone drone2 = new Drone("Drone2", 15);
        drone2.setName("Drone2");

        depot1.getVehicles().add(drone1);
        depot1.getVehicles().add(truck1);
        depot2.getVehicles().add(drone2);

        drone1.setDepot(depot1);
        truck1.setDepot(depot1);
        drone2.setDepot(depot2);
        System.out.println("Informatii vehicule-depozite" + drone1);
        System.out.println("Informatii vehicule-depozite" + truck1);
        System.out.println("Informatii vehicule-depozite" + drone2);
        System.out.println(depot1);
        System.out.println(depot2);
        System.out.println("testare metoda equals: " + depot1.equals(depot2)); //ret false

        Depot[] depotsArray = new Depot[]{depot1
        };

        Problem problem = new Problem(clientList);
        problem.setDepots(depotsArray);
        Solution solution = new Solution(problem, new ArrayList<>());
        solution.solve();

        List<Allocation> allocations = solution.getAllocation();
        for (Allocation allocation: allocations){
            System.out.println("Vehicle: "+ allocation.getName());
            List<Client> assignedClients = allocation.getAssignedClients();
            for(Client client: assignedClients){
                System.out.println(" Assigned client: "+ client.getName());
            }
            System.out.println();
        }



}
}