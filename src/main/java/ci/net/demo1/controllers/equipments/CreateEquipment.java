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
import java.util.Date;


@WebServlet("/equipment/add")
public class CreateEquipment extends HttpServlet {
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
            createEquipment(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void createEquipment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String provider = request.getParameter("provider");
        String status = request.getParameter("status");
        String serial_number = request.getParameter("serial_number");
        Site site = siteRepo.getById(Long.parseLong(request.getParameter("site")));
        LocalDate createdAt = LocalDate.now();

        Equipment newEquipment = new Equipment(name, provider, type, serial_number, status, site, createdAt, createdAt);
        equipmentRepo.create(newEquipment);
        response.sendRedirect("/demo1-1.0-SNAPSHOT/equipment");
    }
}
