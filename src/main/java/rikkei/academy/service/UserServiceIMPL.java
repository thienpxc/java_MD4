package rikkei.academy.service;

import rikkei.academy.database.UserIMPL;
import rikkei.academy.model.User;
import rikkei.academy.service.interfaces.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserService {


    @Override
    public User insertUser(User user) throws SQLException {
        Connection conn = UserIMPL.getNewConnection();
        try {
            CallableStatement callSt = conn.prepareCall("insert into user(name,email,password,address,phone,country) values (?,?,?,?,?,?)");
            callSt.setString(1, user.getName());
            callSt.setString(2, user.getEmail());
            callSt.setString(3, user.getPassword());
            callSt.setString(4, user.getAddress());
            callSt.setString(5, user.getPhone());
            callSt.setString(6, user.getCountry());
            int affectedRows = callSt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            ResultSet generatedKeys = callSt.getGeneratedKeys();
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
        finally {
            UserIMPL.closeConnection(conn);
        }
    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        Connection conn = UserIMPL.getNewConnection();
        try {

            CallableStatement callSt = conn.prepareCall("call get_all_users()");
            ResultSet rs = callSt.executeQuery();
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
            return users;

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            UserIMPL.closeConnection(conn);
        }

    }

    @Override
    public boolean deleteUser(int id) {
        try {
            PreparedStatement preparedStatement = UserIMPL.connection.prepareStatement("call get_delete_users(?)");
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
        String sql = "{call update_user(?,?,?,?,?,?,?)}";
        try (Connection connection = UserIMPL.getNewConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getPassword());
            callableStatement.setString(4, user.getAddress());
            callableStatement.setString(5, user.getPhone());
            callableStatement.setString(6, user.getCountry());
            callableStatement.setInt(7, user.getId());
            boolean rowUpdated = callableStatement.executeUpdate() > 0;
            return rowUpdated;
        }
    }
    @Override
    public List<User> searchByCountry(String country) throws SQLException {
        PreparedStatement preparedStatement = UserIMPL.connection.prepareStatement("call search_by_country(?)");
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
    public List<User> sortByName() throws SQLException {
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

    @Override
    public User getUserById(int id) {
        List<User> users = new ArrayList<>();
        String query = "{CALL get_user_by_id(?)}";
        try  {

            CallableStatement callableStatement = UserIMPL.connection.prepareCall(query);
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String country = rs.getString("country");
                users.add(new User( name, email, password, address, phone, country));

            }

        } catch (SQLException e) {

        }
        return (User) users;

    }

    @Override

    public void insertUserStore(User user) throws SQLException {

    }


}
