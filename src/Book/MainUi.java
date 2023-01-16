package Book;

import javax.swing.*;

public class MainUi {

    private JPanel panel1;
    private JLabel Title;
    private JTextArea textArea1;


    public MainUi(String name, String number){
        JFrame c = new JFrame();
        c.setSize(500,500);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea1.append(name);
        c.add(panel1);

        c.setVisible(true);
    }
}
