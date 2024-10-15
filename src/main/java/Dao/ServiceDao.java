package Dao;

import java.sql.*;
import java.util.ArrayList;
import Metier.*;

public class ServiceDao {
    private static  Connection connection = Connexion.getConnection();

    public static ArrayList<User> getAllUser( ) throws SQLException {
        ArrayList<User> users= new ArrayList<User>();

        ResultSet rs = connection.createStatement().executeQuery
                ("Select * from user");

        while (rs.next()) {

            User user= new User();
            user.setEmail(rs.getString("email"));
            user.setNomPr(rs.getString("nomPr"));
            user.setPassWord(rs.getString("password"));
            user.setStatut( rs.getBoolean("statut"));

            users.add(user);
        }
        rs.close();
        return users;
    }
    public static void addUserDao(User user ) throws SQLException {
        PreparedStatement ps= connection.prepareStatement(
                "insert into user values(?,?,?,?) ");
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getNomPr());
        ps.setString(3, user.getPassWord());
        ps.setBoolean(4, user.getStatut());

        ps.executeUpdate();

    }
    public static ArrayList<Message> getAllMessage( ) throws Exception {
        ArrayList<Message> messages= new ArrayList<Message>();

        ResultSet rs = connection.createStatement().executeQuery(
                "SELECT * FROM message");
        while (rs.next()) {
            messages.add(
                    new Message(
                            ServiceMetier.getUserByEmail( rs.getString("emailUser") ),
                            rs.getString("txtMessage"),
                            rs.getDate("dtMessage") )
            );
        }
        rs.close();
        return messages;
    }
    public static void addMessageDao(Message message ) throws SQLException {
        PreparedStatement ps=connection.prepareStatement(
                "INSERT INTO message (txtMessage, dtMessage, emailUser)"
                        + " VALUES (?,?,?)");

        ps.setString(1, message.getMessage());
        ps.setDate(2, message.getDate2());
        ps.setString(3, message.getUser().getEmail());
        ps.executeUpdate();

    }
}

    