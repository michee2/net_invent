package ci.net.demo1.controllers.users;


import ci.net.demo1.models.entities.Role;
import ci.net.demo1.models.entities.Site;
import ci.net.demo1.models.repos.RoleRepo;
import ci.net.demo1.models.repos.SiteRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/user/new")
public class NewUser extends HttpServlet {

    private SiteRepo siteRepo;
    private RoleRepo roleRepo;

    public void init() {
        siteRepo = new SiteRepo();
        roleRepo = new RoleRepo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Site> sites = siteRepo.getAll();
        Role role = roleRepo.getById(Long.parseLong("2"));
        request.setAttribute("role", role);
        request.setAttribute("sites", sites);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/userForm.jsp");
        dispatcher.forward(request, response);
    }
}
