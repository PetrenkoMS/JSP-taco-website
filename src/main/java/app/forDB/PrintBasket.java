package app.forDB;

import javax.servlet.ServletException;
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
//            ResultSet resultSet = statement.executeQuery("select product from product where user_name='Mikhail'");

            PreparedStatement pstmt = null;
            pstmt = connection.prepareStatement("select product, price from product where user_name='Mikhail' and status= ? ");
            pstmt.setInt(1, 1);
            pstmt.executeQuery();
            ResultSet resultSet = pstmt.executeQuery();

            int price1 = 0;
            int price_sum = 0;
            String price = "";
            String all_price = "";
            String all_prod = "";
            while (resultSet.next()) {
                prod = resultSet.getString("product");
                price1 = resultSet.getInt("price");
                price_sum = price_sum + price1;
                price =  Integer.toString(price1);
                all_price = all_price + price + "rub;";
                System.out.println(prod);
                all_prod = all_prod + prod + ";";
            }

//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(prod);
            String namepr = all_prod + "%" + all_price + "|" + price_sum;
            response.getWriter().write(namepr);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
