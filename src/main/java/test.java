import Metier.ServiceMetier;
import Metier.User;

public class test {
    public static void main(String[] args) throws Exception {
        ServiceMetier service = new ServiceMetier();

        try {
//            User user = new User("hamza", "hamza123@gmail.com", "123", true);
            User user2 = new User("akram", "akram@gmail.com", "1234", true);
            service.addUser(user2);


        } catch (Exception e) {
            e.printStackTrace();
        }

        for (User user : service.getUsers()) {
            System.out.println(user);
        }

    }
}
