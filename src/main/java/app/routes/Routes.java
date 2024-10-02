package app.routes;

import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.path;

public class Routes {

HotelRoutes hotelRoutes = new HotelRoutes();

    public EndpointGroup routes() {
        return () -> {

            path ("/hotels", hotelRoutes.getHotelRoutes() );

        };

    }
}
