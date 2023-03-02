package Book;

import com.mysql.cj.protocol.Resultset;
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
        // 이건 왜 되는거야? 7열까지 들어가 있으면 8부터 시작을 해야 되는데
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

        String sql = "select * from users where id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println(rs.getString(2));
            if (rs.getString(2).equals(Pw)) {
                JOptionPane.showMessageDialog(null, "로그인 성공");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "로그인 실패");
        return false;
    }
}


      //  System.out.println(pstmt);
       // return true;
