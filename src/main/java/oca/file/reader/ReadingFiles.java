package oca.file.reader;

import java.util.logging.Logger;
import java.util.logging.Level;
import oca.constants.FileContansts;

import java.io.*;

public class ReadingFiles {
    public static void main(String [] args) {
        try {
            FileReader reader = new FileReader(FileContansts.READ_FOLDER + "readingFileExample.txt");
            BufferedReader buffer = new BufferedReader(reader);

            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = buffer.readLine()) != null) {
                builder.append(line + "\n");
            }

            System.out.println("File content: " + builder);
        } catch (FileNotFoundException e) {
            String errorMsg = "An error appers when it was trying to read the file";
            Logger.getLogger(ReadingFiles.class.getName())
                .log(Level.SEVERE, errorMsg, e);
        } catch (IOException e) {
            String errorMsg = "An error appers when it was trying to read the file";
            Logger.getLogger(ReadingFiles.class.getName())
                .log(Level.SEVERE, errorMsg, e);
        }
    }
}
