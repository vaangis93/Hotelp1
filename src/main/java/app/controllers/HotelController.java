package app.controllers;

import app.config.HibernateConfig;
import app.daos.HotelDAO;
import app.dtos.HotelDTO;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HotelController {

    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("hotels");
    HotelDAO hotelDAO = HotelDAO.getInstance(emf);

    // logging class variables
    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
    private static final Logger debugLogger = LoggerFactory.getLogger("app");


    public void getAllHotels(Context ctx) {
//        logger.info("GET/ hotels");
        List<HotelDTO> hotelDTOList = hotelDAO.getAll();
        ctx.status(HttpStatus.OK);
        ctx.json(hotelDTOList);// returning the DTO to the client

    }

    public void createHotel(Context ctx) {

//        logger.info("POST / hotels");
        HotelDTO hotelDTO = ctx.bodyAsClass(HotelDTO.class);
        HotelDTO newHotelDTO = hotelDAO.createHotelDTO(hotelDTO);
        ctx.json(newHotelDTO);
        ctx.status(HttpStatus.CREATED);

    }

    public void findById(Context ctx) {
//        logger.info("GET/ hotels");
        String s= ctx.pathParam("id");
        HotelDTO hotelDTO = hotelDAO.GetById(Integer.parseInt(s));
        ctx.json(hotelDTO);
        ctx.status(HttpStatus.OK);
    }




}// end class
