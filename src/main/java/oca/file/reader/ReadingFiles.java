package oca.file.reader;

import oca.constants.FileContansts;

import java.io.*;

public class ReadingFiles {
    public static void main(String [] args) throws Throwable {
        FileReader reader = new FileReader(FileContansts.READ_FOLDER + "readingFileExample.txt");
        BufferedReader buffer = new BufferedReader(reader);

        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = buffer.readLine()) != null) {
            builder.append(line + "\n");
        }

        System.out.println("File content: " + builder);
    }
}
