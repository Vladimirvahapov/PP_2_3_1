package web.service;

import org.springframework.stereotype.Service;
import web.dao.UsersDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UsersDao usersDao;

    public UserServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return usersDao.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        usersDao.updateUser(user);
    }

    @Override
    public void createUser(User user) {
        usersDao.createUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        usersDao.deleteUserById(id);
    }
}
