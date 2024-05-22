import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ArtistAO authorDAO = new ArtistAO();

        //add authors
        authorDAO.addArtist("Dostoievski");
        authorDAO.addArtist("Dona Tartt");

        //display auth
        System.out.println("Authors: ");
        for(String author: authorDAO.getAllArtists()){
            System.out.println(author);
        }

        //update auth
        authorDAO.updateArtist(1, "Lev Tolstoi");
        //display after update
        System.out.println("\n Authors after updates: ");
        for(String author: authorDAO.getAllArtists()){
            System.out.println(author);
        }

        //delete auth
        authorDAO.deleteArtist(2);
        //display auth after delete
        System.out.println("\n Authors after delete: ");
        for(String author: authorDAO.getAllArtists()){
            System.out.println(author);
        }
    }
}

