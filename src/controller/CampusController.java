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
        return null;
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("campi", Campus.findAll());
        return request.getRequestDispatcher("campus/campusShowAll.jsp");
    }
}
