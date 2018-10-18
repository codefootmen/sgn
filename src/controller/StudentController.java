package controller;

import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "StudentController", urlPatterns = {"/students/*"})
public class StudentController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/student/studentForm.jsp");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/student/studentForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("student", Student.findOne(id));
        return request.getRequestDispatcher("/student/studentShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("students", Student.findAll());
        return request.getRequestDispatcher("/student/studentShowAll.jsp");
    }
}
