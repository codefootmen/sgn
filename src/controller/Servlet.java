package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Servlet extends HttpServlet {

    public abstract RequestDispatcher newPage(HttpServletRequest request);

    public abstract RequestDispatcher editPage(HttpServletRequest request);

    public abstract RequestDispatcher showOnePage(HttpServletRequest request);

    public abstract RequestDispatcher showAllPage(HttpServletRequest request);

    public abstract RequestDispatcher save(HttpServletRequest request);

    public abstract RequestDispatcher update(HttpServletRequest request);

    public abstract RequestDispatcher delete(HttpServletRequest request);

    protected void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getPathInfo();
        if (url == null) {
            url = "/";
        }

        Pattern pattern = Pattern.compile("(^\\/[0-9]+)(\\/edit$)|(\\/new$)|(^\\/[0-9]+$)|(^\\/$)");
        Matcher m = pattern.matcher(url);

        /*
        group 0 = the entire match
        group 1 & 2 = /:id & /edit
        group 3 = /new
        group 4 = /:id
        group 5 - /
        */
        if (m.matches()) {
            if (m.group(1) != null) {
                if (request.getMethod().equals("GET")) {
                    request.setAttribute("id", m.group(1).substring(1));
                    editPage(request).forward(request, response);
                } else {
                    request.setAttribute("id", m.group(1).substring(1));
                    update(request).forward(request, response);
                }
            }
            if (m.group(3) != null) {
                if (request.getMethod().equals("GET")) {
                    newPage(request).forward(request, response);
                } else {
                    save(request).forward(request, response);
                }
            }
            if (m.group(4) != null) {
                if (request.getMethod().equals("GET")) {
                    request.setAttribute("id", url.substring(1));
                    showOnePage(request).forward(request, response);
                } else {
                    request.setAttribute("id", url.substring(1));
                    delete(request).forward(request, response);
                }
            }
            if (m.group(5) != null) {
                showAllPage(request).forward(request, response);
            }
        } else {//Não achou nehuma url
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }
}
