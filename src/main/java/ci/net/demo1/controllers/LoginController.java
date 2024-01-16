package ci.net.demo1.controllers;

import ci.net.demo1.models.repos.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserRepo userRepo;

    public void init() {
        userRepo = new UserRepo();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userRepo.validate(username, password)) {
            response.sendRedirect("/demo1-1.0-SNAPSHOT/home");
        }else {
            response.sendRedirect("/demo1-1.0-SNAPSHOT");
        }
    }
}
