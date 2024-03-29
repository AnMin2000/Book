import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class DB {
    public PreparedStatement pstmt;
    Connection conn = null;
    Statement stmt;


    public DB() throws SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/jdbc";
        String dbID = "root";
        String dbPassword = "0000";
        conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
        // 디비 코드
    }
    public void insert(String name, int number, String[] PrName) throws SQLException, ParseException {
        String sql;
        String ValuesVar = "?";

        for (int i = 0; i < number - 1; i++) ValuesVar += ", ?";

        sql = "INSERT INTO " + name + " VALUES (" + ValuesVar + ") ";

        pstmt = conn.prepareStatement(sql);

        
        for (int i = 0; i < PrName.length; i++) {
            pstmt.setString(i + 1, PrName[i]);
        }
        

        // 이건 왜 되는거야? 7열까지 들어가 있으면 8부터 시작을 해야 되는데
        pstmt.executeUpdate();

//        ResultSet rs = pstmt.executeQuery();
//        String columnValue = null;
//        if (rs.next()) {
//            columnValue = rs.getString("id");
//        }
//        System.out.println(columnValue);


        String[] key = new String[]{ "UserID", "UserPassWd", "Username", "Usernumber"};

        StringToJson converter = new StringToJson(key, PrName);
        String jsonString = converter.convertToJsonString();
        // 디비에 넣을 때는 그냥 넣고
        // 디비에서 빼온 String을 Json으로 바꿔서 서버에 던진다.
        // json으로 바꾼거를 다시 String으로 바꿔서 디비에 넣기(?) // 디비 넣기 전에 String -> json 해야 되나?
       // new Client()
        System.out.println(jsonString);
    }

    public ResultSet selectUser(String Id) throws SQLException {
        String sql = "select * from users where id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Id);
        ResultSet rs = pstmt.executeQuery();

        return rs;
    }
    public boolean Overlap(String ID) throws SQLException {

        ResultSet rs = selectUser(ID);

        while (rs.next()) {
            //System.out.println(rs.getString(2));
            if (rs.getString(1).equals(ID)) {
                JOptionPane.showMessageDialog(null, "아이디 중복");
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "사용 가능 아이디");
        return true;
    }


    public boolean Login(String Id, String Pw) throws SQLException {

        ResultSet rs = selectUser(Id);
        while (rs.next()) {
            //System.out.println(rs.getString(2));
            if (rs.getString(2).equals(Pw)) {
                JOptionPane.showMessageDialog(null, "로그인 성공");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "로그인 실패");
        return false;
    }
    public String ServerPrint(String ID) throws SQLException {

        ResultSet rs = selectUser(ID);

        rs.next();
        return rs.getString(1);

    }
}



      //  System.out.println(pstmt);
       // return true;
