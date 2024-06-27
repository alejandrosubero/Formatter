package core;

import java.util.ArrayList;
import java.util.List;

public class FormatterCode implements IBaseString{


    private static String newLine = IBaseString.createNewLine;

    public static String formatCode(String codeNoFornate) {
        StringBuilder codigoFormateado = new StringBuilder();
        String beforeLine = null;
        int indentationLevel = 0;
        List<String> codeTreeStructure = IBaseString.createList(codeNoFornate);


        for (int i=0; i < codeTreeStructure.size(); i++){

            String line = codeTreeStructure.get(i);

            if( i == 0 && beforeLine == null){
                beforeLine = line;
            }

            if (line.contains("@Component") ||  line.contains("@Service") || line.contains("@Repository")
                    || line.contains("interface") ||  line.contains("class")){
                codigoFormateado.append(line).append(newLine);
            }

            if (line.contains("@Override")){
                indentationLevel = 2;
                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
            }

            if(beforeLine.contains("@Override") && line.contains("{") &&
                    (line.contains("private") || line.contains("public") || line.contains("protected"))){
                indentationLevel = 2;
                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
            } else if(line.contains("{")){
                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
                indentationLevel++;
            }

            if (line.contains("}")) {
                indentationLevel--;
                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line);

                if( i < codeTreeStructure.size() && i+1 < codeTreeStructure.size() && codeTreeStructure.get(i+1).contains("@Override") ){
                    codigoFormateado.append(newLine).append(newLine);
                } if (i >= codeTreeStructure.size() ){
                    codigoFormateado.append(newLine).append(newLine);
                }else {
                    codigoFormateado.append(newLine);
                }
            }


            if (!line.contains("@Component") && !line.contains("@Service") && !line.contains("@Repository") &&
                    !line.contains("@Override") && !line.contains("{") && !line.contains("}") && beforeLine.contains("{")){
                indentationLevel++;
                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);

            } else if (!line.contains("@Component") && !line.contains("@Service") && !line.contains("@Repository") &&
                    !line.contains("@Override") && !line.contains("{") && !line.contains("}") && !beforeLine.contains("{")){
                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
            }
            beforeLine = line;
        }




//        for (String line : codeTreeStructure) {
//
//            if(beforeLine == null){
//                beforeLine = line;
//            }
//
//            if (line.contains("@Component") ||  line.contains("@Service") || line.contains("@Repository")
//            || line.contains("interface") ||  line.contains("class")){
//                codigoFormateado.append(line).append(newLine);
//            }
//
//            if (line.contains("@Override")){
//                indentationLevel = 2;
//                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
//            }
//
//            if(beforeLine.contains("@Override") && line.contains("{") &&
//                    (line.contains("private") || line.contains("public") || line.contains("protected"))){
//                indentationLevel = 2;
//                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
//            } else if(line.contains("{")){
//                    indentationLevel++;
//                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
//            }
//
//            if (line.contains("}")) {
//                indentationLevel--;
//                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
//            }
//
//            if (!line.contains("@Component") &&
//                    !line.contains("@Service") &&
//                    !line.contains("@Repository") &&
//                    !line.contains("@Override") &&
//                    !line.contains("{") &&
//                    !line.contains("}") && beforeLine.contains("{")
//            ){
//                indentationLevel++;
//                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
//            }else if (!line.contains("@Component") &&
//                    !line.contains("@Service") &&
//                    !line.contains("@Repository") &&
//                    !line.contains("@Override") &&
//                    !line.contains("{") &&
//                    !line.contains("}") && !beforeLine.contains("{")
//            ){
//                codigoFormateado.append(IBaseString.indentation(indentationLevel)).append(line).append(newLine);
//            }
//
//           beforeLine = line;
//        }

        return codigoFormateado.toString();
    }



}


// 1. Lexical analysis (omitted in this simplified example)
// 2. Syntactic analysis (omitted in this simplified example)