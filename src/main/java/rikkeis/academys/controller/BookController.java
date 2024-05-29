package rikkeis.academys.controller;

import rikkeis.academys.dao.BookDaolmpl;
import rikkeis.academys.model.Book;
import rikkeis.academys.model.Category;
import rikkeis.academys.service.BookServicelmpI;
import rikkeis.academys.service.CategoryServicelmpl;
import rikkeis.academys.service.IBookController;
import rikkeis.academys.service.ICategoryController;
import rikkeis.academys.util.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookController", value = "/books")
public class BookController extends HttpServlet {
    private static final IBookController bookController = new BookServicelmpI();
    private static final ICategoryController categoryController = new CategoryServicelmpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        List<Category> categories = categoryController.findAll();
        req.setAttribute("categories", categories);
        if (action != null) {
            switch (action) {
                case "LIST":
                    // hiển thị danh sách
                    List<Book> books = bookController.findAll();
                    req.setAttribute("books", books);
                    req.getRequestDispatcher("/views/books/list-book.jsp")
                            .forward(req, resp);
                    break;
                case "ADD":
                    req.getRequestDispatcher("/views/books/add-book.jsp").forward(req, resp);
                    break;
                case "EDIT":
                    Integer idEdit = Integer.valueOf(req.getParameter("id"));
                    Book book = bookController.findBookById(idEdit);
                    req.setAttribute("book", book);
                    req.getRequestDispatcher("/views/books/edit-book.jsp").forward(req, resp);
                    break;
                case "DELETE":
                    // lấy id
                    Integer idDel = Integer.valueOf(req.getParameter("id"));
                    // tiến hành xóa
                    bookController.deleteById(idDel);
                    // điều hướng về trang danh sách
                    resp.sendRedirect("/books?action=LIST");
                    break;


            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action !=null){
            switch(action){
                case "ADD":
                    Book book = getBook(req);

                    bookController.save(book);
                    resp.sendRedirect("/books?action=LIST");
                    break;
                case "EDIT":
                    Integer idEdit = Integer.valueOf(req.getParameter("id"));
                    System.out.println("wwww"+idEdit);
                    Book bookEdit = getBook(req);
                    System.out.println("tttt"+bookEdit);
                    bookEdit.setId(idEdit);
                    bookController.save(bookEdit);
                    // điều hướng về trang danh sách
                    resp.sendRedirect("/books?action=LIST");
                    break;

            }
        }
    }
    private Book getBook(HttpServletRequest req){
        int categoryId = Integer.parseInt(req.getParameter("category"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        int totalPages = Integer.parseInt(req.getParameter("totalPages"));
        int yearCreated = Integer.parseInt(req.getParameter("yearCrated"));
        String author = req.getParameter("author");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));


        return new Book(null, categoryId, name, price, stock, totalPages, yearCreated, author, status);
    }
    public int countBooksInCategory(Integer categoryId) {
        int count = 0;
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select count(*) from book where category_id = ?");
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
