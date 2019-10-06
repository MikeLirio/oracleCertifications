package oca.chat;

import static oca.chat.constants.UIConstants.CLEAR_TEXT;
import static oca.chat.constants.UIConstants.DEFAULT_LAYOUT_WITHOUT_TITLE;
import static oca.chat.constants.UIConstants.DEFAULT_LAYOUT_WITH_TITLE;
import static oca.chat.constants.UIConstants.ERROR_MESSAGE;
import static oca.chat.constants.UIConstants.ERROR_SENDING_MESSAGE;
import static oca.chat.constants.UIConstants.INFO_NO_WRITER;
import static oca.chat.constants.UIConstants.MESSAGE;
import static oca.chat.constants.UIConstants.SYSTEM_ERROR_LINE;
import static oca.chat.constants.UIConstants.SYSTEM_LINE;
import static oca.chat.constants.UIConstants.USERS_LINE;
import static oca.chat.constants.UIConstants.USER_ME;
import static oca.chat.constants.UIConstants.USER_NAME;
import static oca.chat.constants.UIConstants.USER_UNKNOW;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
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

    private Writer output;
    private String userName;

    public ChatUI() {
        this("");
    }

    public ChatUI(final String user) {
        this(user, null);
    }

    public ChatUI(final String user, final Writer output) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initialize(user == null ? "" : user, output);
            }
        });
    }

    private void initialize(final String user, final Writer output) {
        this.output = output;
        this.userName = user;
        this.frame = new JFrame(
            this.userName.isEmpty() ? DEFAULT_LAYOUT_WITHOUT_TITLE
                : DEFAULT_LAYOUT_WITH_TITLE + this.userName
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
                writeMeMessage(newMessage);
            }
        });

        this.frame.setBounds(30, 30, 300, 300);
        this.frame.setVisible(true);
    }

    private void writeSystemError(String error) {
//        Font errorFont = new Font(Font.SANS_SERIF, Font.ITALIC, 9);
//        this.chatText.setFont(errorFont);
        this.chatText.append(
            SYSTEM_ERROR_LINE.replace(ERROR_MESSAGE, error)
        );
    }

    private void writeSystemInfo(String info) {
//        Font infoFont = new Font(Font.SERIF, Font.BOLD, 9);
//        this.chatText.setFont(infoFont);
       this.chatText.append(
            SYSTEM_LINE.replace(MESSAGE, info)
        );
    }

    private void writeMeMessage(String message) {
        String messageToPrint = USERS_LINE
            .replace(USER_NAME, this.userName.isEmpty() ? USER_ME : this.userName)
            .replace(MESSAGE, message);
        this.chatText.append(messageToPrint);
        if (this.output != null) {
            try {
                this.output.write(messageToPrint);
                this.output.flush();
            } catch (IOException e1) {
                this.writeSystemError(ERROR_SENDING_MESSAGE.replace(MESSAGE, messageToPrint));
            } catch (NullPointerException e2) {
                this.writeSystemInfo(INFO_NO_WRITER);
            }
        }
    }

    public void readMessage(final String newMessage) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                String messageToPrint = USERS_LINE
//                    .replace(USER_NAME, USER_UNKNOW)
//                    .replace(MESSAGE, newMessage);
                chatText.append(newMessage);
            }
        });
    }
}
