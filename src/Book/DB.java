package Book;

import java.sql.*;

public class DB {
    public PreparedStatement pstmt;
    Connection conn = null;

    public DB() throws SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/jdbc";
        String dbID = "root";
        String dbPassword = "0000";
        conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
    }
    public void insert(String name, int number, String[] PrName) throws SQLException {
        String ValuesVar = null;
        for (int i = 0; i < number; i++) {
            if (i == 0) ValuesVar = "?, ";
            else if (i == number - 1) ValuesVar += "?";
            else ValuesVar += "?, ";
        }

        String sql = "INSERT INTO " + name + " VALUES ("+ValuesVar+") ";

        pstmt = conn.prepareStatement(sql);

        for(int i =0; i<PrName.length; i++)
            pstmt.setString(i+1, PrName[i]);

        pstmt.executeUpdate();

    }
}