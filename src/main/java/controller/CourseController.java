package controller;

import model.*;
import report.ProfessorReport;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CourseController", urlPatterns = {"/courses/*"})
public class CourseController extends Servlet {

    private final String redirect = "/courses";

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.HEAD;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("subjects", Subject.findAll());
        request.setAttribute("programs", Program.findAll());
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("periods", Period.findAll());
        request.setAttribute("professors", Professor.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/courses/new");
        return request.getRequestDispatcher("/course/courseForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        Boolean semester = Boolean.valueOf(request.getParameter("semester"));
        Integer year = Integer.valueOf(request.getParameter("year"));
        Long idSubject = Long.valueOf(request.getParameter("idSubject"));
        Long idProgram = Long.valueOf(request.getParameter("idProgram"));
        Long idDepartment = Long.valueOf(request.getParameter("idDepartment"));
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Long idPeriod = Long.valueOf(request.getParameter("idPeriod"));
        Long idProfessor = Long.valueOf(request.getParameter("idProfessor"));
        Course course = new Course()
                .setSemester(semester)
                .setYear(year)
                .setSubject(Subject.findOne(idSubject))
                .setProgram(Program.findOne(idProgram))
                .setDepartment(Department.findOne(idDepartment))
                .setCampus(Campus.findOne(idCampus))
                .setInstitute(Institute.findOne(idInstitute))
                .setPeriod(Period.findOne(idPeriod))
                .setProfessor(Professor.findOne(idProfessor));
        Course.save(course);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        Boolean semester = Boolean.valueOf(request.getParameter("semester"));
        Integer year = Integer.valueOf(request.getParameter("year"));
        Long idSubject = Long.valueOf(request.getParameter("idSubject"));
        Long idProgram = Long.valueOf(request.getParameter("idProgram"));
        Long idDepartment = Long.valueOf(request.getParameter("idDepartment"));
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Long idPeriod = Long.valueOf(request.getParameter("idPeriod"));
        Long idProfessor = Long.valueOf(request.getParameter("idProfessor"));
        Course course = new Course()
                .setIdCourse(id)
                .setSemester(semester)
                .setYear(year)
                .setSubject(Subject.findOne(idSubject))
                .setProgram(Program.findOne(idProgram))
                .setDepartment(Department.findOne(idDepartment))
                .setCampus(Campus.findOne(idCampus))
                .setInstitute(Institute.findOne(idInstitute))
                .setPeriod(Period.findOne(idPeriod))
                .setProfessor(Professor.findOne(idProfessor));
        Course.update(course);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Course.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("course", Course.findOne(id));
        request.setAttribute("subjects", Subject.findAll());
        request.setAttribute("programs", Program.findAll());
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("periods", Period.findAll());
        request.setAttribute("professors", Professor.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/courses/" + id + "/edit");
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
