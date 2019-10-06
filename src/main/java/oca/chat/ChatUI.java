package oca.chat;

import static oca.chat.constants.UIConstants.CLEAR_TEXT;
import static oca.chat.constants.UIConstants.DEFAULT_LAYOUT_WITHOUT_TITLE;
import static oca.chat.constants.UIConstants.DEFAULT_LAYOUT_WITH_TITLE;
import static oca.chat.constants.UIConstants.ERROR_MESSAGE;
import static oca.chat.constants.UIConstants.ERROR_SENDING_MESSAGE;
import static oca.chat.constants.UIConstants.INFO_NO_WRITER;
import static oca.chat.constants.UIConstants.ME;
import static oca.chat.constants.UIConstants.MESSAGE;
import static oca.chat.constants.UIConstants.SYSTEM_ERROR_LINE;
import static oca.chat.constants.UIConstants.SYSTEM_LINE;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;
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

    public ChatUI() {
        this("");
    }

    public ChatUI(final String title) {
        this(title, null);
    }

    public ChatUI(final String title, final Writer output) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initialize(title == null ? "" : title, null);
            }
        });
    }

    private void initialize(final String title, final Writer output) {
        this.output = output;
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
                chatText.append(ME.replace(MESSAGE, newMessage));

                try {
                    output.write(ME.replace(MESSAGE, newMessage));
                    output.flush();
                } catch (IOException e1) {
                    writeSystemError(ERROR_SENDING_MESSAGE.replace(MESSAGE, newMessage));
                } catch (NullPointerException e2) {
                    writeSystemInfo(INFO_NO_WRITER);
                }
            }
        });

        this.frame.setBounds(30, 30, 300, 300);
        this.frame.setVisible(true);
    }

    private void writeSystemError(String error) {
        this.chatText.append(
            SYSTEM_ERROR_LINE.replace(ERROR_MESSAGE, error)
        );
    }

    private void writeSystemInfo(String info) {
        chatText.append(
            SYSTEM_LINE.replace(MESSAGE, info)
        );
    }
}
