package Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class MyClient {
    public MyClient() {
        BufferedReader in = null;
        PrintWriter out = null;

        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

            try {
                socket = new Socket("127.0.0.1", 8000);
                DB connect = new DB();

                System.out.print("연결완료");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
    public static void main(String[] args) {
        new MyClient();
    }
}