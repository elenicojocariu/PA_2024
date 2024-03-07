package org.example;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Client c1 = new Client("Client 3", LocalTime.NOON, LocalTime.MIDNIGHT);
        c1.setName("Client 1");
        c1.setMinTime(LocalTime.of(8, 0));
        c1.setMaxTime(LocalTime.of(12,30));
        System.out.println(c1.getName());

        Client c2 = new Client("Client 3", LocalTime.NOON, LocalTime.MIDNIGHT);
        c2.setName("Client 2");
        System.out.println(c2);

        Client c3 = new Client("Client 3", LocalTime.NOON, LocalTime.MIDNIGHT);
        System.out.println(c3);

        //ClientType c4 =

        //Depot d1 = new Depot("Depot 1");
        //d1.setVehicles(v1,v2);

    }
}