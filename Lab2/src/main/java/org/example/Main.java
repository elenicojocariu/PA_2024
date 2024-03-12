package org.example;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Client();
        client1.setName("Client 1");
        client1.setMinTime(LocalTime.of(8, 0));
        client1.setMaxTime(LocalTime.of(12,30));
        client1.setType(ClientType.PREMIUM);

        Client client2 = new Client();
        client2.setName("Client2");
        client2.setMinTime(LocalTime.of(4,30));
        client2.setMaxTime(LocalTime.of(11,0));
        client2.setType(ClientType.REGULAR);

        Depot depot1 = new Depot("Depot1");

        Vehicle vehicle1 = new Vehicle("Vehicle1");
        Vehicle vehicle2 = new Vehicle("Vehicle2");

        vehicle1.setDepot(depot1); //depozitul pt vehicule
        vehicle2.setDepot(depot1);

        depot1.setVehicles(vehicle1, vehicle2); //vehiculele la depozite

        System.out.println(depot1);
        System.out.println(vehicle1);
        System.out.println(vehicle2);
        System.out.println(client1);
        System.out.println(client2);
    }
}