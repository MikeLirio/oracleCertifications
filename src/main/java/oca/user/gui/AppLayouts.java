package oca.user.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AppLayouts {
    private JFrame appFrame;

    private JButton north;
    private JButton south;
    private JButton east;
    private JButton west;
    private JButton center;

    public void launch() {
        this.appFrame = new JFrame("Playing with Positions");
        this.appFrame.setLayout(new BorderLayout());

        this.north = new JButton("North");
        this.south = new JButton("South");
        this.east = new JButton("East");
        this.west = new JButton("West");
        this.center = new JButton("Center");

        this.appFrame.add(this.north, BorderLayout.NORTH);
        this.appFrame.add(this.south, BorderLayout.SOUTH);
        this.appFrame.add(this.east, BorderLayout.EAST);
        this.appFrame.add(this.west, BorderLayout.WEST);
        this.appFrame.add(this.center, BorderLayout.CENTER);

        this.appFrame.pack();

        this.appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.appFrame.setVisible(true);
    }
}
