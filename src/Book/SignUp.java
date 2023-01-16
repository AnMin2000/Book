package Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {
    private JButton button1;
    private JPanel panel1;
    private JTextField NameTextField1;
    private JTextField NumberTextField;
    private JLabel name;
    private JLabel number;

    public SignUp(){
        JFrame c = new JFrame();
        c.setSize(200,150);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.add(panel1);
        c.setVisible(true);
        button1.addActionListener(new ActionListener() {
            String name, number;
            @Override
            public void actionPerformed(ActionEvent e) {
               c.dispose();
               name = NameTextField1.getText();
               number = NumberTextField.getText();

               new MainUi(name,number);

            }
        });



    }

    public static void main(String args[]){
        new SignUp();
    }
}
