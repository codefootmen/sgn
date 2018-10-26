package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;


@WebServlet(name = "ActivityController", urlPatterns = {"/activities/*"})
public class ActivityController extends Servlet {

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
    public RequestDispatcher insert(HttpServletRequest request) {
        String name = request.getParameter("name");
        String area = request.getParameter("area");
        String activityType = request.getParameter("activityType");
        String professor = request.getParameter("professor");
        String department = request.getParameter("department");
        String campus = request.getParameter("campus");
        String institute = request.getParameter("institute");
        String program = request.getParameter("program");
        Activity activity = new Activity()
                .setName(name)
                .setArea(area)
                .setActivityType(activityType)
                .setProfessor(Professor.findOne(Long.parseLong(professor)))
                .setDepartment(Department.findOne(Long.parseLong(department)))
                .setCampus(Campus.findOne(Long.parseLong(campus)))
                .setInstitute(Institute.findOne(Long.parseLong(institute)))
                .setProgram(Program.findOne(Long.parseLong(program)));
        Activity.save(activity);
        return request.getRequestDispatcher("/index.jsp");
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
        request.setAttribute("action", "/activities/" + id);
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
}
