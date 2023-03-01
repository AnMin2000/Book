package Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginUi {
    private JPanel JPanel1;
    private JLabel IdLabel;
    private JLabel PwLabel;
    private JTextField IdTextField;
    private JTextField PwTextField;
    private JButton LoginButton;

    public LoginUi(){
        JFrame c = new JFrame();
        c.setSize(400,230);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLocation(550,180);
        c.add(JPanel1);
        c.setVisible(true);

        LoginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String UserId = IdTextField.getText();
                    String UserPw = PwTextField.getText();


                    //MyServer를 어디에 둬야할지 모르겟음 알아보는중
                    DB connect = new DB();
                    boolean state = connect.Login(UserId, UserPw);

                    if(state == true){
                        new MyClient();
                        new MainUi("안민","123123");
                    }
                   else {
                       return;
                   }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args){
        new LoginUi();
    }
}
