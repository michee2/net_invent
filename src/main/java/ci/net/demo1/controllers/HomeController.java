package ci.net.demo1.controllers;


import ci.net.demo1.models.entities.Equipment;
import ci.net.demo1.models.repos.EquipmentRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/home")
public class HomeController extends HttpServlet {

    private EquipmentRepo equipmentRepo;

    public void init() {
        equipmentRepo = new EquipmentRepo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Equipment> equipments = equipmentRepo.getAll();
        List<Equipment> equipments_faulty = equipmentRepo.getAllFaulty();
        List<Equipment> routers = equipmentRepo.getAllRouters();
        List<Equipment> switchs = equipmentRepo.getAllSwitches();
        int nbr_equips = equipments.size();
        int nbr_equips_faulty = equipments_faulty.size();
        int nbr_routers = routers.size();
        int nbr_switchs = switchs.size();

        request.setAttribute("nbr_equips", nbr_equips);
        request.setAttribute("nbr_equips_faulty", nbr_equips_faulty);
        request.setAttribute("nbr_routers", nbr_routers);
        request.setAttribute("nbr_switchs", nbr_switchs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates/home.jsp");
        dispatcher.forward(request, response);
    }
}
