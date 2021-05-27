package pl.entity.users;

import pl.entity.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserList", value = "/user/list")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            UserDAO userDao = new UserDAO();
            try {
                request.setAttribute("users", userDao.displayAll());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
