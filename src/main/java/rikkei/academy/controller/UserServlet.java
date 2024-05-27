package rikkei.academy.controller;

import rikkei.academy.model.User;
import rikkei.academy.service.UserServiceIMPL;
import rikkei.academy.service.interfaces.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet("/Users")
public class UserServlet extends HttpServlet {
    private static final IUserService userService = new UserServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "LIST":
                    List<User> users = userService.selectAllUsers();
                    req.setAttribute("users", users);
                    req.getRequestDispatcher("/views/users.jsp").forward(req, resp);
                    break;
                case "ADD":
                    req.getRequestDispatcher("/views/add-user.jsp").forward(req, resp);
                    break;
                case "EDIT":
                    try {
                        Integer idEdit = Integer.valueOf(req.getParameter("id"));
                        User user = findById(idEdit);
                        req.setAttribute("user", user);
                        req.getRequestDispatcher("/views/edit_user.jsp").forward(req, resp);
                    } catch (NumberFormatException e) {
                        // Xử lý trường hợp tham số "id" không hợp lệ
                        // Ví dụ: hiển thị thông báo lỗi, chuyển hướng đến trang khác, ...
                    }
                    break;
                case "DELETE":
                            int idDel = Integer.parseInt(req.getParameter("id"));
                    try {
                        userService.deleteUser(idDel);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    resp.sendRedirect("/Users?action=LIST");
                    break;
                case "SEARCH":
                    String keyword = req.getParameter("keyword");
                    List<User> searchCountry;
                    try {
                        searchCountry = userService.searchByCountry(keyword);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    req.setAttribute("users", searchCountry);
                    req.setAttribute("keyword", keyword);
                    req.getRequestDispatcher("/views/users.jsp").forward(req, resp);
                    break;
                  case "SORT":
                    List<User> sortByName;
                    try {
                        sortByName = userService.sortByName();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    req.setAttribute("users", sortByName);
                    req.getRequestDispatcher("/views/users.jsp").forward(req, resp);
                    break;

                default:
//                    req.getRequestDispatcher("/WEB-INF/views/list-user.jsp").forward(req, resp);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ADD":
                    User users = getUserFromRequest(req);
                    try {
                        userService.insertUser(users);
                    } catch (SQLException e) {
                        System.out.println("loi");
                        throw new RuntimeException(e);
                    }
                    resp.sendRedirect("/Users?action=LIST");
                    break;
                case "UPDATE":
                    String idParam = req.getParameter("id");
                    if (idParam != null && !idParam.isEmpty()) {
                        Integer idEdit = Integer.valueOf(idParam);
                        User userEdit = getUserFromRequest(req);
                        userEdit.setId(idEdit);
                        try {
                            userService.updateUser(userEdit);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        // điều hướng về trang danh sách
                        resp.sendRedirect("/Users?action=LIST");
                    } else {
                        // Xử lý trường hợp không có tham số "id"...
                    }
                    break;

                default:
                    break;


            }
        }
    }
    private User getUserFromRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String country = req.getParameter("country");
        return new User(null, name, email, password, address, phone, country);

    }
    public User findById(Integer id) {
        for (User user : userService.selectAllUsers()) {
            if (user.getId()==id){
                return user;
            }
        }
        return null;

    }
    public List<User> searchCountry(String keyword) {
        return userService.selectAllUsers()
                .stream()
                .filter(user -> user.getCountry().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

}
