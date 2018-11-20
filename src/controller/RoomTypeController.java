package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "RoomTypeController", urlPatterns = {"/roomTypes/*"})
public class RoomTypeController extends Servlet {

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.ADMIN;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/roomType/roomTypeForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        RoomType roomType = new RoomType()
                .setIdRoomType(id)
                .setName(name)
                .setDescription(description);
        roomType.update();
        return request.getRequestDispatcher("/roomType/roomTypeShowAll.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        RoomType.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/roomTypes/");
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
