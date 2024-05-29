package rikkeis.academys.dao;

import rikkeis.academys.model.Book;
import rikkeis.academys.model.Category;
import rikkeis.academys.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDaolmpl implements IBookDao {
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        // mở kết nối
        Connection conn = ConnectDB.getConnection();
        try {
            PreparedStatement callSt = conn.prepareStatement("SELECT * FROM  books");
            ResultSet rs = callSt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("totalPages"),
                        rs.getInt("yearCrated"),
                        rs.getString("author"),
                        rs.getBoolean("status")
                );

                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnectio(conn);
        }

    }

    @Override
    public void deleteById(Integer id) {

        Connection conn = ConnectDB.getConnection();

        try {
            CallableStatement callSt = conn.prepareCall("delete from books where id = ?");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnectio(conn);
        }


    }

    @Override
    public void save(Book book) {
        Connection conn = ConnectDB.getConnection();
        CallableStatement callSt = null;

        if (book.getId() == null) {
            try {
                callSt = conn.prepareCall("INSERT INTO books (category_id, name, price, stock, totalPages, yearCrated, author, status) VALUES (?,?,?,?,?,?,?,?)");
                callSt.setInt(1, book.getCategory_id());
                callSt.setString(2, book.getName());
                callSt.setDouble(3, book.getPrice());
                callSt.setInt(4, book.getStock());
                callSt.setInt(5, book.getTotalPages());
                callSt.setInt(6, book.getYearCrated());
                callSt.setString(7, book.getAuthor());
                callSt.setBoolean(8, book.isStatus());
                callSt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectDB.closeConnectio(conn);
            }
        } else {
            try {
                callSt = conn.prepareCall("UPDATE books SET category_id = ?, name = ?, price = ?, stock = ?, totalPages = ?, yearCrated = ?, author = ?, status = ? WHERE id = ?");
                callSt.setInt(1, book.getCategory_id());
                callSt.setString(2, book.getName());
                callSt.setDouble(3, book.getPrice());
                callSt.setInt(4, book.getStock());
                callSt.setInt(5, book.getTotalPages());
                callSt.setInt(6, book.getYearCrated());
                callSt.setString(7, book.getAuthor());
                callSt.setBoolean(8, book.isStatus());
                callSt.setInt(9, book.getId());
                callSt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectDB.closeConnectio(conn);
            }
        }
    }

    @Override
    public Book findBookById(Integer id) {
        Book book = null;
        // mở 1 kết nối
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from books where id =?");
            callSt.setInt(1, id);
            // thực thi sql
            ResultSet rs = callSt.executeQuery(); // thực trhi câu lệnh select
            if (rs.next()) {
                book = new Book(
                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("totalPages"),
                        rs.getInt("yearCrated"),
                        rs.getString("author"),
                        rs.getBoolean("status")
                );
            }
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnectio(conn);
        }
    }


}
