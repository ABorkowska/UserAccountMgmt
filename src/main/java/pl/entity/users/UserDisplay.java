package pl.entity.users;

import pl.entity.User;
import pl.entity.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserDisplay", value = "/user/display")
public class UserDisplay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        User user = new User(id);
        UserDAO dao = new UserDAO();
        try {
            dao.findUser(id);
            request.setAttribute("users", dao.displayAll());
            request.setAttribute("id", id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/display.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
