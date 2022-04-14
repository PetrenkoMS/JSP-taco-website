package app.forDB;

import org.w3c.dom.ls.LSOutput;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import java.sql.*;


//Регистрация - запись в БД
public class ServletRegistration extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] s = req.getReader().lines().collect(Collectors.joining()).split(",");
        String n_log = s[0];
        String n_pass = s[1];

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
            System.out.println("Connect registr!");

            //чтение
            PreparedStatement pstmt_r = null;
            pstmt_r = connection.prepareStatement("select user_name from user_account where user_name = ?");
            pstmt_r.setString(1,n_log);
            ResultSet resultSet = pstmt_r.executeQuery();
            Boolean logFlag= true;
            while (resultSet.next()) {
                logFlag = false;  //есть такой логин
            }

            if (logFlag) {
                //запись
                PreparedStatement pstmt = null;
                pstmt = connection.prepareStatement(
                        "INSERT INTO user_account (user_name, password) values(?, ?)");
                pstmt.setString(1, n_log);
                pstmt.setString(2, n_pass);
                pstmt.executeUpdate();
            }
            else {
                resp.sendError(500,"Такой логин уже есть, или Вы использовали особые символы  (< \" \' > , )");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

