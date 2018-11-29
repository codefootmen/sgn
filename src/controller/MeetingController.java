package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MeetingController", urlPatterns = {"/meetings/*"})
public class MeetingController extends Servlet {

    private final String redirect = "/meetings";

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.HEAD;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/meetings/new");
        return request.getRequestDispatcher("/meeting/meetingForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String day = request.getParameter("day");
        String time = request.getParameter("time");
        String agenda = request.getParameter("agenda");
        String minutes = request.getParameter("minutes");
        Long idDepartment = Long.valueOf(request.getParameter("idDepartment"));
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Meeting meeting = new Meeting()
                .setDay(day)
                .setTime(time)
                .setAgenda(agenda)
                .setMinutes(minutes)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute)
                .setIdDepartment(idDepartment);
        Meeting.save(meeting);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long idMeeting = Long.valueOf(request.getAttribute("id").toString());
        String day = request.getParameter("day");
        String time = request.getParameter("time");
        String agenda = request.getParameter("agenda");
        String minutes = request.getParameter("minutes");
        Long idDepartment = Long.valueOf(request.getParameter("idDepartment"));
        Long idCampus = Long.valueOf(request.getParameter("idCampus"));
        Long idInstitute = Long.valueOf(request.getParameter("idInstitute"));
        Meeting meeting = new Meeting()
                .setIdMeeting(idMeeting)
                .setDay(day)
                .setTime(time)
                .setAgenda(agenda)
                .setMinutes(minutes)
                .setIdCampus(idCampus)
                .setIdInstitute(idInstitute)
                .setIdDepartment(idDepartment);
        Meeting.update(meeting);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Meeting.delete(Long.valueOf(request.getAttribute("id").toString()));
        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("meeting", Meeting.findOne(id));
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/meetings/" + id + "/edit");
        return request.getRequestDispatcher("/meeting/meetingForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("meeting", Meeting.findOne(id));
        return request.getRequestDispatcher("/meeting/meetingShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("meetings", Meeting.findAll());
        return request.getRequestDispatcher("/meeting/meetingShowAll.jsp");
    }
}
