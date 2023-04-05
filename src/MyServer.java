
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MyServer {
    public PreparedStatement pstmt;
    Connection conn = null;
    private static final int PORT_NUMBER = 4432;
    public MyServer() throws SQLException {

        ServerSocket serverSocket = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try(ServerSocket server = new ServerSocket(PORT_NUMBER)) {
            serverSocket = new ServerSocket(8000);


            System.out.println("[Server실행] Client.연결대기중...");
            //new MyClient();
            String tmp = new SignUp().tmp;
            System.out.println(tmp);
            socket = serverSocket.accept();			// 연결대기


            System.out.println("Client 연결됨.");

            JSONObject response = new JSONObject();

            while(true) {

                Socket connection = server.accept();
                Thread task = new SocketThreadServer(connection);
                task.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                scanner.close();		// Scanner 닫기
                socket.close();			// Socket 닫기
                serverSocket.close();		// ServerSocket 닫기
                System.out.println("연결종료");
            } catch (IOException e) {
                System.out.println("소켓통신에러");
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        new MyServer();
    }
}