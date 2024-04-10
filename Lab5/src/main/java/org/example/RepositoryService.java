package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;

public class RepositoryService {

    public void export(DocumentRepo repo, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), repo);
    }
    public DocumentRepo read(String path) throws InvalidRepositoryException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(path), DocumentRepo.class);
        } catch (IOException ex) {
            throw new InvalidRepositoryException(ex);
        }
    }
}
