package core;

import java.util.ArrayList;
import java.util.List;

public class FormatterCode implements IBaseString{


    public static String formatCode(String codeNoFornate) {
        StringBuilder codigoFormateado = new StringBuilder();

        List<String> codeTreeStructure = IBaseString.createList(codeNoFornate);


        int indentationLevel = 0;
        for (String linea : codeTreeStructure) {

            if (linea.startsWith("@Component") ||  linea.startsWith("@Service") || linea.startsWith("@Repository")){


            }

            if (linea.startsWith("@Override")){


            }


            if (linea.startsWith("{")) {
                indentationLevel++;
            }

            // Disminuir sangría al salir de un bloque
            if (linea.startsWith("}")) {
                indentationLevel--;
            }
        }



        return codigoFormateado.toString();
    }

    public static String indentation(Integer indentationLevel){
        StringBuilder indentation = new StringBuilder("");

        if(indentationLevel > 0){
            int index = 0;
            while(index == indentationLevel){
                    indentation.append("\t");
                index++;
            }
        }
       return indentation.toString();
    }




}


// 1. Lexical analysis (omitted in this simplified example)
// 2. Syntactic analysis (omitted in this simplified example)