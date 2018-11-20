package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;


@WebServlet(name = "ProgramController", urlPatterns = {"/programs/*"})
public class ProgramController extends Servlet {

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.ADMIN;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/program/programForm.jsp");
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
        Program.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/programs/");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("program", Program.findOne(id));
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("levels", EnumSet.allOf(AcademicLevelEnum.class));
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/program/" + id);
        return request.getRequestDispatcher("/program/programForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("program", Program.findOne(id));
        return request.getRequestDispatcher("/program/programShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("programs", Program.findAll());
        return request.getRequestDispatcher("/program/programShowAll.jsp");
    }
}
