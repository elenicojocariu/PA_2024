package org.example;
import java.io.File;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class DocumentRepo {
    private String masterDirectory;

    private Map<String, List<Document>> documents = new HashMap<>();

    private final Map<Integer, Person> employees; //angajatii so documentele asociate

    public DocumentRepo(String masterDirectory, Map<Integer, Person> employees) {

        this.masterDirectory = masterDirectory;
        this.employees = new HashMap<>();
        loadDocuments();
    }

    private void loadDocuments(){
        //read all subdirectories
        //real all files
        File directory = new File(masterDirectory);
        File[] subdirectories = directory.listFiles(File::isDirectory);

        if(subdirectories != null){
            //parcurg fiecare subdir si adaug documentele asociate in documents Map
            for(File subdir : subdirectories){
                String personId = subdir.getName();
                Person person = new Person(personId, "John");
                List<Document> personDocuments = new ArrayList<>();

                //citesc fisierele din subdir
                File[] files = subdir.listFiles();
                if(files != null){
                    //adaug fiecare fisier ca document asoc persoanei
                    Arrays.stream(files)
                            .filter(File::isFile)
                            .forEach(file -> {
                                String fileName = file.getName();
                                String[] parts = fileName.split("\\."); //split la extensia fisierului
                                String format = parts.length > 1? parts[parts.length -1] :"Unknown";
                                personDocuments.add(new Document(fileName,format,""));
                            });
                }
                //add persoana si documentele asoc in documents Map
                documents.put(personId, personDocuments);
            }
        }

    }
    public void displayRepositoryContent(){
        if (documents == null || documents.isEmpty()) {
            System.out.println("No documents in the repository.");
            return;
        }
        for (Map.Entry<String, List<Document>> entry: documents.entrySet()){
            String personId = entry.getKey();
            List<Document> personDocuments = entry.getValue();

            if (personId == null || personDocuments == null || personDocuments.isEmpty()) {
                System.out.println("Invalid entry in the repository.");
                continue;
            }


            System.out.println("Employee: " + personId);
            System.out.println("Documents: ");
            for (Document doc : personDocuments) {
                if (doc == null) {
                    System.out.println("Invalid document entry.");
                    continue;
                }
                System.out.println(doc.fileName() + "." + doc.format());
            }
            System.out.println();
        }
    }
    public Document findDocument(int employeeId, String documentName) {
        List<Document> employeeDocuments = documents.getOrDefault(employeeId, new ArrayList<>());

        // Parcurgem lista de documente și căutăm documentul cu numele specificat
        for (Document doc : employeeDocuments) {
            // Verificăm dacă numele documentului se potrivește cu documentName
            if (doc.fileName().equals(documentName)) { // Utilizăm metoda corespunzătoare din clasa Document
                return doc; // Returnăm documentul găsit
            }
        }
        return null;
    }
    public Map<String, List<Document>> getDocuments() {
        return documents;
    }


}
