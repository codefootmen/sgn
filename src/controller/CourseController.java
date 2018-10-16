package controller;

import model.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "CourseController", urlPatterns = {"/courses/*"})
public class CourseController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/course/courseForm.jsp");
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
