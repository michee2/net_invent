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


@WebServlet("/equipment/update")
public class UpdateEquipment extends HttpServlet {
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
            updateEquipment(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateEquipment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String site = request.getParameter("site");
        String etat = request.getParameter("etat");
        Equipment updateEquipment = equipmentRepo.getById(id);

        if(updateEquipment != null){
            updateEquipment.setSite(site);
            updateEquipment.setEtat(etat);
            equipmentRepo.update(updateEquipment);
            response.sendRedirect("/demo1-1.0-SNAPSHOT/equipment");
        }

    }
}
