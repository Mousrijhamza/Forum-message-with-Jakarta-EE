package Metier;

import java.sql.SQLException;
import java.util.ArrayList;
import Dao.ServiceDao;

public class ServiceMetier {

    public static ArrayList<User> getUsers() throws Exception {
        return (ArrayList<User>) ServiceDao.getAllUser();}
    public static ArrayList<Message> getMessages() throws Exception {
        return (ArrayList<Message>) ServiceDao.getAllMessage();}

    //Methodes metiers
    public static User getUserByEmail(String email) throws Exception {
        for(User user:getUsers()) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }
    public static User getUser(String email, String motPasse) throws Exception {
        for(User user:getUsers()) {
            if (user.getEmail().equals(email) &&
                    user.getPassWord().equals(motPasse)	) {
                return user;}
        }

        return null;
    }
    public static void addUser(User user )
            throws SQLException{ServiceDao.addUserDao(user);
    }
    public static void addMessage(Message message )
            throws SQLException{
        ServiceDao.addMessageDao(message);
    }

    public static ArrayList<Message> getMessagesByUser (User user) throws Exception{
        if (user.estProf()) return getMessages();
        ArrayList<Message> mes= new ArrayList<Message>();
        for (Message m: getMessages()) {
            if (m.getUser().equals(user))
                mes.add(m);
        }

        return mes;
    }


}