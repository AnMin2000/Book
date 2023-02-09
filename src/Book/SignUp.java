package Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUp {
    private JButton button1;
    private JPanel panel1;
    private JTextField NameTextField1;
    private JTextField NumberTextField;
    private JLabel name;
    private JLabel number;
    private JLabel ID;
    private JTextField IDTextField;
    private JButton Login;

    public SignUp(){
        JFrame c = new JFrame();
        c.setSize(300,230);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.add(panel1);
        c.setVisible(true);
        button1.addActionListener(new ActionListener() {
            String name, number, ID;
            @Override
            public void actionPerformed(ActionEvent e) {
               c.dispose();
                try {
                    DB connect = new DB();
                    name = NameTextField1.getText();
                    number = NumberTextField.getText();
                    ID = NumberTextField.getText();

                    connect.pstmt.setString(1, ID);
                    connect.pstmt.setString(2, name);
                    connect.pstmt.setString(3, number);

                    connect.pstmt.executeUpdate();
                    new MainUi(name,number);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }

    public static void main(String args[]){
        new SignUp();
    }


}
