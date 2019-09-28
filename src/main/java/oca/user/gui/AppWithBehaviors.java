package oca.user.gui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AppWithBehaviors {

    private JFrame appFrame;
    private JButton appButton;
    private JTextArea appArea;

    public void launch() {
        this.appFrame = new JFrame("Working with Events");
        this.appFrame.setLayout(new GridLayout(2, 1));

        this.appButton = new JButton("Click me");
        this.appArea = new JTextArea("Write a comment");

        this.appFrame.add(this.appButton);
        this.appFrame.add(this.appArea);

        this.appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.appFrame.setBounds(10, 10, 400, 200);
        this.appFrame.setVisible(true);
    }

    public static void main(String [] args) {
        new AppWithBehaviors().launch();
    }
}
