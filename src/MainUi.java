import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.lang.foreign.Addressable;
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
    private JButton SearchButton;
    private JTextField SearchTextField;
    private JTextField textField1;
    private JLabel DefaultLabel;

    String etc;

    public MainUi(String name, String number){
        String tmp;

        JFrame c = new JFrame();
        c.setSize(500,500);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLocation(550,180);

        Title.setHorizontalAlignment(JLabel.CENTER);
        tmp = Title.getText();
        Title.setText(name + tmp);

        DefaultListModel model = new DefaultListModel();

            AppendButton.addActionListener(new ActionListener() {

                String name, number;

                @Override
                public void actionPerformed(ActionEvent e) {
                    name = NameField.getText();   // 안민
                    number = NumberField.getText(); // 1번
                    etc = NumberField.getText();

                    model.addElement(name + " " + number);
                    AddrerssList.setModel(model);
                }
            });

            SortButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    DefaultListModel SortedModel = new DefaultListModel();
                    Object[] objectArray = model.toArray();

                    Arrays.sort(objectArray);

                    for(Object element : objectArray){
                        SortedModel.addElement(element);
                    }
                    AddrerssList.setModel(SortedModel);
                    }
            });

        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel SearchModel = new DefaultListModel();
                Object []ListArray = model.toArray();
                String SearchName = SearchTextField.getText();
                String []tmp = new String[ListArray.length];
                for(int i = 0; i< ListArray.length;i++)
                    tmp[i] = (String) ListArray[i];


                for(int i =0; i<tmp.length; i++) {
                    if (tmp[i].indexOf(SearchName) != -1){
                        SearchModel.addElement(tmp[i]);
                    }
                }
               // AddrerssList.setModel(model);
                AddrerssList.setModel(SearchModel);
            }
        });
        ListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddrerssList.setModel(model);
            }
        });

                c.add(panel1);

            c.setVisible(true);
    }

    public static void main(String args[]){
        new MainUi("1","1");
    }
}
