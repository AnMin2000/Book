package Book;
import java.sql.*;
import javax.swing.*;

public class test {


    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String userName = "root";
        String password = "0000";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");

        resultSet.next();
        String name = resultSet.getString("id");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }

}