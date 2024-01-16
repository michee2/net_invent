package ci.net.demo1.controllers.users;

import ci.net.demo1.models.entities.Equipment;
import ci.net.demo1.models.repos.EquipmentRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/user/add")
public class CreateUser extends HttpServlet {
    private EquipmentRepo equipmentRepo;

    public void init() {
        equipmentRepo = new EquipmentRepo();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            createEquipment(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void createEquipment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String site = request.getParameter("site");
        String etat = request.getParameter("etat");
        Equipment newEquipment = new Equipment(site, etat);
        equipmentRepo.create(newEquipment);
        response.sendRedirect("/demo1-1.0-SNAPSHOT/equipment");
    }
}
