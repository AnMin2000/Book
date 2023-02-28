package Book;

import com.mysql.cj.util.StringUtils;

import javax.swing.*;
import java.sql.*;

public class DB {
    public PreparedStatement pstmt;
    Connection conn = null;
    Statement stmt;



    public DB() throws SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/jdbc";
        String dbID = "root";
        String dbPassword = "0000";
        conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
    }

    public void insert(String name, int number, String[] PrName) throws SQLException {
        String sql;
        String ValuesVar = "?";

        for (int i = 0; i < number - 1; i++) ValuesVar += ", ?";

        sql = "INSERT INTO " + name + " VALUES (" + ValuesVar + ") ";

        pstmt = conn.prepareStatement(sql);
        for (int i = 0; i < PrName.length; i++)
            pstmt.setString(i + 1, PrName[i]);

        pstmt.executeUpdate();

    }

    public int Overlap(String ID) throws SQLException {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id from users");
        int j = 1;

        while (rs.next()) {
            if (rs.getString(j).indexOf(ID) != -1) {
                new Failed();
                return 1;
                // "중복 된 ID입니다" 라고 표현할 수 있는 GUI 생성
            }
            if (StringUtils.isNullOrEmpty(rs.getString(j))) j++;
        }
        new Success();
        return 2;
    }
    public boolean Login(String Id, String Pw) throws SQLException {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id from users");
        int j = 1;

        while (rs.next()) {
            if (rs.getString(j).indexOf(Id) != -1 && rs.getString(j).indexOf(Pw) != -1) {
                JOptionPane.showMessageDialog(null, "로그인 실패");
                return false;
            }
            if (StringUtils.isNullOrEmpty(rs.getString(j))) j++;
        }
        JOptionPane.showMessageDialog(null, "로그인 성공");
        return true;
    }
}
