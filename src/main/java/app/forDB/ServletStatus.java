package app.forDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.stream.Collectors;

public class ServletStatus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String words = req.getReader().lines().collect(Collectors.joining());
        System.out.println(words);


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
            System.out.println("Connect to status");
            //            запись
            PreparedStatement pstmt = null;
            pstmt = connection.prepareStatement("Update product set status = 0 where user_name = 'Mikhail' and status = 1");

//            pstmt.setString(1, words);

            System.out.println(pstmt);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
