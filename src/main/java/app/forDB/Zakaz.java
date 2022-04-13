package app.forDB;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import java.sql.*;


//читает чекбоксы и записывает в БД заказ и цену
public class Zakaz extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String[] s = req.getReader().lines().collect(Collectors.joining()).split(",");
        String words = String.join(", ", s);
        String word1 = "";
        int pay1 = 0;
        for (String word : s) {
            System.out.println(word);
            String[] pay = word.split("%");
            word1= word1 + pay[0] + ", ";
            pay1 = pay1 + Integer.parseInt(pay[1]);

        }
        word1= word1.substring(0,word1.length()-2);
        System.out.println(words);
        System.out.println("!!!!!!!!!!!!!!");
        System.out.println(word1);
        System.out.println(pay1);


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
            pstmt = connection.prepareStatement(
                    "INSERT INTO product (user_name, product, status, price) values(?, ?, ?, ?)");
            pstmt.setString(1, user);
            pstmt.setString(2, word1);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, pay1);
            pstmt.executeUpdate();
//            statement.executeUpdate("insert into product (user_name, product, status) value('Mikhail'," + words + ", 1)");
//            statement.executeUpdate("insert into product (user_name, product, status) value('Mikhail', 'some tasty' , 1)");

//            String pass = new String();
//            //чтение
//            ResultSet resultSet = statement.executeQuery("select * from user_account");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1)); //или вместо 1 имя столбца
//
//                pass=resultSet.getString(2);
//                System.out.println(pass);
//            }
//
//            ResultSet rs2 = statement.executeQuery("select user_name from user_account where password='123'");
//            while (rs2.next()) {
//                System.out.println(rs2.getString(1));
//            }

            System.out.println("-------------------");
//            String User_name = "Tacoman";
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_account where id = ?");
//            preparedStatement.setString(1, User_name);
//            ResultSet resultSet2 = preparedStatement.executeQuery();
//            while (resultSet2.next()) {
//                System.out.println(resultSet2.getString(1));
//            }




        }
        catch (SQLException e) {
            e.printStackTrace();
        }



    }





}




