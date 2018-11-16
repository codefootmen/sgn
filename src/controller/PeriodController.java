package controller;

import model.Period;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "PeriodController", urlPatterns = {"/periods/*"})
public class PeriodController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("rooms", Room.findAll());
        return request.getRequestDispatcher("/period/periodForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        Period.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/periods/");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("period", Period.findOne(id));
        request.setAttribute("rooms", Room.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/period/" + id);
        return request.getRequestDispatcher("/period/periodForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("period", Period.findOne(id));
        return request.getRequestDispatcher("/period/periodShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("periods", Period.findAll());
        return request.getRequestDispatcher("/period/periodShowAll.jsp");
    }
}
