import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistAO {
   private Connection connection;
   public ArtistAO(){
       connection = Database.getInstance().getConnection();
   }

   public void addArtist(String name){
       String query = "INSERT INTO authors (name) VALUES (?)";
       try(PreparedStatement statement = connection.prepareStatement(query)) {
           statement.setString(1,name);
           statement.executeUpdate();
       } catch(SQLException e){
           e.printStackTrace();
       }
   }

   public List<String> getAllArtists(){
       List<String> authors = new ArrayList<>();
       String query = "SELECT name FROM authors";
       try(Statement statement = connection.createStatement();
           ResultSet rs = statement.executeQuery(query)){
           while (rs.next()){
               authors.add(rs.getString("name"));
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
       return authors;
   }

   public void deleteArtist(int id){
       String query = "DELETE FROM authors WHERE id= ?";
       try(PreparedStatement statement = connection.prepareStatement(query)){
           statement.setInt(1,id);
           statement.executeUpdate();
       }catch(SQLException e){
           e.printStackTrace();
       }
   }

   public void updateArtist(int id, String name){
       String query = "UPDATE authors SET name = ? WHERE id= ?";
       try(PreparedStatement statement = connection.prepareStatement(query)){
           statement.setString(1,name);
           statement.setInt(2,id);
           statement.executeUpdate();
       }catch(SQLException e){
           e.printStackTrace();
       }
   }


}
