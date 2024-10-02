package app.controllers;

import app.config.HibernateConfig;
import app.daos.HotelDAO;
import app.daos.RoomDAO;
import app.dtos.RoomDTO;
import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RoomController {

    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("hotels");
    RoomDAO roomDAO = RoomDAO.getInstance(emf);

    // logging class variables
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
    private static final Logger debugLogger = LoggerFactory.getLogger("app");

//    public void getRooms(Context ctx) {
//        List<RoomDTO> roomDTOList = roomDAO.getRooms();
//        ctx.status(200);
//        ctx.json(roomDTOList);
//    }



}
