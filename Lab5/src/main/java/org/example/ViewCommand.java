package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {

    private final String documentName;

    public ViewCommand(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public void execute(DocumentRepo repo) throws IOException {
        Document document = repo.findDocument(1, documentName);
        if(document != null){
            Desktop.getDesktop().open(new File(document.path()));
        }
        else{
            System.out.println("Document not found");
        }
    }
}
