import builder.ReadAllTextFiles;
import formatter.Formatter;
import utils.Constant;
import utils.DataReferece;


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