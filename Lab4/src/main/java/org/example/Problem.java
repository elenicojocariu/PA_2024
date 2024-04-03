package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;



public class Problem {
    public static List<Destinatie> destinationsForDrivers(List<Persons> personsList) {
        return personsList.stream()
                .filter(Persons::isDrive) //soferii
                .flatMap(person -> person.getDestinationsList().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<Destinatie, List<Persons>> destinationsAndPeople(List<Persons> personsList) {
        Map<Destinatie, List<Persons>> map = new HashMap<>();

        for (Persons person : personsList) {
            for (Destinatie destinatie : person.getDestinationsList()) {
                map.computeIfAbsent(destinatie, k -> new ArrayList<>()).add(person); //met

            }
        }
        return map;
    }

    public static void greedyAlgorithm(List<Persons> personsList) {
        List<Persons> passangerCopy = new ArrayList<>(personsList);

        for (Persons driver : personsList) {
            if (driver.isDrive() && !driver.isTaken()) {
                for (Persons passenger : passangerCopy) {
                    if (!passenger.isDrive() && !passenger.isTaken()) {
                        boolean passengerTaken = false;

                        for (Destinatie destinatie : passenger.getDestinationsList()) {
                            if (driver.getDestinationsList().contains(destinatie)) {
                                if (!passengerTaken) {
                                    driver.setTaken(true);
                                    passenger.setTaken(true);
                                    passengerTaken = true;
                                    System.out.println("Driver: " + driver.getFirstName() + " " + driver.getLastName() + " " + "picks up: " + passenger.getFirstName() + " " + passenger.getLastName() + " to destination " + destinatie.getAddress());
                                    //break;
                                }
                            }
                        }
                    }
                }
                driver.setTaken(false);
            }
        }

    }

    public static Graph<Persons, DefaultEdge> solveProblem(List<Persons> personsList) {
        //creez graf neorientat
        Graph<Persons, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        // soferi si pasageri = noduri
        for (Persons person : personsList) {
            graph.addVertex(person);
        }
        //muchii intre soferi si pasageri cu destinatie comuna
        for (Persons driver : personsList) {
            if (driver.isDrive()) {
                for (Persons passenger : personsList) {
                    if (!passenger.isDrive()) {
                        for (Destinatie destination : passenger.getDestinationsList()) {
                            if (driver.getDestinationsList().contains(destination)) {
                                graph.addEdge(driver, passenger);
                                break;
                            }
                        }
                    }
                }
            }
        }
        //visualizeGraph(graph);
        return graph;
    }

    public static void visualizeGraph(Graph<Persons, DefaultEdge> graph) {
        EventQueue.invokeLater(() -> {
            Frame frame = new Frame("Graph Visualization");
            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.add(new GraphPanel(graph));
        });
    }

    private static class GraphPanel extends Panel {
        private Graph<Persons, DefaultEdge> graph;

        public GraphPanel(Graph<Persons, DefaultEdge> graph) {
            this.graph = graph;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            int xSofer = 50;
            int xPasager = 700;
            int y = 50; // Coordonata y initiala pentru ambele categorii de noduri
            int gap = 50;


            // Desenare noduri
            for (Persons person : graph.vertexSet()) {
                int x, yCurrent;
                if (person.isDrive()) {
                    x = xSofer;
                    yCurrent = y;
                    y += gap; // crestem coordonata y pentru urm nod sofer
                } else {
                    x = xPasager;
                    yCurrent = y;
                    y += gap; // crestem coordonata y pentru urm nod pasager
                }
                g.setColor(Color.BLUE);
                g.fillOval(x, yCurrent, 30, 30); // nod
                g.setColor(Color.BLACK);
                g.drawString(person.getFirstName(), x + 5, yCurrent + 15); // etichete cu numele persoanei

            }


        }
    }
}








