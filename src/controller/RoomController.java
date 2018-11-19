package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;


@WebServlet(name = "RoomController", urlPatterns = {"/rooms/*"})
public class RoomController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/room/roomForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
        Integer number = Integer.valueOf(request.getParameter("number"));
        Integer quantityOfSeats = Integer.valueOf(request.getParameter("quantityOfSeats"));
        Long roomType = Long.valueOf(request.getParameter("roomType"));
        Long building = Long.valueOf(request.getParameter("building"));
        Room room = new Room()
                .setNumber(number)
                .setQuantityOfSeats(quantityOfSeats)
                .setIdRoomType(roomType)
                .setIdBuilding(building);
        Room.save(room);
        return request.getRequestDispatcher("/room/roomShowAll.jsp");
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        Integer number = Integer.valueOf(request.getParameter("number"));
        Integer quantityOfSeats = Integer.valueOf(request.getParameter("quantityOfSeats"));
        Long roomType = Long.valueOf(request.getParameter("roomType"));
        Long building = Long.valueOf(request.getParameter("building"));
        Room room = new Room()
                .setIdRoom(id)
                .setNumber(number)
                .setQuantityOfSeats(quantityOfSeats)
                .setIdRoomType(roomType)
                .setIdBuilding(building);
        Room.update(room);
        return request.getRequestDispatcher("/room/roomShowAll.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        Room.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/rooms/");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("room", Room.findOne(id));
        request.setAttribute("roomTypes", RoomType.findAll());
        request.setAttribute("buildings", Building.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/rooms/" + id+ "/edit");
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
