package app.forDB;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


//Выводит заказы из БД на сайт
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

            Cookie[] cookies = req.getCookies();
            String cookieUser = "user";
            Cookie cookieUserValue = null;
            String user = "";
            for (Cookie c : cookies) {
                if (cookieUser.equals(c.getName())) {
                    cookieUserValue = c;
                    user = cookieUserValue.getValue();
                }
            }

            //чтение
            String prod = "";
            PreparedStatement pstmt = null;
            pstmt = connection.prepareStatement("select id, product, price from product where user_name= ? and status= ? ");
            pstmt.setString(1,user);
            pstmt.setInt(2, 1);
            pstmt.executeQuery();
            ResultSet resultSet = pstmt.executeQuery();

            int price1 = 0;
            int price_sum = 0;
            String price = "";
            String all_price = "";
            String all_prod = "";
            int id_id = 0;
            String all_id = "";
            while (resultSet.next()) {
                id_id = resultSet.getInt("id");
                prod = resultSet.getString("product");
                price1 = resultSet.getInt("price");
                price_sum = price_sum + price1;
                price =  Integer.toString(price1);
                all_price = all_price + price + "rub;";
                System.out.println(prod);
                all_prod = all_prod + prod + ";";
                all_id += Integer.toString(id_id) + ";";
            }

            String namepr = all_prod + "%" + all_price + "|" + price_sum + "|" + all_id;
            response.getWriter().write(namepr);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
