package controller;

import model.AccessLevelEnum;
import model.Activity;
import model.RoomType;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StudentController", urlPatterns = {"/students/*"})
public class StudentController extends Servlet {

    private final String redirect = "/students";

    @Override
    public AccessLevelEnum getRequiredAccessLevel() {
        return AccessLevelEnum.PROFESSOR;
    }

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("activities", Activity.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/students/new");
        return request.getRequestDispatcher("/student/studentForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Long idActivity = Long.valueOf(request.getParameter("activity"));
        String email = request.getParameter("email");
        Student student = new Student()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setActivity(Activity.findOne(idActivity));
        Student.save(student);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Long idActivity = Long.valueOf(request.getParameter("activity"));
        String email = request.getParameter("email");
        Student student = new Student()
                .setIdStudent(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setActivity(Activity.findOne(idActivity));
        Student.update(student);

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Student.delete(Long.valueOf(request.getAttribute("id").toString()));

        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("student", Student.findOne(id));
        request.setAttribute("activities", Activity.findAll());
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/students/" + id+ "/edit");
        return request.getRequestDispatcher("/student/studentForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("student", Student.findOne(id));
        return request.getRequestDispatcher("/student/studentShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("students", Student.findAll());
        return request.getRequestDispatcher("/student/studentShowAll.jsp");
    }
}
