package controller;

import dao.IUserDAO;
import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    IUserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "view":
                showUserInfor(request, response);
                break;
            case "findByName":
                showFindByNameForm(request, response);
                break;
            case "findByCountry":
                showFindByCountryForm(request, response);
                break;
            case "orderByName":
                try {
                    showListUserOrderByName(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showListUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showListUserOrderByName(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> users = userDAO.orderByName();
        request.setAttribute("listUser", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showFindByCountryForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/findByCountryForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showFindByNameForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/findByNameForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showUserInfor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/view.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.findById(id);
        request.setAttribute("userInfor", user);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.findById(id);
        request.setAttribute("userEdit", user);
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.findById(id);
        request.setAttribute("userDel", user);
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> users = userDAO.findAll();
        request.setAttribute("listUser", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "findByName":
                findUserByName(request, response);
                break;
            case "findByCountry":
                findUserByCountry(request, response);
                break;
            default:
        }
    }

    private void findUserByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        List<User> users = userDAO.findByCountry(country);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        request.setAttribute("listUser", users);
        dispatcher.forward(request, response);
    }

    private void findUserByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<User> users = userDAO.findByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        request.setAttribute("listUser", users);
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        userDAO.update(user);
        response.sendRedirect("/users");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(id);
        response.sendRedirect("/users");
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        userDAO.add(new User(name, email, country));
        response.sendRedirect("/users");
    }
}
