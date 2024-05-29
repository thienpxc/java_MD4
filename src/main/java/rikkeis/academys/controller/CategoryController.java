package rikkeis.academys.controller;

import rikkeis.academys.model.Book;
import rikkeis.academys.model.Category;
import rikkeis.academys.service.BookServicelmpI;
import rikkeis.academys.service.CategoryServicelmpl;
import rikkeis.academys.service.IBookController;
import rikkeis.academys.service.ICategoryController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/category")
public class CategoryController extends HttpServlet {
    private static final ICategoryController categoryController = new CategoryServicelmpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "LIST":
                    // hiển thị danh sách
                    List<Category> categories = categoryController.findAll();
                    req.setAttribute("categories", categories);
                    req.getRequestDispatcher("/views/category/list-category.jsp")
                            .forward(req, resp);
                    break;
                case "ADD":
                    req.getRequestDispatcher("/views/category/add-category.jsp").forward(req, resp);
                    break;
                case "EDIT":
                    // lấy ra id
                    Integer idEdit = Integer.valueOf(req.getParameter("id"));
                    Category category = categoryController.findCategoryById(idEdit);
                    req.setAttribute("category", category);
                    req.getRequestDispatcher("/views/category/edit-category.jsp").forward(req, resp);
                    break;
                case "DELETE":
                    // lấy id
                    Integer idDel = Integer.valueOf(req.getParameter("id"));
                    // tiến hành xóa
                    categoryController.deleteById(idDel);
                    // điều hướng về trang danh sách
                    resp.sendRedirect("/category?action=LIST");
                    break;

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ADD":
                    // lấy dữ liệu từ form
                    String name = req.getParameter("name");
                    boolean status = Boolean.parseBoolean(req.getParameter("status"));
                    // tạo một đối tượng Category mới
                    Category category = new Category(null, name, status);
                    // lưu vào db
                    categoryController.save(category);
                    // điều hướng về trang danh sách
                    resp.sendRedirect("/category?action=LIST");
                    break;
                 case "EDIT":
                    // lấy dữ liệu từ form
                    Integer id = Integer.valueOf(req.getParameter("id"));
                    String nameEdit = req.getParameter("name");
                    boolean statusEdit = Boolean.parseBoolean(req.getParameter("status"));
                    // tạo một đối tượng Category mới
                    Category categoryEdit = new Category(id, nameEdit, statusEdit);
                    // lưu vào db
                    categoryController.save(categoryEdit);
                    // điều hướng về trang danh sách
                    resp.sendRedirect("/category?action=LIST");
                    break;
            }
        }
    }
}
