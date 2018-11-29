package controller;

import model.AccessLevelEnum;
import model.HonorificsEnum;
import model.Professor;
import model.StatusEnum;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;


@WebServlet(name = "ProfessorController", urlPatterns = {"/professors/*"})
public class ProfessorController extends Servlet {

    private final String redirect = "/professors";

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.HEAD;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("status", EnumSet.allOf(StatusEnum.class));
        request.setAttribute("honorifics", EnumSet.allOf(HonorificsEnum.class));
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/professors/new");
        return request.getRequestDispatcher("/professor/professorForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String status = request.getParameter("status");
        String honorifics = request.getParameter("honorifics");
        Professor professor = new Professor()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setStatus(status)
                .setHonorifics(honorifics);
        Professor.save(professor);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Professor.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("professor", Professor.findOne(id));
        request.setAttribute("status", EnumSet.allOf(StatusEnum.class));
        request.setAttribute("honorifics", EnumSet.allOf(HonorificsEnum.class));
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/professors/" + id + "/edit");
        return request.getRequestDispatcher("/professor/professorForm.jsp");
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long idProfessor = Long.valueOf(request.getAttribute("id").toString());
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String status = request.getParameter("status");
        String honorifics = request.getParameter("honorifics");
        Professor professor = new Professor()
                .setIdProfessor(idProfessor)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setStatus(status)
                .setHonorifics(honorifics);
        Professor.update(professor);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
