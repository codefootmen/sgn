package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Optional;


@WebServlet(name = "RoomController", urlPatterns = {"/rooms/*"})
public class RoomController extends Servlet {

    private final String redirect = "/rooms";

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.ADMIN;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("roomTypes", RoomType.findAll());
        request.setAttribute("buildings", Building.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/rooms/new");
        return request.getRequestDispatcher("/room/roomForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        Integer number = Integer.valueOf(request.getParameter("number"));
        Integer quantityOfSeats = Integer.valueOf(request.getParameter("quantityOfSeats"));
        Long roomType = Long.valueOf(request.getParameter("roomType"));
        Long building = Long.valueOf(request.getParameter("building"));
        Room room = new Room()
                .setNumber(number)
                .setQuantityOfSeats(quantityOfSeats)
                .setRoomType(RoomType.findOne(roomType))
                .setBuilding(Building.findOne(building));

        Optional<Room> r = Room.save(room);

//        for(int i = 0; i < 7; i++){
//            for(int j = 0; j < 11; j++){
//                Period p = new Period()
//                        .setDayOfTheWeek(String.valueOf(i))
//                        .setStart(String.valueOf(j))
//                        .setEnd(String.valueOf(j+1))
//                        .setIdRoom(r.get().getIdRoom());
//                Period.save(p);
//            }
//        }


        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        Integer number = Integer.valueOf(request.getParameter("number"));
        Integer quantityOfSeats = Integer.valueOf(request.getParameter("quantityOfSeats"));
        Long roomType = Long.valueOf(request.getParameter("roomType"));
        Long building = Long.valueOf(request.getParameter("building"));
        Room room = new Room()
                .setIdRoom(id)
                .setNumber(number)
                .setQuantityOfSeats(quantityOfSeats)
                .setRoomType(RoomType.findOne(roomType))
                .setBuilding(Building.findOne(building));
        Room.update(room);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Room.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
