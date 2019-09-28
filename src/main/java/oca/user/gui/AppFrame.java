package oca.user.gui;

import java.awt.GridLayout;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AppFrame {
    public static void main(String [] args) {
        JFrame app = new JFrame("My first User Interface with Java");
        // this layout divides the window in 2 columns and rows of the same size
        app.setLayout(new GridLayout(2, 2));

        ButtonGroup lenguagesGroup = new ButtonGroup();
        JPanel lenguagePanel = new JPanel();

        List<JRadioButton> listOfLenguages = getLenguagesButtons();
        lenguagePanel.setLayout(new GridLayout(listOfLenguages.size(), 1));
        for (JRadioButton lenguage : listOfLenguages) {
            lenguagesGroup.add(lenguage);
            lenguagePanel.add(lenguage);
        }

        String [] labels = {"Mike", "Ana", "Sarah"};
        JList listOfLabels = new JList(labels);

        JButton imUseless = new JButton("Click me but I'm useless");
        JTextField aTextField = new JTextField("Write a comment");

        app.add(lenguagePanel);
        app.add(listOfLabels);
        app.add(aTextField);
        app.add(imUseless);

        app.setVisible(true);

        // The windows by default does not assume that you are closing the app, because maybe it can
        // be only one windows of the app, like a chat.
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         Is not a good practice to use pixels in Javas GUI. The problem is Java is able to run
         in multiple and totally different enviorments and machines, so just for that, you are
         not avaliable to know in with says really is going to be, which colors are you allow
         to use etc. But this, for start, is good :D
          */
         app.setBounds(10, 10, 400, 200);
    }

    private static List<JRadioButton> getLenguagesButtons() {
        JRadioButton english = new JRadioButton("English", true);
        JRadioButton spanish = new JRadioButton("Spanish");
        JRadioButton french = new JRadioButton("French");
        return Stream.of(
                english, spanish, french
            )
            .collect(Collectors.toList());
    }
}