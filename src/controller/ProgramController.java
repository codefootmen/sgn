package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.EnumSet;


@WebServlet(name = "ProgramController", urlPatterns = {"/programs/*"})
public class ProgramController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("levels", EnumSet.allOf(AcademicLevelEnum.class));
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/programs/new");
        return request.getRequestDispatcher("/program/programForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Long idDepartment = Long.valueOf(request.getParameter("idDepartment"));
        String academicLevel = request.getParameter("academicLevel");
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Program program = new Program()
                .setName(name)
                .setIdDepartment(idDepartment)
                .setAcademicLevel(academicLevel)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute);
        Program.save(program);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long idProgram = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        Long idDepartment = Long.valueOf(request.getParameter("idDepartment"));
        String academicLevel = request.getParameter("academicLevel");
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Program program = new Program()
                .setIdProgram(idProgram)
                .setName(name)
                .setIdDepartment(idDepartment)
                .setAcademicLevel(academicLevel)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute);
        Program.update(program);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Program.delete(Long.valueOf(request.getAttribute("id").toString()));
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("program", Program.findOne(id));
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("levels", EnumSet.allOf(AcademicLevelEnum.class));
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/programs/" + id + "/edit");
        return request.getRequestDispatcher("/program/programForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("program", Program.findOne(id));
        return request.getRequestDispatcher("/program/programShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("programs", Program.findAll());
        return request.getRequestDispatcher("/program/programShowAll.jsp");
    }
}
