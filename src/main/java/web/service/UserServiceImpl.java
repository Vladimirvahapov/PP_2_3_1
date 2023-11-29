package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UsersDao;
import web.model.User;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UsersDao usersDao;

    public UserServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public void createUser(User user) {
        usersDao.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return usersDao.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        usersDao.updateUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        usersDao.deleteUserById(id);
    }
}
