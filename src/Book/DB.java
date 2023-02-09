package Book;

import javax.swing.*;
import java.sql.*;

public class DB {
    Connection conn = null;
    PreparedStatement pstmt = null;
    public DB() throws SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/jdbc";
        String dbID = "root";
        String dbPassword = "0000";
        conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);

        String sql = "INSERT INTO " + dbID + " VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);

       // pstmt.executeUpdate();
    }
}