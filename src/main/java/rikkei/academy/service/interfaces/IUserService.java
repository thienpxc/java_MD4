package rikkei.academy.service.interfaces;

import rikkei.academy.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public User insertUser(User user) throws SQLException;
    public User selectUser(int id);

    public List<User> selectAllUsers();
    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;

    public List<User> searchByCountry(String country) throws SQLException;
    public List<User> sortByName() throws SQLException;

}
