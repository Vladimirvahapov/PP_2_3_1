package web.dao;

import web.model.User;

import java.util.List;

public interface UsersDao {
    void createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}
