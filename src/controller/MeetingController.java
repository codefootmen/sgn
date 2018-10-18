package controller;

import model.Meeting;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "MeetingController", urlPatterns = {"/meetings/*"})
public class MeetingController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/meeting/meetingForm.jsp");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
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
