package ci.net.demo1.controllers.equipments;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import ci.net.demo1.models.repos.EquipmentRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import ci.net.demo1.models.entities.Equipment;


@WebServlet("/")
public class EquipmentController extends HttpServlet {
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
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertEquipment(request, response);
                    break;
                case "/delete":
                    deleteEquipment(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateEquipment(request, response);
                    break;
                default:
                    listEquipment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEquipment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Equipment> listEquipment = equipmentRepo.getAll();
        request.setAttribute("listEquipment", listEquipment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/equipment-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/equipment-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Equipment existingEquipment = equipmentRepo.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/equipment-form.jsp");
        request.setAttribute("equipment", existingEquipment);
        dispatcher.forward(request, response);
    }

    private void insertEquipment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String site = request.getParameter("site");
        String etat = request.getParameter("etat");
        Equipment newEquipment = new Equipment(site, etat);
        equipmentRepo.create(newEquipment);
        response.sendRedirect("list");
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
            response.sendRedirect("list");
        }

    }

    private void deleteEquipment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Equipment deleteEquipment = equipmentRepo.getById(id);

        if (deleteEquipment != null) {
            equipmentRepo.delete(deleteEquipment);
            response.sendRedirect("list");
        }
    }
}
