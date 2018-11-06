package controller;

import model.RoomType;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "RoomTypeController", urlPatterns = {"/roomTypes/*"})
public class RoomTypeController extends Servlet {

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
        return null;
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
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
