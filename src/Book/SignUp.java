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
                    connect.Overlap(ID);

                    SignUpButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            c.dispose();
                            try {
                                c.dispose();
                                DB connect = new DB();
                                ID = IDTextField.getText();
                                PassWd = PassWordTextField.getText();
                                name = NameTextField1.getText();
                                number = NumberTextField.getText();

                                String[] PrArr = new String[]{ID,PassWd,name,number};

                                connect.insert("users", 4, PrArr);

                                c.dispose();
                                new MainUi(name,number);
                                c.dispose();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                           // if(check == -1) new Failed(); // 이거 다시해야 됨 안 먹힘 *textfield에 넣자마다 중복 확인을 누르면 되는지 체크*

                           // new MainUi(name,number);
                            c.dispose();
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
