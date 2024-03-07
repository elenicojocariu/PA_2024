package org.example;

import java.time.LocalTime;

public class Depot {

private String name;
private Vehicle[] vehicles;

    public Depot(String name, Vehicle[] vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setVehicles(Vehicle vehicles){
        }
    }


