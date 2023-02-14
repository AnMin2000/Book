package Book;

import com.mysql.cj.util.StringUtils;

import java.sql.*;

public class DB {
    public PreparedStatement pstmt;
    Connection conn = null;
    Statement stmt;

    public int check;

    public DB() throws SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/jdbc";
        String dbID = "root";
        String dbPassword = "0000";
        conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
    }

    public void insert(String name, int number, String[] PrName) throws SQLException {
        String sql, sql2;
        String ValuesVar = "?";

        SignUp Check = new SignUp();

        for (int i = 0; i < number - 1; i++) ValuesVar += ", ?";



        //if(pstmt2.toString().indexOf(PrName[0])!= -1) System.out.println("good");

        sql = "INSERT INTO " + name + " VALUES (" + ValuesVar + ") ";

        pstmt = conn.prepareStatement(sql);
        for (int i = 0; i < PrName.length; i++)
            pstmt.setString(i + 1, PrName[i]);

        pstmt.executeUpdate();

    }

    public void Overlap(String ID) throws SQLException {
        stmt = conn.createStatement();


        ResultSet rs = stmt.executeQuery("select id from users");
        while (rs.next()) {
            int j = 1;
            if (rs.getString(j).indexOf(ID) != -1) {
                new Failed();
                return;
                // "중복 된 ID입니다" 라고 표현할 수 있는 GUI 생성
            }
            if (StringUtils.isNullOrEmpty(rs.getString(j))) j++;
        }
        new Success();
        return;
    }
}