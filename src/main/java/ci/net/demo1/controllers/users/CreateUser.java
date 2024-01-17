package ci.net.demo1.controllers.users;

import ci.net.demo1.models.entities.Role;
import ci.net.demo1.models.entities.User;
import ci.net.demo1.models.repos.RoleRepo;
import ci.net.demo1.models.repos.UserRepo;
import ci.net.demo1.models.entities.Site;
import ci.net.demo1.models.repos.SiteRepo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/user/add")
public class CreateUser extends HttpServlet {
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
            createUser(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Site site = siteRepo.getById(Long.parseLong(request.getParameter("site")));
        Role role = roleRepo.getById(Long.parseLong(request.getParameter("role")));

        User newUser = new User(firstname, lastname, username, password, site, role);

        userRepo.create(newUser);
        response.sendRedirect("/demo1-1.0-SNAPSHOT/user");
    }
}
