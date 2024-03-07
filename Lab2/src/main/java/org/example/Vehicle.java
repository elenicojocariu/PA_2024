package org.example;
//
public class Vehicle {

    private String name;
    private Depot depot;

    public Vehicle(String name) {
        this.name = name;
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
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof Vehicle)){
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }


    //Indicatii lab:
    //fara setter depo si schimbarile prin intermediul clasei depo
    //unidirectional -> mai putine info
    //bidirectional -> in exemplu
}
//va deveni clasa abstracta