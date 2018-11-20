package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "EventController", urlPatterns = {"/events/*"})
public class EventController extends Servlet {

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.PROFESSOR;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("periods", Period.findAll());
        request.setAttribute("professors", Professor.findAll());
        request.setAttribute("rooms", Room.findAll());
        return request.getRequestDispatcher("/event/eventForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        Long idPeriod = Long.valueOf(request.getParameter("idPeriod"));
        Long idProfessor = Long.valueOf(request.getParameter("idProfessor"));
        Long idRoom = Long.valueOf(request.getParameter("idRoom"));
        Event event = new Event()
                .setName(name)
                .setDate(date)
                .setIdPeriod(idPeriod)
                .setIdProfessor(idProfessor)
                .setIdRoom(idRoom);
        Event.save(event);
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
        Long idEvent = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        Long idPeriod = Long.valueOf(request.getParameter("idPeriod"));
        Long idProfessor = Long.valueOf(request.getParameter("idProfessor"));
        Long idRoom = Long.valueOf(request.getParameter("idRoom"));
        Event event = new Event()
                .setIdEvent(idEvent)
                .setName(name)
                .setDate(date)
                .setIdPeriod(idPeriod)
                .setIdProfessor(idProfessor)
                .setIdRoom(idRoom);
        Event.update(event);
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        Event.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/events/");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("event", Event.findOne(id));
        request.setAttribute("periods", Period.findAll());
        request.setAttribute("professors", Professor.findAll());
        request.setAttribute("rooms", Room.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/events/" + id + "/edit");
        return request.getRequestDispatcher("/event/eventForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("event", Event.findOne(id));
        return request.getRequestDispatcher("/event/eventShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("events", Event.findAll());
        return request.getRequestDispatcher("/event/eventShowAll.jsp");
    }
}
