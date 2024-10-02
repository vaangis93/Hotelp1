package app.routes;

import app.controllers.HotelController;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

public class HotelRoutes {

    HotelController hotelController = new HotelController();


    public EndpointGroup getHotelRoutes() {
        return () -> {
            get("/", hotelController::getAllHotels);
            post("/", hotelController::createHotel);
            get("/{id}", hotelController::findById);
        };

    }
}
