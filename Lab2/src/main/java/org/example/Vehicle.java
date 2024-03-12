package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehicle {

    private String name;
    private Depot depot;
    private List<Client> clients;

    public Vehicle(String name) {
        this.name = name;
        this.clients= new ArrayList<>(); //???
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", depot=" + depot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(name, vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }
/*
    public void addClient(Client client) {
        //vf daca clientul exista in lista
        if(!clients.contains(client)){
            clients.add(client);
            client.setV
        }

    } */
//Indicatii lab:
    //fara setter depo si schimbarile prin intermediul clasei depo
    //unidirectional -> mai putine info
    //bidirectional -> in exemplu
}
//va deveni clasa abstracta