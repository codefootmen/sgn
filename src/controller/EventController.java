package controller;

import model.Event;
import model.Period;
import model.Professor;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "EventController", urlPatterns = {"/events/*"})
public class EventController extends Servlet {

    private final String redirect = "/events";

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("periods", Period.findAll());
        request.setAttribute("professors", Professor.findAll());
        request.setAttribute("rooms", Room.findAll());
        return request.getRequestDispatcher("/event/eventForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
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

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
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

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Event.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
