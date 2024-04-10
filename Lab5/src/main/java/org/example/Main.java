package org.example;

import java.io.IOException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String masterDirectory = "C:\\Users\\eleni\\OneDrive\\Desktop\\MasterDirectory";
        DocumentRepo repository = new DocumentRepo(masterDirectory, null);
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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command (view <document_name>, report, export, or exit): ");
            String commandLine = scanner.nextLine();
            String[] parts = commandLine.split(" ");

            if (parts.length < 1) {
                continue;
            }

            String command = parts[0];
            String argument;
            if (parts.length > 1) {
                argument = parts[1];
            } else {
                argument = null;
            }

            try {
                handleCommand(command, argument, repository, repositoryService);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }

            if (command.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }
        private static void handleCommand(String command, String argument, DocumentRepo repository, RepositoryService service) throws Exception {
            Command cmd;
            switch (command.toLowerCase()) {
                case "view":
                    if (argument == null) {
                        throw new IllegalArgumentException("Missing document name for view command!");
                    }
                    cmd = new ViewCommand(argument);
                    break;
                case "report":
                    cmd = new ReportCommand(repository);
                    break;
                case "export":
                    if (argument == null) {
                        throw new IllegalArgumentException("Missing export path!");
                    }
                    cmd = new ExportCommand(argument, service);
                    break;
                case "exit":
                    return;
                default:
                    throw new IllegalArgumentException("Invalid command!");
            }
            cmd.execute(repository);

        }



}
//Sugestii lab:
//clase:
//doc=are locatie, ce tip are docuuentul, proprietarul
//pers
//records sunt immutable
//clasa repo service cu metode de printat, afisat, etc