package controller;

import model.HonorificsEnum;
import model.Professor;
import model.StatusEnum;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;


@WebServlet(name = "ProfessorController", urlPatterns = {"/professors/*"})
public class ProfessorController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("status", EnumSet.allOf(StatusEnum.class));
        request.setAttribute("honorifics", EnumSet.allOf(HonorificsEnum.class));
        return request.getRequestDispatcher("/professor/professorForm.jsp");
    }

    @Override
    public RequestDispatcher insert(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/professor/professorForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("professor", Professor.findOne(id));
        return request.getRequestDispatcher("/professor/professorShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("professors", Professor.findAll());
        return request.getRequestDispatcher("/professor/professorShowAll.jsp");
    }
}
