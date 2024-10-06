package app;

import app.config.ApplicationConfig;
import app.config.HibernateConfig;
import app.daos.HotelDAO;
import app.daos.RoomDAO;
import app.security.daos.UserDAO;
import app.security.entities.Role;
import app.security.entities.User;
import io.javalin.Javalin;
import jakarta.persistence.EntityManagerFactory;

public class Main {


    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig(false);
//        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig(false);
        HotelDAO hotelDAO = HotelDAO.getInstance(emf);
        RoomDAO roomDAO = RoomDAO.getInstance(emf);
        UserDAO userDAO = UserDAO.getInstance(emf);



        Javalin app = Javalin
                // instanziere vores configorations class
                // med vores configurations i. når vi kører Javalin projektet
                .create(ApplicationConfig::configuration)
                .start(7070);


        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        User user3 = new User("user3", "password3");

        Role role1 = new Role("User");
        Role role2 = new Role("Admin");

        user1.addRole(role1);
        user2.addRole(role2);
        user3.addRole(role1);

        userDAO.createExistingRole(role1);
        userDAO.createExistingRole(role2);

        userDAO.createExistingUser(user1);
        userDAO.createExistingUser(user2);
        userDAO.createExistingUser(user3);


//        // get room by id --- works
//        roomDAO.GetById(1);

//        // get all hotels --- works
//        hotelDAO.getAll();

//        // get all room from one hotel by Id --- works
//        hotelDAO.getAllTheRoomsForAHotel(1);


//        // creating objects of Hotels and Rooms for testing
//        Hotels hotel1 = new Hotels("hotel1", "adress1");
//        Rooms room1 = new Rooms(hotel1, 55, 10000);
//        Rooms room2 = new Rooms(hotel1, 34, 5000);
//        Rooms room3 = new Rooms(hotel1, 12, 2000);
//        // testing create method on hotels and rooms
//        hotelDAO.create(hotel1);
//        roomDAO.create(room1);
//        roomDAO.create(room2);
//        roomDAO.create(room3);



    }// end main
}// end class

