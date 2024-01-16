package ci.net.demo1.controllers.users;

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

@WebServlet("/user/edit")
public class EditUser extends HttpServlet {
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
            showEditForm(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Equipment existingEquipment = equipmentRepo.getById(id);
        request.setAttribute("equipment", existingEquipment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views_mod/equipment-form.jsp");
        dispatcher.forward(request, response);

    }
}
