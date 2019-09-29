package oca.user.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//class ButtonHandler implements ActionListener {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("WIP");
//    }
//}

public class AppWithBehaviors {

    private JFrame appFrame;
    private JButton appButton;
    private JButton threadButton;
    private JTextArea appArea;

    public void launch() {
        this.appFrame = new JFrame("Working with Events");
        this.appFrame.setLayout(new GridLayout(2, 1));

        this.appButton = new JButton("Click me");

//        class ButtonHandler implements ActionListener {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("I'm been clicked !!!");
//                appArea.append("\nThe button was clicked on " + new Date());
//            }
//        }
//
//        this.appButton.addActionListener(new ButtonHandler());
        this.appButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("I'm been clicked !!!");
                appArea.append("\nThe button was clicked on " + new Date());
            }
        });

        this.threadButton = new JButton("Say your name, THREAD !");
        this.threadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appArea.append("\nMy name is " + Thread.currentThread().getName());
            }
        });

        this.appArea = new JTextArea("Write a comment");

        this.appFrame.add(this.appButton);
        this.appFrame.add(this.threadButton);
        this.appFrame.add(this.appArea);

        this.appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.appFrame.setBounds(10, 10, 400, 200);
        this.appFrame.setVisible(true);

        System.out.println("\nThe main thread name is " + Thread.currentThread().getName());

        for (;;) {
            try {
                Thread.sleep(2000);
                this.appArea.append("\nTickle at " + new Date());
            } catch (InterruptedException e) {
                System.err.print("Something happens here !!");
            }
        }

    }

    public static void main(String [] args) {
        new AppWithBehaviors().launch();
    }
}
