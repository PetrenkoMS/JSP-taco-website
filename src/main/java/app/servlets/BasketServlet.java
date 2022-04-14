package app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import static java.lang.Thread.sleep;

public class BasketServlet extends HttpServlet {

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
        resp.addCookie(new Cookie("sait", "basket"));

        if (cookieLogOnValue != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/basket.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("jsp/logOn.jsp");
            requestDispatcher1.forward(req, resp);
        }
    }
}
