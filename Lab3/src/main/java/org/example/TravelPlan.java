package org.example;

import java.time.LocalDate;
import java.util.Map;

public class TravelPlan {

    private Map<Attraction, LocalDate> plan;

    public TravelPlan(Map<Attraction, LocalDate> plan) {
        this.plan = plan;
    }
    public void addAttraction(Attraction attraction, LocalDate visitDay){
        plan.put(attraction, visitDay);
    }
    public void printTravelPlan() {
        System.out.println("Travel Plan:");
        for (Map.Entry<Attraction, LocalDate> entry : plan.entrySet()) {
            Attraction attraction = entry.getKey();
            LocalDate visitDay = entry.getValue();
            System.out.println("- " + attraction.getName() + ": " + visitDay);
        }
    }

}
