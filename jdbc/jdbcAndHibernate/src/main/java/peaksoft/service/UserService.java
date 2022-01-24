package peaksoft.service;

import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void createUsersTable();

    void dropUsersTable() throws SQLException;

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id) throws SQLException;

    List<User> getAllUsers();

    void cleanUsersTable();
}

