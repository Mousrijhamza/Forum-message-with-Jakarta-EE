package Dao;
import java.sql.*;

public class Connexion {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/bdforum2023","root", "root" );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) { e.printStackTrace();	}
    }
    public static Connection getConnection() {
        return connection;
    }
}