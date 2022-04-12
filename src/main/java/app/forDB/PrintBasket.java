package app.forDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


public class PrintBasket extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String userName = "root";
        String password = "qwerty123!";
        String connectionUrl = "jdbc:mysql://localhost:3306/taco";


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            System.out.println("Connect to read!");

            String prod = "";
            //чтение
            ResultSet resultSet = statement.executeQuery("select product from product where user_name='Mikhail'");
            String all_prod = "";
            while (resultSet.next()) {
                prod = resultSet.getString("product");
                System.out.println(prod);
                all_prod = all_prod + prod + ";";
            }
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(prod);
            String namepr = all_prod;
            response.getWriter().write(namepr);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
