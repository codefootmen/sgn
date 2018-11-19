package controller;

import model.Campus;
import model.Department;
import model.Institute;
import model.Meeting;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "MeetingController", urlPatterns = {"/meetings/*"})
public class MeetingController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("departments", Department.findAll());
        request.setAttribute("campi", Campus.findAll());
        request.setAttribute("institutes", Institute.findAll());
        return request.getRequestDispatcher("/meeting/meetingForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
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
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
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
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        Meeting.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/meetings/");
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
