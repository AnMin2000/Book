package Book;

import javax.swing.*;

public class test {
    private JTextField textField1;
    private JPanel panel1;

    public test(){
        JFrame c = new JFrame();
        c.setSize(200,150);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.add(panel1);
        c.setVisible(true);
    }
    public static void main(String[] args){
        new test();
    }
}
