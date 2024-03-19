package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPlan {

    private Map<Attraction, LocalDate> plan;

    public TravelPlan() {
        this.plan = new HashMap<>();
    }
    public void addAttraction(Attraction attraction, LocalDate visitDay){

        plan.put(attraction, visitDay);
    }
    public void generateTravelPlan(LocalDate startDate, LocalDate endDate, List<Attraction> attractions){
        LocalDate currentDate = startDate;
        while (currentDate.isBefore(endDate) || currentDate.isEqual(endDate)){
            for(Attraction attraction: attractions){
                if(attraction instanceof Visitable){
                    Visitable visitable = (Visitable) attraction;
                    if(visitable.getTimetable().containsKey(currentDate.getDayOfWeek())){
                        addAttraction(attraction, currentDate);
                    }
                }
            }
            currentDate = currentDate.plusDays(1);
        }
    }
    public void printTravelPlan() {
        System.out.println("Travel Plan:");
        for (Map.Entry<Attraction, LocalDate> entry : plan.entrySet()) {
            Attraction attraction = entry.getKey();
            LocalDate visitDay = entry.getValue();
            if (attraction instanceof Visitable) {

                LocalTime openingHour = ((Visitable) attraction).getOpeningHour(visitDay);
                if (!openingHour.equals(LocalTime.MIN))
                System.out.println("- " + attraction.getName() + ": " + visitDay + " - Opening hour: " + openingHour);
            }
            else
                System.out.println("- "+ attraction.getName() + ": " + visitDay + " - without timeinterval");

        }
    }

}
