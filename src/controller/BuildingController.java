package controller;

import model.AccessLevelEnum;
import model.Building;
import model.Campus;
import model.Institute;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "BuildingController", urlPatterns = {"/buildings/*"})
public class BuildingController extends Servlet {

    private final String redirect = "/buildings";

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.ADMIN;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/buildings/new");
        return request.getRequestDispatcher("/building/buildingForm.jsp");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("building", Building.findOne(id));
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/buildings/" + id + "/edit");
        return request.getRequestDispatcher("/building/buildingForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Integer quantityOfBathrooms = Integer.valueOf(request.getParameter("quantityOfBathrooms"));
        Boolean elevator = Boolean.valueOf(request.getParameter("elevator"));
        Boolean accessibility = Boolean.valueOf(request.getParameter("accessibility"));
        Long idCampus = Long.parseLong(request.getParameter("campus"));
        Long idInstitute = Long.parseLong(request.getParameter("institute"));
        Building building = new Building()
                .setName(name)
                .setQuantityOfBathrooms(quantityOfBathrooms)
                .setElevator(elevator)
                .setAccessibility(accessibility)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute);
        Building.save(building);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long idBuilding = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        Integer quantityOfBathrooms = Integer.valueOf(request.getParameter("quantityOfBathrooms"));
        Boolean elevator = Boolean.valueOf(request.getParameter("elevator"));
        Boolean accessibility = Boolean.valueOf(request.getParameter("accessibility"));
        Long idCampus = Long.parseLong(request.getParameter("campus"));
        Long idInstitute = Long.parseLong(request.getParameter("institute"));
        Building building = new Building()
                .setIdBuilding(idBuilding)
                .setName(name)
                .setQuantityOfBathrooms(quantityOfBathrooms)
                .setElevator(elevator)
                .setAccessibility(accessibility)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute);
        Building.update(building);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Building.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("building", Building.findOne(id));
        return request.getRequestDispatcher("/building/buildingShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("buildings", Building.findAll());
        return request.getRequestDispatcher("/building/buildingShowAll.jsp");
    }
}
