package ci.net.demo1.controllers.equipments;

import ci.net.demo1.models.entities.Site;
import ci.net.demo1.models.repos.SiteRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/equipment/more")
public class MoreInfo extends HttpServlet{

    private SiteRepo siteRepo;

    public void init() {
        siteRepo = new SiteRepo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Site> sites = siteRepo.getAll();

        request.setAttribute("sites", sites);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/equipments/equipmentForm.jsp");
        dispatcher.forward(request, response);
    }
}
