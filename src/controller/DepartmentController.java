package controller;

import model.Campus;
import model.Department;
import model.Institute;
import model.Professor;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("department", Department.findOne(id));
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("professors", Professor.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/departments/" + id + "/edit");
        return request.getRequestDispatcher("/department/departmentForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String field = request.getParameter("field");
        String description = request.getParameter("description");
        Long idProfessor = Long.valueOf(request.getParameter("idProfessor"));
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Department department = new Department()
                .setField(field)
                .setDescription(description)
                .setIdProfessor(idProfessor)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute);
        Department.save(department);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long idDepartment = Long.valueOf(request.getAttribute("id").toString());
        String field = request.getParameter("field");
        String description = request.getParameter("description");
        Long idProfessor = Long.valueOf(request.getParameter("idProfessor"));
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Department department = new Department()
                .setIdDepartment(idDepartment)
                .setField(field)
                .setDescription(description)
                .setIdProfessor(idProfessor)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute);
        Department.update(department);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Department.delete(Long.valueOf(request.getAttribute("id").toString()));
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
