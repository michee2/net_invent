package ci.net.demo1.controllers.logs;

import ci.net.demo1.models.entities.Log;
import ci.net.demo1.models.repos.LogRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/log/add")
public class CreateLog extends HttpServlet {
    private LogRepo equipmentRepo;

    public void init() {
        equipmentRepo = new LogRepo();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            createLog(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void createLog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        response.sendRedirect("/demo1-1.0-SNAPSHOT/log");
    }
}
