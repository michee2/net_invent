package ci.net.demo1.controllers.equipments;

import ci.net.demo1.models.entities.Equipment;
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

@WebServlet("/equipment")
public class ReadEquipment extends HttpServlet {
    private EquipmentRepo equipmentRepo;

    public void init() {
        equipmentRepo = new EquipmentRepo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
                listEquipment(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEquipment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Equipment> listEquipment = equipmentRepo.getAll();
        request.setAttribute("listEquipment", listEquipment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("equipments/equipmentList.jsp");
        dispatcher.forward(request, response);
    }
}
