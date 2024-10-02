package app.daos;

import app.config.HibernateConfig;
import app.dtos.HotelDTO;
import app.entities.Hotel;
import app.entities.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelDAOTest {

    private static EntityManagerFactory emf;
    private static HotelDAO hotelDAO;
    private static RoomDAO roomDAO;
    Hotel hotel;
    Room room;


    @BeforeAll
    static void beforeAll() {
        emf = HibernateConfig.getEntityManagerFactoryForTest();
        hotelDAO = HotelDAO.getInstance(emf);
    }

    @BeforeEach
    void beforeEach() {
        hotel = new Hotel("Hotel pegasus", "pegasus allé 99");
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(hotel);
            em.getTransaction().commit();

        }
    }

    @Test
    void getAll() {

        int actual = hotelDAO.getAll().size();

        int expected = 1;

        assertEquals(actual, expected);

    }

    @Test
    void getAllHotelsAsDTO() {

        List<HotelDTO> hotel = hotelDAO.getAll();

        int actual = hotel.size();

        int expected = 1;
//        List<HotelDTO> expected = new ArrayList<>(1);
//        expected.add(hotels)

        assertEquals(actual, expected);
    }

//    @Test
//    void createHotelDTO() {
//
//        HotelDTO hotel = new HotelDTO(hotels);
//        hotelDAO.createHotelDTO(hotel);
//
//
//
//    }


}