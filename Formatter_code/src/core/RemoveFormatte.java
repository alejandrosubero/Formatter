package core;

import builder.ReadAllTextFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveFormatte implements IBaseString {

    protected String start(String multiLineText) {
        List<String> lineList = IBaseString.createList(multiLineText);
        if(lineList != null && lineList.size()>0){
            lineList.removeIf(String::isEmpty);
            return  remuveSpaceDoubleInLine(remuveIndentation(lineList));
        }
        return "";
    }

    private String remuveIndentation(List<String> lineList){
        StringBuilder writeText2 = new StringBuilder();
        lineList.forEach(linetext -> writeText2.append(linetext.trim()).append(IBaseString.createNewLine));
       return writeText2.toString();
    }

    private String remuveSpaceDoubleInLine(String multiLineText){

        StringBuilder writeText2 = new StringBuilder();

        for (int i = 0; i < multiLineText.length(); i++) {
            char currentChar = multiLineText.charAt(i);
            if (currentChar == ' ' && i > 0 && multiLineText.charAt(i - 1) == ' ') {
                continue;
            } else if (currentChar == '\u00A0' || currentChar == '\t') {
                writeText2.append(' ');
            } else {
                writeText2.append(currentChar);
            }
        }
        return writeText2.toString();
    }
}

