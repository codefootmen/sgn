package controller;

import model.AccessLevelEnum;
import model.PriorityEnum;
import model.Request;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;


@WebServlet(name = "RequestController", urlPatterns = {"/requests/*"})
public class RequestController extends Servlet {

    private final String redirect = "/requests";

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.PROFESSOR;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("priorities", EnumSet.allOf(PriorityEnum.class));
        request.setAttribute("rooms", Room.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/requests/new");
        return request.getRequestDispatcher("/request/requestForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String motive = request.getParameter("motive");
        String description = request.getParameter("description");
        String priority = request.getParameter("priority");
        Long idRoom = Long.valueOf(request.getParameter("room"));
        Request systemRequest = new Request()
                .setMotive(motive)
                .setDescription(description)
                .setPriority(priority)
                .setRoom(Room.findOne(idRoom));
        Request.save(systemRequest);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        String motive = request.getParameter("motive");
        String description = request.getParameter("description");
        String priority = request.getParameter("priority");
        Long idRoom = Long.valueOf(request.getParameter("room"));
        Request systemRequest = new Request()
                .setIdRequest(id)
                .setMotive(motive)
                .setDescription(description)
                .setPriority(priority)
                .setRoom(Room.findOne(idRoom));
        systemRequest.update(systemRequest);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Request.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("request", Request.findOne(id));
        request.setAttribute("priorities", EnumSet.allOf(PriorityEnum.class));
        request.setAttribute("rooms", Room.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/requests/" + id+ "/edit");
        return request.getRequestDispatcher("/request/requestForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("request", Request.findOne(id));
        return request.getRequestDispatcher("/request/requestShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("requests", Request    .findAll());
        return request.getRequestDispatcher("/request/requestShowAll.jsp");
    }
}
