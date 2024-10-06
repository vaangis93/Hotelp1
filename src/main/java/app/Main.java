package app;

import app.config.ApplicationConfig;
import app.config.HibernateConfig;
import app.daos.HotelDAO;
import app.daos.RoomDAO;
import io.javalin.Javalin;
import jakarta.persistence.EntityManagerFactory;

public class Main {


    public static void main(String[] args) {

//        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig(true);
//        HotelDAO hotelDAO = HotelDAO.getInstance(emf);
//        RoomDAO roomDAO = RoomDAO.getInstance(emf);
//
//        Javalin app = Javalin
//                // instanziere vores configorations class
//                // med vores configurations i. når vi kører Javalin projektet
//                .create(ApplicationConfig::configuration)
//                .start(7070);




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

