package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;


@WebServlet(name = "SubjectController", urlPatterns = {"/subjects/*"})
public class SubjectController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/subject/subjectForm.jsp");
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
        Subject.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/subjects/");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("subject", Subject.findOne(id));
        request.setAttribute("professors", Professor.findAll());
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("programs", Program.findAll());
        request.setAttribute("roomTypes", RoomType.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/subjects/" + id+ "/edit");
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
