package oca.chat;

import static oca.chat.constants.UIConstants.*;
import static oca.chat.constants.UIConstants.LOCALHOST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChatClient {

    private static List<ChatUI> chats;

    public static void main(String [] args) throws IOException {
        Socket chatConnection = new Socket(LOCALHOST, PORT);

        BufferedReader chatReader = new BufferedReader(
            new InputStreamReader(chatConnection.getInputStream())
        );
        Writer chatWriter = new OutputStreamWriter(chatConnection.getOutputStream());

        chats = openChats(chatWriter);

        String line;
        while((line = chatReader.readLine()) != null) {
            promoteMessage(line);
        }
        promoteMessage("The chat has ended.");
    }

    private static List<ChatUI> openChats(final Writer chatWriter) {
        return Stream.of(
            new ChatUI("Jane Doe", chatWriter),
            new ChatUI("Jhon Doe", chatWriter)
        ).collect(Collectors.toList());
    }

    private static void promoteMessage(final String message) {
        for (ChatUI chat : chats) {
            chat.readMessage(message);
        }
    }
}
