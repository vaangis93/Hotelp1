package app.daos;

import app.dtos.HotelDTO;
import app.entities.Hotel;
import app.genericif.GenericInterfaceDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class HotelDAO implements GenericInterfaceDAO<HotelDTO, Integer> {


    private static HotelDAO instance;
    private static EntityManagerFactory emf;


    // private constructor
    private HotelDAO() {
    }

    // EntityManagerFactory emf = depency injection
    public static HotelDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            instance = new HotelDAO();
            emf = _emf;
        }
        return instance;
    }
//// returning a entity
//    public List<Rooms> getAllTheRoomsForAHotel(Integer id) {
//        try (EntityManager em = emf.createEntityManager()) {
//
//            Hotels hotelById = em.find(Hotels.class, id);
//
//            if (hotelById == null) {
//                throw new IllegalArgumentException("Hotel does not exist " + hotelById);
//            }
//
//            TypedQuery<Rooms> hotelsTypedQuery = em.createQuery("SELECT r FROM Rooms r WHERE r.hotelId= :hotel_id", Rooms.class);
//            hotelsTypedQuery.setParameter("hotel_id", hotelById);
//            System.out.println(hotelsTypedQuery.getResultList());
//            return hotelsTypedQuery.getResultList();
//
//        }
//    }
// getting all hotels


    // getting all hotels as DTO
    @Override
    public List<HotelDTO> getAll() {

        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Hotel> hotelsTypedQuery = em.createQuery("SELECT h from Hotel h", Hotel.class);
            System.out.println(hotelsTypedQuery.getResultList());
            List<Hotel> hotels = hotelsTypedQuery.getResultList();
            List<HotelDTO> hotelDTOS = new ArrayList<>();
            for (Hotel hotel : hotels) {
                hotelDTOS.add(new HotelDTO(hotel));
            }
            return hotelDTOS;

        }
    }

    @Override
    public HotelDTO GetById(int id) {
        try (EntityManager em = emf.createEntityManager()) {

            Hotel foundById = em.find(Hotel.class, id);
            System.out.println(foundById);
            return new HotelDTO(foundById);

        }
    }


    public HotelDTO createHotelDTO(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel(hotelDTO);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(hotel);
            em.getTransaction().commit();

        }
        return new HotelDTO(hotel);
    }

    @Override
    public void create(HotelDTO entity) {

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(HotelDTO entity, Integer id) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Hotel foundById = em.find(Hotel.class, id);
            em.remove(foundById);
            em.getTransaction().commit();
        }
    }
}// end class
