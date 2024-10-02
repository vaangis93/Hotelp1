package app.routes;

import app.config.ApplicationConfig;
import app.config.HibernateConfig;
import app.entities.Hotel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class RoutesTest {

    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryForTest();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Hotel h1, h2;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "http://localhost:7070/api/v1";
        ApplicationConfig.start();
    }

    @BeforeEach
    void beforeEach() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Hotel").executeUpdate();
            em.createQuery("DELETE FROM Room").executeUpdate();
            h1 = new Hotel("Hotel 1", "Address 1");
            h2 = new Hotel("Hotel 2", "Address 2");
            em.persist(h1);
            em.persist(h2);
            em.getTransaction().commit();
        }
    }

    @Test
    void getHotels() {
        given()
                .when()
                .get("/hotels")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void getById() {
        given()
                .when()
                .log().all()
                .get("/hotels/" + h1.getId())
                .then()
                .log().all()
                .body("id", equalTo(1));
    }
}