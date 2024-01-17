package ci.net.demo1.controllers.users;

import ci.net.demo1.models.entities.User;
import ci.net.demo1.models.repos.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/user/delete")
public class DeleteUser extends HttpServlet {
    private UserRepo userRepo;

    public void init() {
        userRepo = new UserRepo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            deleteUser(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        User deleteUser = userRepo.getById(id);

        if (deleteUser != null) {
            userRepo.delete(deleteUser);
            response.sendRedirect("/demo1-1.0-SNAPSHOT/user");
        }
    }
}
