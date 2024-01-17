package ci.net.demo1.controllers.users;

import ci.net.demo1.models.entities.Role;
import ci.net.demo1.models.entities.Site;
import ci.net.demo1.models.entities.User;
import ci.net.demo1.models.repos.RoleRepo;
import ci.net.demo1.models.repos.SiteRepo;
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

@WebServlet("/user/edit")
public class EditUser extends HttpServlet {
    private UserRepo userRepo;
    private SiteRepo siteRepo;

    private RoleRepo roleRepo;

    public void init() {
        userRepo = new UserRepo();
        siteRepo = new SiteRepo();
        roleRepo = new RoleRepo();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            showEditForm(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        User existingUser = userRepo.getById(id);

        List<Site> sites = siteRepo.getAll();
        Role role = roleRepo.getById(Long.parseLong("2"));
        Site siteUser = existingUser.getSite();

        request.setAttribute("role", role);
        request.setAttribute("sites", sites);
        request.setAttribute("siteUser", siteUser);

        request.setAttribute("user", existingUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/userForm.jsp");
        dispatcher.forward(request, response);

    }
}
