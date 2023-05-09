import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client () {
        PrintWriter out = null;

        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new Socket("127.0.0.1", 8000);
            out = new PrintWriter(socket.getOutputStream());

            System.out.print("전송하기>>> ");
            String outputMessage = scanner.nextLine();
            out.println(outputMessage);
            out.flush();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                scanner.close();
                if (socket != null) socket.close();
                System.out.println("서버연결종료");
            } catch (IOException e) {
                System.out.println("소켓통신에러");
            }
        }
    }
}
