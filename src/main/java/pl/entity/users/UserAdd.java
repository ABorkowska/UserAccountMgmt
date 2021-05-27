package pl.entity.users;

import pl.entity.User;
import pl.entity.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/addUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User(request.getParameter("email"),request.getParameter("username"),request.getParameter("password"));

        UserDAO dao = new UserDAO();
        try {
            dao.addUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/user/list");
    }
}
