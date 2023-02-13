package Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Failed {
    private JPanel panel1;
    private JLabel text;
    private JButton button1;

    public Failed() {
        JFrame c = new JFrame();
        c.setSize(300, 230);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.add(panel1);
        c.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.dispose();
            }

        });
    }
}
