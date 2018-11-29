package controller;

import model.Course;
import model.Event;
import model.Professor;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardController", urlPatterns = {"/dashboard/*"})
public class DashboardController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("access_level") == null) {
            response.sendRedirect("/authentication");
        } else {
            List<Event> e = Event.findAll();
            request.setAttribute("numberOfProfessors", Professor.findAll().size());
            request.setAttribute("numberOfStudents", Student.findAll().size());
            request.setAttribute("numberOfEvents", e.size());
            request.setAttribute("numberOfCourses", Course.findAll().size());
            request.setAttribute("events", e);
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
        }
    }

}
