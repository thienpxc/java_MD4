package rikkeis.academys.dao;

import rikkeis.academys.model.Book;
import rikkeis.academys.model.Category;
import rikkeis.academys.service.BookServicelmpI;
import rikkeis.academys.service.IBookController;
import rikkeis.academys.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaolmpl implements ICategoryDao {

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from category");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
                System.out.println(category);
                categories.add(category);
            }
            return categories;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnectio(conn);
        }

    }

    @Override
    public void deleteById(Integer id) {

        Connection conn = ConnectDB.getConnection();
        try {
            // Check if there are any books in the category
            int bookCount = countBooksInCategory(id);
            if (bookCount > 0) {
                // If there are books, change the status to false (inactive)
                CallableStatement callSt = conn.prepareCall("update category set status = false where id = ?");
                callSt.setInt(1, id);
                callSt.executeUpdate();
            } else {
                // If there are no books, delete the category
                CallableStatement callSt = conn.prepareCall("delete from category where id = ?");
                callSt.setInt(1, id);
                callSt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnectio(conn);
        }
    }

    @Override
    public void save(Category category) {
        Connection conn = ConnectDB.getConnection();
        CallableStatement callSt = null;

        if (category.getId() == null) {
            try {
                callSt = conn.prepareCall("insert into category(name, status) values (?, ?)");
                callSt.setString(1, category.getName());
                callSt.setBoolean(2, category.isStatus());
                callSt.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectDB.closeConnectio(conn);
            }
        } else {
            try {
                callSt = conn.prepareCall("update category set name = ?, status = ? where id = ?");
                callSt.setString(1, category.getName());
                callSt.setBoolean(2, category.isStatus());
                callSt.setInt(3, category.getId());
                callSt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectDB.closeConnectio(conn);
            }
        }
    }

    @Override
    public Category findCategoryById(Integer id) {
        Category category = null;
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from category where id = ?");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                category = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
            }
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnectio(conn);
        }

    }
    public int countBooksInCategory(Integer categoryId) {
        int count = 0;
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select count(*) from books where category_id = ?");
            callSt.setInt(1, categoryId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnectio(conn);
        }
        return count;
    }
}
