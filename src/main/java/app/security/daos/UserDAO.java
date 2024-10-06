package app.security.daos;

import app.exceptions.ValidationException;
import app.security.entities.Role;
import app.security.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class UserDAO implements ISecurityDAO {

    private static UserDAO instance;
    private static EntityManagerFactory emf;

    public static UserDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserDAO();
        }
        return instance;
    }


    @Override
    public User getVerifiedUser(String username, String password) throws ValidationException {
        return null;
    }

    public User createExistingUser(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        }
    }

    @Override
    public User createUser(String username, String password) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            User user = new User(username, password);
            em.persist(user);
            em.getTransaction().commit();
            return user;
        }
    }

    public Role createExistingRole(Role role) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(role);
            em.getTransaction().commit();
            return role;
        }
    }
    @Override
    public Role createRole(String role) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Role newRole = new Role(role);
            em.persist(newRole);
            em.getTransaction().commit();
            return newRole;
        }
    }

    @Override
    public User addUserRole(String username, String role) {
        return null;
    }
}
