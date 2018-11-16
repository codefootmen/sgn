package controller;

import model.Building;
import model.Campus;
import model.Institute;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


@WebServlet(name = "BuildingController", urlPatterns = {"/buildings/*"})
public class BuildingController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/building/new");
        return request.getRequestDispatcher("/building/buildingForm.jsp");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("building", Building.findOne(id));
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/building/" + id + "/edit");
        return request.getRequestDispatcher("/building/buildingForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
        String name = request.getParameter("name");
        String quantityOfBathrooms = request.getParameter("quantityOfBathrooms");
        String elevator = request.getParameter("elevator");
        String accessibility = request.getParameter("accessibility");
        String campus = request.getParameter("campus");
        String institute = request.getParameter("institute");
        Building building = new Building()
                .setName(name)
                .setQuantityOfBathrooms(Integer.valueOf(quantityOfBathrooms))
                .setElevator(Boolean.valueOf(elevator))
                .setAccessibility(Boolean.valueOf(accessibility))
                .setCampus(Campus.findOne(Long.parseLong(campus)))
                .setInstitute(Institute.findOne(Long.parseLong(institute)));
        Building.save(building);
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
        Long idBuilding = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        String quantityOfBathrooms = request.getParameter("quantityOfBathrooms");
        String elevator = request.getParameter("elevator");
        String accessibility = request.getParameter("accessibility");
        String campus = request.getParameter("campus");
        String institute = request.getParameter("institute");
        Building building = new Building()
                .setIdBuilding(idBuilding)
                .setName(name)
                .setQuantityOfBathrooms(Integer.valueOf(quantityOfBathrooms))
                .setElevator(Boolean.valueOf(elevator))
                .setAccessibility(Boolean.valueOf(accessibility))
                .setCampus(Campus.findOne(Long.parseLong(campus)))
                .setInstitute(Institute.findOne(Long.parseLong(institute)));

        building.update();
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        Building.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/buildings/");
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
