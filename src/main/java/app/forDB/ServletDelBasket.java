package app.forDB;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import java.sql.*;


//Удаляет запись -- заказ удаляется
public class ServletDelBasket extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Enumeration<String> requestDispatcher = req.getAttributeNames();


//        while (requestDispatcher.hasMoreElements()) {
//            String s = requestDispatcher.nextElement();
//            System.out.println("s: "+s);
//        }

        String id_ids = req.getReader().lines().collect(Collectors.joining());
        System.out.println(id_ids);
        int id_id = Integer.parseInt(id_ids);


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
            System.out.println("Connect to del");

            Cookie[] cookies = req.getCookies();
            String cookieUser = "user";
            Cookie cookieUserValue = null;
            String user = "";
            for (Cookie c : cookies) {
                if (cookieUser.equals(c.getName())) {
                    cookieUserValue = c;
                    System.out.println();
                    System.out.println("user cookie: " + cookieUserValue.getValue());
                    user = cookieUserValue.getValue();
                }
            }

            //            запись
            PreparedStatement pstmt = null;
            pstmt = connection.prepareStatement("Delete from product where id = ?");
//            pstmt = connection.prepareStatement(
//                    "CREATE TABLE t_temp as SELECT * FROM product Where user_name='Mikhail' and product= ? ;" + "\n" +
//                            "Select count(*) from taco.t_temp;");

            pstmt.setInt(1,id_id);
            System.out.println(pstmt);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
