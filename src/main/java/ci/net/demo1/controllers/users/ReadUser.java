package ci.net.demo1.controllers.users;

import ci.net.demo1.models.entities.User;
import ci.net.demo1.models.repos.UserRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user")
public class ReadUser extends HttpServlet {
    private UserRepo userRepo;

    public void init() {
        userRepo = new UserRepo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
                listUser(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userRepo.getAll();
        request.setAttribute("listUsers", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/userList.jsp");
        dispatcher.forward(request, response);
    }
}
