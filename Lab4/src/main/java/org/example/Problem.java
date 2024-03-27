package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem {
    public static List<Destinatie> destinationsForDrivers(List<Persons> personsList){
        return personsList.stream()
                .filter(Persons::isDrive) //soferii
                .flatMap(person -> person.getDestinationsList().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<Destinatie, List<Persons>> destinationsAndPeople(List<Persons> personsList) {
        Map<Destinatie, List<Persons>> map = new HashMap<>();

        for(Persons person : personsList){
            for(Destinatie destinatie : person.getDestinationsList()){
                map.computeIfAbsent(destinatie, k-> new ArrayList<>()).add(person);

            }
        }
        return map;
    }

    public static void greedyAlgorithm(List<Persons> personsList){
        for(Persons driver: personsList){
            if(driver.isDrive() && !driver.isTaken()){
                for(Persons passenger: personsList){
                    if(!passenger.isDrive() && !passenger.isTaken()){
                        for(Destinatie destinatie : passenger.getDestinationsList()){
                            if(driver.getDestinationsList().contains(destinatie)){
                                driver.setTaken(true);
                                passenger.setTaken(true);
                                System.out.println("Driver: "+ driver.getFirstName() + " "+ driver.getLastName() + " "+ "picks up: "+ passenger.getFirstName()+ " "+ passenger.getLastName() + " to destination " + destinatie.getAddress());
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

}
