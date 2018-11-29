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

@WebServlet(name = "DashboardController", urlPatterns = {"/dashboard/*"})
public class DashboardController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("numberOfProfessors", Professor.findAll().size());
        request.setAttribute("numberOfStudents", Student.findAll().size());
        request.setAttribute("numberOfEvents", Event.findAll().size());
        request.setAttribute("numberOfCourses", Course.findAll().size());
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }

}