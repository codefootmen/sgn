package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RoomTypeController", urlPatterns = {"/roomTypes/*"})
public class RoomTypeController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/roomType/roomTypeForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        RoomType roomType = new RoomType()
                .setName(name)
                .setDescription(description);
        RoomType.save(roomType);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        RoomType roomType = new RoomType()
                .setIdRoomType(id)
                .setName(name)
                .setDescription(description);
        RoomType.update(roomType);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        RoomType.delete(Long.valueOf(request.getAttribute("id").toString()));
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("roomType", RoomType.findOne(id));
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/roomTypes/" + id+ "/edit");
        return request.getRequestDispatcher("/roomType/roomTypeForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("roomType", RoomType.findOne(id));
        return request.getRequestDispatcher("/roomType/roomTypeShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("roomTypes", RoomType.findAll());
        return request.getRequestDispatcher("/roomType/roomTypeShowAll.jsp");
    }
}
