package controller;

import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "RoomController", urlPatterns = {"/rooms/*"})
public class RoomController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/room/roomForm.jsp");
    }

    @Override
    public RequestDispatcher insert(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/room/roomForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("room", Room.findOne(id));
        return request.getRequestDispatcher("/room/roomShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("rooms", Room.findAll());
        return request.getRequestDispatcher("/room/roomShowAll.jsp");
    }
}
