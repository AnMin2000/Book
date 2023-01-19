package Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUi {

    private JPanel panel1;
    private JLabel Title;
    private JPanel Append;
    private JPanel Look;
    private JLabel NameLabel;
    private JTextField textField1;
    private JLabel Number_Label;
    private JTextField textField2;
    private JButton AppendButton;
    private JButton SortButton;
    private JButton ListButton;
    private JLabel List;


    public MainUi(String name, String number){
        String tmp;

        JFrame c = new JFrame();
        c.setSize(500,500);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Title.setHorizontalAlignment(JLabel.CENTER);
        tmp = Title.getText();
        Title.setText(name + tmp);

            AppendButton.addActionListener(new ActionListener() {
                String name, number, AllList;
                int i = 0;

                @Override
                public void actionPerformed(ActionEvent e) {

                    name = textField1.getText();
                    number = textField2.getText();
                    AllList = name + number + "\n";
                    if(i == 0) {
                        List.setText(name + number);
                        i++;
                    }
                    else {
                        AllList = List.getText(); // 안민 1
                        List.setText(AllList + name + number); // 안민 1
                    }
                }
            });

            c.add(panel1);

            c.setVisible(true);

    }
}
