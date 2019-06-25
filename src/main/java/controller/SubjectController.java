package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;


@WebServlet(name = "SubjectController", urlPatterns = {"/subjects/*"})
public class SubjectController extends Servlet {

    private final String redirect = "/subjects";

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.HEAD;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("programs", Program.findAll());
        request.setAttribute("roomTypes", RoomType.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/subjects/new");
        return request.getRequestDispatcher("/subject/subjectForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Integer quantityOfCredits = Integer.valueOf(request.getParameter("quantityOfCredits"));
        Long idRoomType = Long.valueOf(request.getParameter("idRoomType"));
        Long idProgram = Long.valueOf(request.getParameter("idProgram"));
        Long idDepartment = Long.valueOf(request.getParameter("idDepartment"));
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Subject subject = new Subject()
                .setName(name)
                .setQuantityOfCredits(quantityOfCredits)
                .setRoomType(RoomType.findOne(idRoomType))
                .setProgram(Program.findOne(idProgram))
                .setDepartment(Department.findOne(idDepartment))
                .setCampus(Campus.findOne(idCampus))
                .setInstitute(Institute.findOne(idInstitute));
        Subject.save(subject);

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
        Integer quantityOfCredits = Integer.valueOf(request.getParameter("quantityOfCredits"));
        Long idRoomType = Long.valueOf(request.getParameter("idRoomType"));
        Long idProgram = Long.valueOf(request.getParameter("idProgram"));
        Long idDepartment = Long.valueOf(request.getParameter("idDepartment"));
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Subject subject = new Subject()
                .setIdSubject(id)
                .setName(name)
                .setQuantityOfCredits(quantityOfCredits)
                .setRoomType(RoomType.findOne(idRoomType))
                .setProgram(Program.findOne(idProgram))
                .setDepartment(Department.findOne(idDepartment))
                .setCampus(Campus.findOne(idCampus))
                .setInstitute(Institute.findOne(idInstitute));
        Subject.update(subject);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Subject.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("subject", Subject.findOne(id));
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("programs", Program.findAll());
        request.setAttribute("roomTypes", RoomType.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/subjects/" + id + "/edit");
        return request.getRequestDispatcher("/subject/subjectForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("subject", Subject.findOne(id));
        return request.getRequestDispatcher("/subject/subjectShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("subjects", Subject.findAll());
        return request.getRequestDispatcher("/subject/subjectShowAll.jsp");
    }
}
