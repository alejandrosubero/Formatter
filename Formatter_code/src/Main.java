import builder.ReadAllTextFiles;
import core.FormatText;
import core.FormatterCode;
import core.RemoveFormatte;

public class Main {
    public static void main(String[] args) {


        String multiLineText = ReadAllTextFiles.ReadSpecificFile();
        String textNoFornate = RemoveFormatte.start(multiLineText);
        String codeFormatted = FormatterCode.formatCode(textNoFornate);

        System.out.println(codeFormatted);

    }
}

// @Component, @Service, @Repository, @Override