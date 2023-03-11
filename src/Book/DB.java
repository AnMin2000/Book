package Book;

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
    public void sever(){
        try {
            BufferedReader in = null;
            PrintWriter out = null;

            Socket socket = null;
            Scanner scanner = new Scanner(System.in);

            socket = new Socket("127.0.0.1", 8000);

            System.out.print("연결완료");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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

    public boolean Overlap(String ID) throws SQLException {
        String sql = "select * from users where id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, ID);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
//            System.out.println(rs.getString(2));
            if (rs.getString(1).equals(ID)) {
                JOptionPane.showMessageDialog(null, "아이디 중복");
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "사용 가능 아이디");
        return true;
    }

    public boolean Login(String Id, String Pw) throws SQLException {

        String sql = "select * from users where id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Id);
        ResultSet rs = pstmt.executeQuery();
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
}


      //  System.out.println(pstmt);
       // return true;
