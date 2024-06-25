package core;

import builder.ReadAllTextFiles;
import configuration.DataReferece;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveEmptyLines {

    public static void main(String[] args) throws IOException {
        String multiLineText = ReadAllTextFiles.ReadSpecificFile();
        removeFormatte(multiLineText);

    }

    private static String removeFormatte(String multiLineText) {
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
        System.out.println(linesToText);
        return linesToText;
    }


    public static String spacesRemuve(String text) {
        // Pattern to match leading spaces
        Pattern leadingSpacesPattern = Pattern.compile("^\\s+");

        Matcher matcher = leadingSpacesPattern.matcher(text);

        // Replace leading spaces with empty string (using StringBuilder)
        StringBuilder modifiedText = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(modifiedText, "");
        }
        matcher.appendTail(modifiedText);

        System.out.println("Original text:\n" + text);
        System.out.println("\nModified text:\n" + modifiedText);


        return modifiedText.toString();
    }







}

