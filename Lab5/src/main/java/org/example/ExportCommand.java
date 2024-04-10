package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class ExportCommand implements Command{

    private final String path;
    private final RepositoryService service;

    public ExportCommand(String path, RepositoryService service) {
        this.path = path;
        this.service = service;
    }
    @Override
    public void execute(DocumentRepo repo) throws JsonProcessingException, IOException {
        service.export(repo, path);
        System.out.println("Repository exported to: " + path);
    }
}
