package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        compulsory();
        homework(args);
        bonus(args);
    }

    public static void compulsory() {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        //for(int i=0; i<languages.length;i++)
        //System.out.println(languages[i]);
        Random random = new Random();
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        int nResult = n * 3;
        System.out.println("Result after multiplying by 3:" + nResult);
        nResult += 0b10101;
        System.out.println("Result after adding binary :" + nResult);
        nResult += 0xFF;
        System.out.println("Result after adding hexadecimal:" + nResult);
        nResult *= 6;
        System.out.println("Result after multiplying by 6:" + nResult);
        while (nResult > 9) {
            int sum = 0;
            while (nResult > 0) {
                sum += nResult % 10;
                nResult /= 10;
            }
            nResult = sum;
        }
        System.out.println("Sum of digits: " + nResult);
        System.out.println("Willy-nilly, this semster I will learn " + languages[nResult]);

    }

    public static void homework(String[] args) {
        long t1 = System.currentTimeMillis();
        StringBuilder numbers = new StringBuilder();
        if (args.length < 3) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        if (a > b) {
            System.out.println("Invalid interval. Reminder that a must be <= b");
            return;
        }
        for (int i = a; i <= b; i++) {
            if (isKReductible(i, k)) {
                //System.out.println("Numarul " + i+ " este "+ k + " reductibil");
                numbers.append(i).append(" ");
            }
        }
        System.out.println(numbers.toString());
        long t2 = System.currentTimeMillis();
        System.out.println("Duration: " + (t2 - t1));
    }

    private static boolean isKReductible(int number, int k) {
        int sumaPatratelor;
        int aux = number;
        while (aux > 9 && aux > k) {
            sumaPatratelor = 0;
            while (aux > 0) {
                sumaPatratelor += (aux % 10) * (aux % 10);
                aux /= 10;
            }
            //System.out.println("asta i suma patratelor " + sumaPatratelor);
            aux = sumaPatratelor;
        }
        return aux == k;
    }

    public static void bonus(String[] args) {
        int n = 7;
        int[][] adjMatrix = new int[n][n];

        for (int i = 1; i < n; i++) { //conectez hub-ul de toate nodurile
            adjMatrix[i][0] = 1;
            adjMatrix[0][i] = 1;
        }
        adjMatrix[n - 1][1] = 1; //conectez nodul 1 de nodul n
        adjMatrix[1][n - 1] = 1;

        for (int i = 1; i < n - 1; i++) { //conected nodurile din cicluri
            adjMatrix[i][i + 1] = 1;
            adjMatrix[i + 1][i] = 1;
        }

        displayMatrix(adjMatrix);
        findCycles(adjMatrix);
    }

    private static void findCycles(int[][] adjMatrix) {
        int n = adjMatrix.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                StringBuilder cycle = new StringBuilder();
                DFS(i, i, adjMatrix, visited, cycle);
                if (cycle.length() > 0) {
                    System.out.println("Cycle: " + cycle.toString());
                }
                //else System.out.println("No cycle from node "+ i);
            }
        }
    }

    private static void DFS(int start, int current, int[][] adjMatrix, int[] visited, StringBuilder cycle) {

        visited[current] = 1;
        cycle.append(current).append(" ");
        System.out.println("Now im at node: " + current);
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[current][i] == 1) {
                System.out.println("checking edge between "+ current + " and "+ i);
                if (visited[i] != 0 && cycle.toString().contains(" "+ i + " ")){
                    System.out.println("Node at position "+ i + " is already visited");
                    DFS(start, i, adjMatrix, visited, cycle);}
                else if (i == start && cycle.length() > 2) { // verific ca nu i o simpla muchie conexiunea
                    cycle.append(current);
                    System.out.println("cycle is: "+ cycle.toString());
                }
            }
        }
    }

    private static void displayMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }



}