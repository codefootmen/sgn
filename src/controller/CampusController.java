package controller;

import model.Campus;
import model.Institute;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CampusController", urlPatterns = {"/campi/*"})
public class CampusController extends Servlet {

    private final String redirect = "/campi";

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/campi/new");
        return request.getRequestDispatcher("/campus/campusForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String telephone = request.getParameter("telephone");
        String zip = request.getParameter("zip");
        Long institute = Long.parseLong(request.getParameter("idInstitute"));
        Campus campus = new Campus()
                .setName(name)
                .setStreet(street)
                .setNumber(Long.parseLong(number))
                .setCity(city)
                .setState(state)
                .setTelephone(telephone)
                .setZip(zip)
                .setIdInstitute(institute);
        Campus.save(campus);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        String street = request.getParameter("street");
        Long number = Long.valueOf(request.getParameter("number"));
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String telephone = request.getParameter("telephone");
        String zip = request.getParameter("zip");
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Campus campus = new Campus()
                .setIdCampus(id)
                .setName(name)
                .setStreet(street)
                .setNumber(number)
                .setCity(city)
                .setState(state)
                .setTelephone(telephone)
                .setZip(zip)
                .setIdInstitute(idInstitute);
        Campus.update(campus);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Campus.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("campus", Campus.findOne(id));
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/campi/" + id + "/edit");
        return request.getRequestDispatcher("/campus/campusForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("campus", Campus.findOne(id));
        return request.getRequestDispatcher("/campus/campusShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("campi", Campus.findAll());
        return request.getRequestDispatcher("/campus/campusShowAll.jsp");
    }
}
