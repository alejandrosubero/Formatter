package core;

import builder.ReadAllTextFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveFormatte {

    public static String start(String multiLineText) {
        StringBuilder writeText = new StringBuilder();
        StringBuilder writeText2 = new StringBuilder();
        List<String> lineList = new ArrayList<>();
        Scanner scanner = new Scanner(multiLineText);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineList.add(line);
        }
        scanner.close();

        lineList.removeIf(String::isEmpty);
        lineList.forEach(line -> writeText.append(line).append("\n"));
        lineList.forEach(linetext -> writeText2.append(linetext.trim()).append("\n"));
        String linesToText = writeText2.toString();
        return linesToText;
    }

// remove blank line
// remove indexing
}

