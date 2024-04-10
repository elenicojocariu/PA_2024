package org.example;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportCommand implements Command {
    private final DocumentRepo repository;
    public ReportCommand(DocumentRepo repository){
        this.repository= repository;
    }


    @Override
    public void execute(DocumentRepo repo) throws IOException {
        Map<String, List<Document>> documents = repo.getDocuments();

        try (FileWriter writer = new FileWriter("report.html")) {
            writer.write("<html><head><title>Repository Report</title></head><body>");
            for (Map.Entry<String, List<Document>> entry : documents.entrySet()) {
                String personId = entry.getKey();
                List<Document> personDocuments = entry.getValue();
                writer.write("<h2>Employee: " + personId + "</h2>");
                writer.write("<ul>");
                for (Document doc : personDocuments) {
                    writer.write("<li>" + doc.fileName() + "." + doc.format() + "</li>");
                }
                writer.write("</ul>");
            }
            writer.write("</body></html>");
        }
        Desktop.getDesktop().open(new File("report.html"));
    }
}
