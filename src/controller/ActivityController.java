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
        return request.getRequestDispatcher("/activity/activityForm.jsp");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
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
