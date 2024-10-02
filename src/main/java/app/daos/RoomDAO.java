package app.daos;

import app.entities.Hotel;
import app.entities.Room;
import app.genericif.GenericInterfaceDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;


public class RoomDAO implements GenericInterfaceDAO<Room, Integer> {

    private static RoomDAO instance;
    private static EntityManagerFactory emf;

    public static RoomDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RoomDAO();
        }
        return instance;
    }




    // get all rooms for a specific hotel
    public List<Room> getAllRooms(Hotel hotel) {
        return null;
    }

    @Override
    public List<Room> getAll() {

        // typed query here ?

        return List.of();
    }

    @Override
    public Room GetById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Room foundById = em.find(Room.class, id);
            System.out.println(foundById);
            return foundById;
        }

    }

    @Override
    public void create(Room entity) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(Room entity, Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }
    }
}// end class
