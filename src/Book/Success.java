package Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Success {
    private JPanel panel1;
    private JButton button1;
    private JLabel JLabel1;

    public Success() {
        JFrame c = new JFrame();
        c.setSize(170, 100);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLocation(550,180);
        c.add(panel1);
        c.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.dispose();
            }

        });
    }
    public static void main(String []args){
        new Success();
    }
}
