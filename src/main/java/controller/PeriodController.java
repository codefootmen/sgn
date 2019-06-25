package controller;

import model.AccessLevelEnum;
import model.Period;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "PeriodController", urlPatterns = {"/periods/*"})
public class PeriodController extends Servlet {

    private final String redirect = "/periods";


    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.ADMIN;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("rooms", Room.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/periods/new");
        return request.getRequestDispatcher("/period/periodForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        Long idRoom = Long.valueOf(request.getParameter("idRoom"));
        String dayOfTheWeek = request.getParameter("dayOfTheWeek");
        Period period = new Period()
                .setStart(start)
                .setEnd(end)
                .setRoom(Room.findOne(idRoom))
                .setDayOfTheWeek(dayOfTheWeek);
        Period.save(period);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long idPeriod = Long.valueOf(request.getAttribute("id").toString());
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        Long idRoom = Long.valueOf(request.getParameter("idRoom"));
        String dayOfTheWeek = request.getParameter("dayOfTheWeek");
        Period period = new Period()
                .setIdPeriod(idPeriod)
                .setStart(start)
                .setEnd(end)
                .setRoom(Room.findOne(idRoom))
                .setDayOfTheWeek(dayOfTheWeek);
        Period.save(period);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Period.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("period", Period.findOne(id));
        request.setAttribute("rooms", Room.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/periods/" + id + "/edit");
        return request.getRequestDispatcher("/period/periodForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("period", Period.findOne(id));
        return request.getRequestDispatcher("/period/periodShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("periods", Period.findAll());
        return request.getRequestDispatcher("/period/periodShowAll.jsp");
    }
}
