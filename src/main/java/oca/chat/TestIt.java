package oca.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class TestIt  {

    public static void main(String[] args) throws Throwable {
        new ChatUI();
        new ChatUI( "Lirio");

        OutputStreamWriter output = new OutputStreamWriter(System.out);

        List<ChatUI> openChats = new ArrayList<>();
        openChats.add(new ChatUI("Jane Doe", output));
        openChats.add(new ChatUI("Jhon Doe", output));

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = keyboard.readLine()) != null) {
            for (ChatUI chat : openChats) {
                chat.readMessageFromKeyboard(line);
            }
        }
    }
}
