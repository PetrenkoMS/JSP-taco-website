package app.forDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.stream.Collectors;

//Авторизация и куки
public class ServletInLog extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] s = req.getReader().lines().collect(Collectors.joining()).split(",");
        String words = String.join(", ", s);
        for (String word : s) {
            System.out.println(word);
        }

        String login=s[0];
        String pass=s[1];
        String sait = "";

        String userName = "root";
        String password = "qwerty123!";
        String connectionUrl="jdbc:mysql://localhost:3306/taco";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            System.out.println("Connect to vhod!");

            PreparedStatement pstmt = null;
            pstmt = connection.prepareStatement("select user_name, password from user_account where user_name= ? and password = ? ");
            pstmt.setString(1, login);
            pstmt.setString(2, pass);
            pstmt.executeQuery();
            ResultSet resultSet = pstmt.executeQuery();

            Boolean logFlag= false;  //неверно введен логин или пароль
            while (resultSet.next()) {
                logFlag = true;  //есть такой логин
            }

            if (logFlag) {
                resp.addCookie(new Cookie("user", login));
                Cookie[] cookies = req.getCookies();
                String cookieSait = "sait";
                Cookie cookieSaitValue = null;
                for (Cookie c : cookies) {
                    if (cookieSait.equals(c.getName())) {
                        cookieSaitValue = c;
                        sait = cookieSaitValue.getValue();
                    }
                }

                if (sait != null) {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(req, resp);
                }
            }
            else {
                resp.sendError(500,"Неверно введен логин или пароль");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
