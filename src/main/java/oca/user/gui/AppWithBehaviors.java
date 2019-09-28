package oca.user.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("WIP");
    }
}

public class AppWithBehaviors {

    private JFrame appFrame;
    private JButton appButton;
    private JTextArea appArea;

    public void launch() {
        this.appFrame = new JFrame("Working with Events");
        this.appFrame.setLayout(new GridLayout(2, 1));

        this.appButton = new JButton("Click me");
        this.appButton.addActionListener(new ButtonHandler());

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
