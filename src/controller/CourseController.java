package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "CourseController", urlPatterns = {"/courses/*"})
public class CourseController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("subjects", Subject.findAll());
        request.setAttribute("programs", Program.findAll());
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("periods", Period.findAll());
        request.setAttribute("professors", Professor.findAll());
        return request.getRequestDispatcher("/course/courseForm.jsp");
    }

    @Override
    public RequestDispatcher insert(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/course/courseForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("course", Course.findOne(id));
        return request.getRequestDispatcher("/course/courseShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("courses", Course.findAll());
        return request.getRequestDispatcher("/course/courseShowAll.jsp");
    }
}
