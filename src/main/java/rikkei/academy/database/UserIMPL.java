package rikkei.academy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserIMPL {
    public static Connection connection;
    private static String   jdbcURL = "jdbc:mysql://localhost:3306/users";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";

    static  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("loi connect mysql");
        }
    }
    public  static void  closeConnection(Connection conn){
        try {
            if (!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getNewConnection() {
        try {
            return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
