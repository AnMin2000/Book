
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
import java.util.Map;
import java.util.Scanner;

public class MyServer {
    public MyServer(){
        BufferedReader in = null;

        ServerSocket serverSocket = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            serverSocket = new ServerSocket(8000);


            System.out.println("[Server실행] Client.연결대기중...");

            socket = serverSocket.accept();			// 연결대기


            System.out.println("Client 연결됨.");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true){
                while(in.readLine() != null) {
                   // JSONObject json = new JSONObject();
                   // String message = json.toString();

                    String inputLine = in.readLine();
                    System.out.println(inputLine);
                    JSONParser parser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) parser.parse(inputLine);

                    Object message = jsonObject.get("message");
                    System.out.println("받은 메시지: " + message);
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
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