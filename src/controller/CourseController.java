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
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/courses/new");
        return request.getRequestDispatcher("/course/courseForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
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
                .setIdSubject(idSubject)
                .setIdProgram(idProgram)
                .setIdDepartment(idDepartment)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute)
                .setIdPeriod(idPeriod)
                .setIdProfessor(idProfessor);
        course.save();
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
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
                .setIdSubject(idSubject)
                .setIdProgram(idProgram)
                .setIdDepartment(idDepartment)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute)
                .setIdPeriod(idPeriod)
                .setIdProfessor(idProfessor);
        course.update();
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        Course.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/courses/");
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
