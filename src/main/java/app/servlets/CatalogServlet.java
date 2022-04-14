package app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        String cookieLogOn = "user";
        Cookie cookieLogOnValue = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (cookieLogOn.equals(c.getName())) {
                    cookieLogOnValue = c;
                }
            }
        }

        String cookieSait = "sait";
        resp.addCookie(new Cookie("sait", "catalog"));
        if (cookieLogOnValue != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/catalog.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("jsp/logOn.jsp");
            requestDispatcher1.forward(req, resp);
        }
    }
}