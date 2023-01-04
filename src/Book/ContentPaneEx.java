package Book;

import java.awt.*;

import javax.swing.*;

public class ContentPaneEx extends JFrame {

    public ContentPaneEx() {
        setTitle("주소록"); //프레임 타이틀
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane(); // 다른 컴포넌트를 포함하고 있는 것 << Container

        Color b=new Color(33, 115, 68);
        c.setBackground(b);     // 센 백그라운드에 넣어준다
        c.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout 배치관리자 달기

        c.add(new JButton("OK")); // OK버튼
        c.add(new JButton("Cancel")); // Cancel 버튼
        c.add(new JButton("Ignore")); // Ignore 버튼

        setSize(300, 150); // 프레임 크기 300 x 150
        setVisible(true); // 화면에 프레임 출력

    }
    public static void main(String[] args) {
        new ContentPaneEx();

    }

}