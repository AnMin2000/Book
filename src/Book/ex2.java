package Book;

import javax.swing.*;

public class ex2 {

    private JButton button1;
    private JPanel panel1;
    public ex2(){
        JFrame c = new JFrame();
        c.setSize(500,500);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.add(panel1);
        c.setVisible(true);
    }
}
