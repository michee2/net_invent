package ci.net.demo1.controllers.equipments;

import ci.net.demo1.models.entities.Equipment;
import ci.net.demo1.models.entities.Site;
import ci.net.demo1.models.repos.EquipmentRepo;
import ci.net.demo1.models.repos.SiteRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;


@WebServlet("/equipment/update")
public class UpdateEquipment extends HttpServlet {
    private EquipmentRepo equipmentRepo;
    private SiteRepo siteRepo;

    public void init() {
        equipmentRepo = new EquipmentRepo();
        siteRepo = new SiteRepo();
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
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String provider = request.getParameter("provider");
        String status = request.getParameter("status");
        String serial_number = request.getParameter("serial_number");
        Site site = siteRepo.getById(Long.parseLong(request.getParameter("site")));
        LocalDate updatedAt = LocalDate.now();

        Equipment updateEquipment = equipmentRepo.getById(id);

        if(updateEquipment != null){
            updateEquipment.setSite(site);
            updateEquipment.setName(name);
            updateEquipment.setType(type);
            updateEquipment.setProvider(provider);
            updateEquipment.setStatus(status);
            updateEquipment.setSerial_number(serial_number);
            updateEquipment.setUpdatedAt(updatedAt);
            equipmentRepo.update(updateEquipment);
            response.sendRedirect("/demo1-1.0-SNAPSHOT/equipment");
        }

    }
}
