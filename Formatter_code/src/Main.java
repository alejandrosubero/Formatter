import builder.ReadAllTextFiles;
import core.RemoveFormatte;

public class Main {
    public static void main(String[] args) {

        String multiLineText = ReadAllTextFiles.ReadSpecificFile();
        String textNoFornate =RemoveFormatte.start(multiLineText);

        System.out.println(textNoFornate);
    }
}