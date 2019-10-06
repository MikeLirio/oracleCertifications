package oca.chat;

import static oca.chat.constants.UIConstants.CLEAR_TEXT;
import static oca.chat.constants.UIConstants.DEFAULT_LAYOUT_WITHOUT_TITLE;
import static oca.chat.constants.UIConstants.DEFAULT_LAYOUT_WITH_TITLE;
import static oca.chat.constants.UIConstants.NEW_LINE;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatUI {

    private JFrame frame;
    private JScrollPane scrollPane;
    private JTextArea chatText;
    private JTextField entryText;

    public ChatUI() {
        this("");
    }

    public ChatUI(final String title) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initialize(title == null ? "" : title);
            }
        });
    }

    private void initialize(String title) {
        this.frame = new JFrame(
            title.isEmpty() ? DEFAULT_LAYOUT_WITHOUT_TITLE : DEFAULT_LAYOUT_WITH_TITLE + title
        );
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.chatText = new JTextArea();
        this.chatText.setEditable(false);
        this.scrollPane = new JScrollPane(this.chatText);
        this.frame.add(this.scrollPane, BorderLayout.CENTER);

        this.entryText = new JTextField();
        this.frame.add(this.entryText, BorderLayout.SOUTH);
        this.entryText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newMessage = entryText.getText();
                entryText.setText(CLEAR_TEXT);
                chatText.append(NEW_LINE + newMessage);
            }
        });

        this.frame.setBounds(30, 30, 300, 300);
        this.frame.setVisible(true);
    }
}
