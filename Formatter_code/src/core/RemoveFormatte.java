package core;

import builder.ReadAllTextFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveFormatte implements IBaseString{

    public static String start(String multiLineText) {

        List<String> lineList = IBaseString.createList(multiLineText);
        if(lineList != null && lineList.size()>0){
            lineList.removeIf(String::isEmpty);
            return remuveIndentation(lineList);
        }
        return "";
    }


    public static String remuveIndentation(List<String> lineList){
        StringBuilder writeText2 = new StringBuilder();
        lineList.forEach(linetext -> writeText2.append(linetext.trim()).append("\n"));
       return writeText2.toString();
    }

}

