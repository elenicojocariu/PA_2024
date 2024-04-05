package org.example;

import javax.print.Doc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentRepo {
    private String masterDirectory;
    private Map<Person, List<Document>> documents = new HashMap<>();

    public DocumentRepo(String masterDirectory) {

        this.masterDirectory = masterDirectory;
        loadDocuments();
    }

    private void loadDocuments(){
        //read all subdirectories
        //real all files
    }
    public void displayContent(){
        for (Map.Entry<Person, List<Document>> entry: documents.entrySet()){
            System.out.println("Employee: " + entry.getKey().name() + ", ID: "+ entry.getKey().id());
            System.out.println("Documents: ");
            for(Document doc: entry.getValue()){
                System.out.println(doc.fileName() + "." + doc.format());
            }
            System.out.println();
        }
    }


}
