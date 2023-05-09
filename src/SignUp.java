import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {
    private JButton SignUpButton;
    private JPanel panel1;
    private JTextField NameTextField1;
    private JTextField NumberTextField;
    private JLabel name;
    private JLabel number;
    private JLabel ID;
    private JTextField IDTextField;
    private JButton Overlap;
    private JLabel PassWord;
    private JTextField PassWordTextField;
    String UserID, UserPassWd, Username, Usernumber;
    public String tmp;

    public boolean check;
    PreparedStatement pstmt;
    Connection conn = null;
    PrintWriter out = null;
    Socket socket = null;
    public SignUp() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);

        socket = new Socket("127.0.0.1", 8000);
        out = new PrintWriter(socket.getOutputStream());
        String outputMessage = scanner.nextLine();
        //서버
        DB connect = new DB();
        //디비

        JFrame c = new JFrame();
        c.setSize(400,230);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLocation(550,180);
        c.add(panel1);
        c.setVisible(true);

        Overlap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserID = IDTextField.getText();
                    check = connect.Overlap(UserID);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        SignUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(check == false) return;

                UserID = IDTextField.getText();
                UserPassWd = PassWordTextField.getText();
                Username = NameTextField1.getText();
                Usernumber = NumberTextField.getText();

                String[] PrArr = new String[]{UserID,UserPassWd,Username,Usernumber};
                out.println(PrArr);
                out.flush();

//                try {
//                    connect.insert("users", 4, PrArr);
//
//                     c.dispose();
//                    new LoginUi();
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                } catch (ParseException ex) {
//                    throw new RuntimeException(ex);
//                }
//

            }
        });

    }
    public static void main(String args[]) throws SQLException, IOException {
         new SignUp();
    }
}
