package Book;

import javax.swing.*;

public class test {


    public static void main(String[] args){

        String tmp = "[1 2,3 4]";
        String []tmp2 = tmp.split("\\[|\\,|\\s|\\]");

     //   System.out.print(tmp2[0].length());
        System.out.print(tmp2[3]);
    }
}
