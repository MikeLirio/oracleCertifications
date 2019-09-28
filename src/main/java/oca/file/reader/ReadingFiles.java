package oca.file.reader;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.*;
import oca.constants.FileContansts;

public class ReadingFiles {
    public static void main(String [] args) {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        Boolean success = false;
        while(!success) {
            Logger.getLogger(ReadingFiles.class.getName())
                .log(Level.INFO, "Write a file to read on " + FileContansts.READ_FOLDER_EVERIS + ": ");
            try {
                String fileName = keyboard.readLine();
                success = processFile(fileName);
            } catch (IOException e) {
                String errorMsg = "An error appears when it try to read from keyboard.";
                Logger.getLogger(ReadingFiles.class.getName())
                    .log(Level.SEVERE, errorMsg, e);
            }
        }
    }

    private static Boolean processFile(String fileName) {
        try {
            FileReader reader = new FileReader(FileContansts.READ_FOLDER_EVERIS + fileName);
            BufferedReader buffer = new BufferedReader(reader);

            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = buffer.readLine()) != null) {
                builder.append(line + "\n");
            }

            System.out.println("File content: " + builder);
            Logger.getLogger(ReadingFiles.class.getName())
                .log(Level.INFO, "File content: " + builder);
            return true;
        } catch (FileNotFoundException e) {
            String errorMsg = "File " + fileName + " do not found it.";
            Logger.getLogger(ReadingFiles.class.getName())
                .log(Level.SEVERE, errorMsg, e);
            return false;
        } catch (IOException e) {
            String errorMsg = "An error appers when it was trying to read the file";
            Logger.getLogger(ReadingFiles.class.getName())
                .log(Level.SEVERE, errorMsg, e);
            return false;
        }
    }
}
