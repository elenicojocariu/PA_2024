import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/book_collection";
    private static final String USER = "root"; //DB username
    private static final String PASSWORD = "STUDENT"; //replace with DB pass

    private Database(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

}
