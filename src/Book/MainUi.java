package Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainUi {

    private JPanel panel1;
    private JLabel Title;
    private JPanel Append;
    private JPanel Look;
    private JLabel NameLabel;
    private JTextField NameField;
    private JLabel Number_Label;
    private JTextField NumberField;
    private JButton AppendButton;
    private JButton ListButton;
    private JButton SortButton;
    private JPanel ListPanel;
    private JList AddrerssList;


    public MainUi(String name, String number){
        String tmp;

        JFrame c = new JFrame();
        c.setSize(500,500);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Title.setHorizontalAlignment(JLabel.CENTER);
        tmp = Title.getText();
        Title.setText(name + tmp);

        DefaultListModel model = new DefaultListModel();
      //  AddrerssList.setModel(model);

            AppendButton.addActionListener(new ActionListener() {

                String name, number;
                int i = 0;

                @Override
                public void actionPerformed(ActionEvent e) {

                    name = NameField.getText();   // 안민
                    number = NumberField.getText(); // 1번
                    model.addElement(name + " " + number);
                    AddrerssList.setModel(model);
                }
            });

            SortButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DefaultListModel sortedModel = new DefaultListModel();
                    Object[] objectArray = model.toArray();
                    String[] sortName = new String[objectArray.length];

                    for(int i = 0; i< objectArray.length; i++){
                        sortName[i] = (String) objectArray[i];
                    }

                    Arrays.sort(sortName);

                    for(String element : sortName){
                        sortedModel.addElement(element);
                    }
                    AddrerssList.setModel(sortedModel);
                }
            });

            c.add(panel1);

            c.setVisible(true);
    }

    public static void main(String args[]){
        new MainUi("1","1");
    }
}
