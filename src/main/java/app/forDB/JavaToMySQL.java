package app.forDB;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.*;

public class JavaToMySQL {

    public static void main(String[]args) throws ClassNotFoundException {
        String userName = "root";
        String password = "qwerty123!";
        String connectionUrl="jdbc:mysql://localhost:3306/taco";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
                Statement statement = connection.createStatement()) {
            System.out.println("Connect!");
            //запись
            statement.executeUpdate("insert into product (user_name, product, status) value('Tacoman', 'kura, pineapple', 1)");

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
//
//           System.out.println("-------------------");
////            String User_name = "Tacoman";
////            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_account where id = ?");
////            preparedStatement.setString(1, User_name);
////            ResultSet resultSet2 = preparedStatement.executeQuery();
////            while (resultSet2.next()) {
////                System.out.println(resultSet2.getString(1));
////            }




        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

}