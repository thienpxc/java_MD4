package rikkei.academy.service;

import rikkei.academy.database.UserIMPL;
import rikkei.academy.model.User;
import rikkei.academy.service.interfaces.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserService {


    @Override
    public User insertUser(User user) throws SQLException {
        try {
            PreparedStatement preparedStatement = UserIMPL.connection.prepareStatement("insert into user(name,email,password,address,phone,country) values (?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getCountry());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);
                return new User(null, user.getName(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(), user.getCountry());
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = UserIMPL.connection.prepareStatement("select * from user");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String country = rs.getString("country");
                users.add(new User(id, name, email, password, address, phone, country));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            PreparedStatement preparedStatement = UserIMPL.connection.prepareStatement("delete from user where id = ?");
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET name = ?, email = ?, password = ?, address = ?, phone = ?, country = ? WHERE id = ?";
        PreparedStatement preparedStatement = UserIMPL.connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getAddress());
        preparedStatement.setString(5, user.getPhone());
        preparedStatement.setString(6, user.getCountry());
        preparedStatement.setInt(7, user.getId());
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        return rowUpdated;
    }

    @Override
    public List<User> searchByCountry(String country) throws SQLException{
        PreparedStatement preparedStatement = UserIMPL.connection.prepareStatement("select * from user where country like ?");
        preparedStatement.setString(1, "%" + country + "%");
        ResultSet rs = preparedStatement.executeQuery();
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String country1 = rs.getString("country");
            users.add(new User(id, name, email, password, address, phone, country1));
        }
        return users;
    }

    @Override
    public List<User> sortByName() throws SQLException{
        PreparedStatement preparedStatement = UserIMPL.connection.prepareStatement("select * from user order by name asc");
        ResultSet rs = preparedStatement.executeQuery();
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String country = rs.getString("country");
            users.add(new User(id, name, email, password, address, phone, country));
        }
        return null;
    }



}
