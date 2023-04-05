import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

public class SocketThreadServer extends Thread {

    private Socket socket;
    public SocketThreadServer(Socket socket){
        this.socket=socket;
    }

    //JSON 데이터 넘기기
    public void run(){
        BufferedReader br = null;
        PrintWriter pw = null;

        try{
            String connIp = socket.getInetAddress().getHostAddress();
            System.out.println(connIp + "에서 연결 시도.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            // 클라이언트에서 보낸 문자열 출력
            String returnMessage = br.readLine();
            System.out.println(returnMessage);

            Gson gson = new Gson();
            JSONObject jo = gson.fromJson(returnMessage, JSONObject.class);
            List<Map<Object, Object>> list = (ArrayList<Map<Object, Object>>) jo.get("list");

            for(int i=0; i<list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
            // 클라이언트에 문자열 전송
            pw.println("수신되었다. 오버!");
            pw.flush();

        }catch(IOException e){
           // logger.error(e);
        }finally{
            try{
                if(pw != null) { pw.close();}
                if(br != null) { br.close();}
                if(socket != null){socket.close();}
            }catch(IOException e){
            }
        }
    }
}