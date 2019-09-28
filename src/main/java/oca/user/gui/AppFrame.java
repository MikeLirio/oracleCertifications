package oca.user.gui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame {
    public static void main(String [] args) {
        JFrame app = new JFrame("My first User Interface with Java");
        // this layout divides the window in 2 columns and rows of the same size
        app.setLayout(new GridLayout(2, 2));

        JButton imUseless = new JButton("Click me but I'm useless");
        app.add(imUseless);


        // The windows by default does not assume that you are closing the app, because maybe it can
        // be only one windows of the app, like a chat.
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         Is not a good practice to use pixels in Javas GUI. The problem is Java is able to run
         in multiple and totally different enviorments and machines, so just for that, you are
         not avaliable to know in with says really is going to be, which colors are you allow
         to use etc. But this, for start, is good :D
          */
        app.setBounds(10, 10, 300, 200);
        app.setVisible(true);
    }
}