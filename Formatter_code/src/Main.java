import format.builder.ReadAllTextFiles;
import format.formatter.Formatter;
import format.utils.Constant;
import format.utils.DataReferece;


public class Main {
    public static void main(String[] args) {

        String multiLineText = ReadAllTextFiles.ReadSpecificFile(
                Constant.samplePath,
                DataReferece.SAMPLE_FILE.getNombre()
        );
        String codeFormatted = new Formatter().simpleFormat(multiLineText);
//        String codeFormatted = new Formatter().removeFormatte(multiLineText);
        System.out.println(codeFormatted);
    }


}