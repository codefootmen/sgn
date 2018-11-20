package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;


@WebServlet(name = "ActivityController", urlPatterns = {"/activities/*"})
public class ActivityController extends Servlet {

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.PROFESSOR;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("professors", Professor.findAll());
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("programs", Program.findAll());
        request.setAttribute("activityTypes", EnumSet.allOf(ActivityTypeEnum.class));
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/activities/new");
        return request.getRequestDispatcher("/activity/activityForm.jsp");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("activity", Activity.findOne(id));
        request.setAttribute("professors", Professor.findAll());
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("programs", Program.findAll());
        request.setAttribute("activityTypes", EnumSet.allOf(ActivityTypeEnum.class));
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/activities/" + id+ "/edit");
        return request.getRequestDispatcher("/activity/activityForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("activity", Activity.findOne(id));
        return request.getRequestDispatcher("/activity/activityShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("activities", Activity.findAll());
        return request.getRequestDispatcher("/activity/activityShowAll.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
        String name = request.getParameter("name");
        String area = request.getParameter("area");
        String activityType = request.getParameter("activityType");
        Long professor = Long.parseLong(request.getParameter("idProfessor"));
        Long department = Long.parseLong(request.getParameter("idDepartment"));
        Long campus = Long.parseLong(request.getParameter("idCampus"));
        Long institute = Long.parseLong(request.getParameter("idInstitute"));
        Long program = Long.parseLong(request.getParameter("idProgram"));
        Activity activity = new Activity()
                .setName(name)
                .setArea(area)
                .setActivityType(activityType)
                .setIdProfessor(professor)
                .setIdDepartment(department)
                .setIdCampus(campus)
                .setIdInstitute(institute)
                .setIdProgram(program);
        Activity.save(activity);
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
        Long idActivity = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        String area = request.getParameter("area");
        String activityType = request.getParameter("activityType");
        Long professor = Long.parseLong(request.getParameter("idProfessor"));
        Long department = Long.parseLong(request.getParameter("idDepartment"));
        Long campus = Long.parseLong(request.getParameter("idCampus"));
        Long institute = Long.parseLong(request.getParameter("idInstitute"));
        Long program = Long.parseLong(request.getParameter("idProgram"));
        Activity activity = new Activity()
                .setIdActivity(idActivity)
                .setName(name)
                .setArea(area)
                .setActivityType(activityType)
                .setIdProfessor(professor)
                .setIdDepartment(department)
                .setIdCampus(campus)
                .setIdInstitute(institute)
                .setIdProgram(program);
        Activity.update(activity);
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        Activity.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/activities/");
    }
}
