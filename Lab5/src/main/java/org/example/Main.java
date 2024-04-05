package org.example;

import javax.print.Doc;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String masterDirectory = "path_to_master_directory"; // Replace this with the actual path
        DocumentRepo repository = new DocumentRepo(masterDirectory);
        RepositoryService repositoryService = new RepositoryService();

        try {
            // Export repository to JSON file
            repositoryService.export(repository, "repository.json");

            // Read repository from JSON file
            DocumentRepo readRepo = repositoryService.read("repository.json");
            readRepo.displayContent();
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