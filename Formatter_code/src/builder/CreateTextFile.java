package builder;

import configuration.DataReferece;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTextFile {

    public void create(String textContent) {
        String folderName = DataReferece.FOLDER.getNombre(); // Replace with your desired folder name
        String fileName = DataReferece.FILE.getNombre();
        //current working directory:
        String workingDir = System.getProperty("user.dir");

        // Create the folder object (relative path)
        File folder = new File(folderName);

        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Folder \"" + folderName + "\" created.");
        }

        // Create the file path (combining folder and filename)
        File file = new File(folder, fileName);
        writeTextInFile(file,textContent);
    }

  public void writeTextInFile(File file, String textContent){
      try {
          if (file.exists()) {
              System.out.println("File \"" + file.getName() + "\" already exists. Overwriting...");
          }
          // Create the file (or overwrite it)
          file.createNewFile();

          // Write the text content to the file
          FileWriter writer = new FileWriter(file);
          writer.write(textContent);
          writer.close(); // Important to close the writer to flush data

          System.out.println("File \"" + file.getName() + "\" created successfully!");
      } catch (IOException e) {
          System.out.println("Error creating file: " + e.getMessage());
      }
  }

}
