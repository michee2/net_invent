package ci.net.demo1.controllers.equipments;

import ci.net.demo1.models.entities.Equipment;
import ci.net.demo1.models.entities.Site;
import ci.net.demo1.models.repos.EquipmentRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/equipment/edit")
public class EditEquipment extends HttpServlet {
    private EquipmentRepo equipmentRepo;
    private

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
            showEditForm(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Equipment existingEquipment = equipmentRepo.getById(id);
        List<Site> sites = siteRepo.getAll();
        Site siteEquipment = existingEquipment.getSite();

        request.setAttribute("equipment", existingEquipment);
        request.setAttribute("sites", sites);
        request.setAttribute("siteEquipment", siteEquipment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/equipments/equipmentForm.jsp");
        dispatcher.forward(request, response);

    }
}
