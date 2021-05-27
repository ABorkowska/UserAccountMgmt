package pl.entity.users;

import pl.entity.User;
import pl.entity.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO dao = new UserDAO();
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("id", id);

        try {
            User user = dao.findUser(id);
            request.setAttribute("user", user);
            //request.setAttribute("users", dao.displayAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();

        HttpSession httpSession = request.getSession();
        int id = (int) httpSession.getAttribute("id");
        System.out.println("doPost ID+ " + id);

        user.setId(id);
        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        UserDAO dao = new UserDAO();
        try {
            dao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/user/list");
    }
}