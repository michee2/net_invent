package ci.net.demo1.controllers.equipments;

import ci.net.demo1.models.entities.Equipment;
import ci.net.demo1.models.repos.EquipmentRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/equipment/delete")
public class DeleteEquipment extends HttpServlet {
    private EquipmentRepo equipmentRepo;

    public void init() {
        equipmentRepo = new EquipmentRepo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            deleteEquipment(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteEquipment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Equipment deleteEquipment = equipmentRepo.getById(id);

        if (deleteEquipment != null) {
            equipmentRepo.delete(deleteEquipment);
            response.sendRedirect("/demo1-1.0-SNAPSHOT/equipment");
        }
    }
}
