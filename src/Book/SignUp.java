package Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

    public int check;

    public SignUp(){
        JFrame c = new JFrame();
        
        c.setSize(400,230);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.add(panel1);
        c.setVisible(true);
        
        Overlap.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DB connect = new DB();
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
                if(check == 1) return;

                UserID = IDTextField.getText();
                UserPassWd = PassWordTextField.getText();
                Username = NameTextField1.getText();
                Usernumber = NumberTextField.getText();

                String[] PrArr = new String[]{UserID,UserPassWd,Username,Usernumber};

                try {
                    DB connect = new DB();
                    connect.insert("users", 4, PrArr);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                
                new MainUi(Username,Usernumber);
                c.dispose();
            }
        });

    }
    public static void main(String args[]){
         SignUp S = new SignUp();
    }
}
