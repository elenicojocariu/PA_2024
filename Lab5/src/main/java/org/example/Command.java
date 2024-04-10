package org.example;

public interface Command {
    void execute(DocumentRepo repo) throws  Exception;
}
