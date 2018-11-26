package controller;

import model.Activity;
import model.RoomType;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name = "StudentController", urlPatterns = {"/students/*"})
public class StudentController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        request.setAttribute("activities", Activity.findAll());
        request.setAttribute("operation", "New");
        request.setAttribute("action", "/students/new");
        return request.getRequestDispatcher("/student/studentForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Long idActivity = Long.valueOf(request.getParameter("activity"));
        String email = request.getParameter("email");
        Student student = new Student()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setIdActivity(idActivity);
        Student.save(student);
        return request.getRequestDispatcher("/student/studentShowAll.jsp");
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
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
                .setIdActivity(idActivity);
        Student.update(student);
        return request.getRequestDispatcher("/student/studentShowAll.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        Student.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/students/");
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
