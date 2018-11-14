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
        return request.getRequestDispatcher("/student/studentForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
        return null;
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
        student.update();
        return request.getRequestDispatcher("/student/studentShowAll.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        return null;
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("student", Student.findOne(id));
        request.setAttribute("activities", Activity.findAll());
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
