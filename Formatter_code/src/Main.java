import builder.ReadAllTextFiles;
import core.FormatText;
import core.RemoveFormatte;

public class Main {
    public static void main(String[] args) {

        FormatText formatt = new FormatText();
        String multiLineText = ReadAllTextFiles.ReadSpecificFile();
        String textNoFornate = RemoveFormatte.start(multiLineText);

        System.out.println(textNoFornate);

    }
}

// @Component, @Service, @Repository, @Override