package org.example;

import java.io.IOException;
import java.lang.module.Configuration;

public class Main {
    public static void main(String[] args) throws IOException{
        String masterDirectory = "C:\\Users\\eleni\\OneDrive\\Desktop\\MasterDirectory";
        DocumentRepo repository = new DocumentRepo(masterDirectory);
        RepositoryService repositoryService = new RepositoryService();

        try {
            // Export repository to JSON file
            repositoryService.export(repository, "repository.json");

            // Read repository from JSON file
            DocumentRepo readRepo = repositoryService.read("repository.json");
            readRepo.displayRepositoryContent();
        } catch (IOException | InvalidRepositoryException e) {
            e.printStackTrace();
        }
    }



}
//Sugestii lab:
//clase:
//doc=are locatie, ce tip are docuuentul, proprietarul
//pers
//records sunt immutable
//clasa repo service cu metode de printat, afisat, etc