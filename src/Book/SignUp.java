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

    public int check;

    public SignUp(){
        JFrame c = new JFrame();
        c.setSize(400,230);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.add(panel1);
        c.setVisible(true);
        Overlap.addActionListener(new ActionListener() {
            String ID, PassWd, name, number;
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DB connect = new DB();
                    ID = IDTextField.getText();
                    check = connect.Overlap(ID);
                    if(check == 1) return;

                    SignUpButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ID = IDTextField.getText();
                            PassWd = PassWordTextField.getText();
                            name = NameTextField1.getText();
                            number = NumberTextField.getText();

                            String[] PrArr = new String[]{ID,PassWd,name,number};

                            try {
                                connect.insert("users", 4, PrArr);
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }


                            c.dispose();
                            new MainUi(name,number);
                        }
                    });

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
