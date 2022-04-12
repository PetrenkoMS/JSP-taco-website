package app.forDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import java.sql.*;

public class ServletDelBasket extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Enumeration<String> requestDispatcher = req.getAttributeNames();


//        while (requestDispatcher.hasMoreElements()) {
//            String s = requestDispatcher.nextElement();
//            System.out.println("s: "+s);
//        }

        String[] s = req.getReader().lines().collect(Collectors.joining()).split(",");
        String words = String.join(", ", s);
        for (String word : s) {
            System.out.println(word);

        }
        System.out.println(words);

//        JavaToMySQL toDB = new JavaToMySQL();
//        try {
//            toDB.writeProduct();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }




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
            System.out.println("Connect!");
            System.out.println(s[0]);
            System.out.println(words.length());
//            запись
            PreparedStatement pstmt = null;
            pstmt = connection.prepareStatement(
                    "INSERT INTO product (user_name, product, status) values(?, ?, ?)");
            pstmt.setString(1, "Mikhail");
            pstmt.setString(2, words);
            pstmt.setInt(3, 1);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
