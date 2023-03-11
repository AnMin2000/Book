package Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class MyServer {

    public MyServer() throws SQLException {
        DB connect = new DB();
        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket serverSocket = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            serverSocket = new ServerSocket(8000);


            System.out.println("[Server실행] Client.연결대기중...");
            //new MyClient();
            socket = serverSocket.accept();			// 연결대기



            System.out.println("Client 연결됨.");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            while(true) {
                //여기 안에서 디비를 불러와서 값이 추가 되면 프린트하기 해주기
                System.out.println("dsfs");

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