package controller;

import model.Institute;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InstituteController", urlPatterns = {"/institutes/*"})
public class InstituteController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/institute/instituteForm.jsp");
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String site = request.getParameter("site");
        Institute institute = new Institute()
                .setName(name)
                .setSite(site);
        Institute.save(institute);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        Long idInstitute = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        String site = request.getParameter("site");
        Institute institute = new Institute()
                .setIdInstitute(idInstitute)
                .setName(name)
                .setSite(site);
        Institute.update(institute);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Institute.delete(Long.valueOf(request.getAttribute("id").toString()));
    }

    @Override
    public RequestDispatcher editPage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("institute", Institute.findOne(id));
        request.setAttribute("operation", "Edit");
        request.setAttribute("action", "/institutes/" + id + "/edit");
        return request.getRequestDispatcher("/institute/instituteForm.jsp");
    }

    @Override
    public RequestDispatcher showOnePage(HttpServletRequest request) {
        Long id = Long.valueOf(request.getAttribute("id").toString());
        request.setAttribute("institute", Institute.findOne(id));
        return request.getRequestDispatcher("/institute/instituteShowOne.jsp");
    }

    @Override
    public RequestDispatcher showAllPage(HttpServletRequest request) {
        request.setAttribute("institutes", Institute.findAll());
        return request.getRequestDispatcher("/institute/instituteShowAll.jsp");
    }
}
