package Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex1 {
    private JButton button1;
    private JPanel panel1;
    private JTextField textField1;

    public ex1(){
        JFrame c = new JFrame();
        c.setSize(500,500);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.dispose();
                new ex2();
            }
        });
        c.add(panel1);

        c.setVisible(true);
    }

    public static void main(String args[]){
        new ex1();
    }
}
