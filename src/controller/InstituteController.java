package controller;

import model.Institute;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "InstituteController", urlPatterns = {"/institutes/*"})
public class InstituteController extends Servlet {

    @Override
    public RequestDispatcher newPage(HttpServletRequest request) {
        return request.getRequestDispatcher("/institute/instituteForm.jsp");
    }

    @Override
    public RequestDispatcher save(HttpServletRequest request) {
        String name = request.getParameter("name");
        String site = request.getParameter("site");
        Institute institute = new Institute()
                .setName(name)
                .setSite(site);
        Institute.save(institute);
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher update(HttpServletRequest request) {
        Long idInstitute = Long.valueOf(request.getAttribute("id").toString());
        String name = request.getParameter("name");
        String site = request.getParameter("site");
        Institute institute = new Institute()
                .setIdInstitute(idInstitute)
                .setName(name)
                .setSite(site);
        Institute.update(institute);
        return request.getRequestDispatcher("/index.jsp");
    }

    @Override
    public RequestDispatcher delete(HttpServletRequest request) {
        Institute.delete(Long.valueOf(request.getAttribute("id").toString()));
        return request.getRequestDispatcher("/institutes/");
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
