package controller;

import model.Institution;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "InstitutionController", urlPatterns = {"/institutions/*"})
public class InstitutionController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/institution/institutionForm.jsp");
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/institution/institutionForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("institute", Institution.findOne(id));
        return request.getRequestDispatcher("/institution/institutionShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("institutes", Institution.findAll());
        return request.getRequestDispatcher("/institution/institutionShowAll.jsp");
    }
}
