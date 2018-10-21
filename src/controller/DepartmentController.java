package controller;

import model.Campus;
import model.Department;
import model.Institute;
import model.Professor;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "DepartmentController", urlPatterns = {"/departments/*"})
public class DepartmentController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("professors", Professor.findAll());
        return request.getRequestDispatcher("/department/departmentForm.jsp");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/department/departmentForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("department", Department.findOne(id));
        return request.getRequestDispatcher("/department/departmentShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("departments", Department.findAll());
        return request.getRequestDispatcher("/department/departmentShowAll.jsp");
    }
}
