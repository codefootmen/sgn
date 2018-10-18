package controller;

import model.Campus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CampusController", urlPatterns = {"/campi/*"})
public class CampusController extends Servlet{


    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/campus/campusForm.jsp");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
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
