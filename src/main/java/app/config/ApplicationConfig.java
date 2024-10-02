package app.config;

import app.routes.Routes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.HttpStatus;
import jakarta.persistence.EntityNotFoundException;

public class ApplicationConfig {


    private static Routes routes = new Routes();
    private static Javalin app;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void configuration(JavalinConfig config) {
        config.showJavalinBanner = false;// fjerner bare JAVALIN banner i terminal
        config.bundledPlugins.enableRouteOverview("/routes");// kan bruge vores website/routes || http://localhost:7070/routes
        config.router.contextPath = "/api/v1"; // base path - for at kunne ændre version i fremtiden samt stadig bruge den gamle. indtil den nye FEKS er klar
        config.router.apiBuilder(routes.routes());
    }

    public static void start() {
        app = Javalin
                // instanziere vores configorations class
                // med vores configurations i. når vi kører Javalin projektet
                .create(ApplicationConfig::configuration)
                .start(7070);
        entityNotFound();
    }

    public static void entityNotFound() {

        app.exception(EntityNotFoundException.class, (e, ctx) -> {
            ctx.status(HttpStatus.NOT_FOUND);
            ObjectNode errMsg = objectMapper.createObjectNode();
            ctx.json(errMsg.put("msg", e.getMessage()));
        });
    }


}// end class
