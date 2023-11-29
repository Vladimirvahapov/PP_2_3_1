package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {


    private EntityManager manager;

    @PersistenceContext
    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void createUser(User user) {
        manager.persist(user);
        manager.flush();
    }

    @Override
    public List<User> getAllUsers() {
        return manager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        manager.merge(user);
        manager.flush();
    }

    @Override
    public void deleteUserById(int id) {
        User user = manager.find(User.class, id);
        if (user != null) {
            manager.remove(user);
        }
        manager.flush();
    }
}
