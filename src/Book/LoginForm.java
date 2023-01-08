package Book;

import javax.swing.*;
import java.awt.*;

public class LoginForm{
    public LoginForm(){
        JFrame c = new JFrame();
        c.setTitle("예제");
        c.setSize(300,200);

        c.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        c.setLayout(new FlowLayout(FlowLayout.CENTER));

        c.add(new JButton("추가"));
        c.add(new JButton("삭제"));
        c.setVisible(true);

    }
    public static void main(String[] args){
       new LoginForm();
    }
}