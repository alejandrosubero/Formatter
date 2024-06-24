package builder;

import configuration.DataReferece;

import java.io.*;

public class ReadAllTextFiles {

    private  static String workingDir = System.getProperty("user.dir");


    public static String ReadFromFolder() {
        String textFromFile ="";
        // Define the folder path
        String folderPath = "samples";
        System.out.println("Reading file in : " + folderPath);
        // Create a File object for the folder
        File folder = new File(folderPath);

        // Check if the folder exists and is a directory
        if (folder.exists() && folder.isDirectory()) {
            // Get all files from the folder
            File[] files = folder.listFiles();

            // Loop through each file
            for (File file : files) {
                // Check if the file is a regular file and ends with ".txt" extension
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println("Reading file: " + file.getName());
                     textFromFile = readFile(file);
                }
            }
        } else {
            textFromFile ="Error: Folder not found or cannot be accessed.";
        }

        System.out.println(textFromFile);
        return textFromFile;
    }


    public static String ReadSpecificFile() {

            String textFromFile ="";
            // Define the folder path
            String folderPath = workingDir + DataReferece.SAMPLE_FOLDER.getNombre();;
            // Define the specific filename (replace with your desired filename)
            String fileName = DataReferece.SAMPLE_FILE.getNombre();

            // Create File objects for the folder and the specific file
            File folder = new File(folderPath);
            File file = new File(folder, fileName);

            // Check if the folder exists and is a directory
            if (folder.exists() && folder.isDirectory()) {
               textFromFile =  readFile(file);
            } else {
                textFromFile ="Error: Folder not found or cannot be accessed.";
            }
              System.out.println(textFromFile);
            return textFromFile;
        }



        public static String readFile(File file){

            StringBuilder allText = new StringBuilder();
            String line;

            if (file.exists() && file.isFile()) {

                System.out.println("Reading file: " + file.getName());

                // Use BufferedReader to read the file line by line
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                    // Read each line of the file
                    while (true) {
                        try {
                            if (!((line = reader.readLine()) != null)) break;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        allText.append(line).append("\n");
                    }

                    // Print the entire text of the file
                    System.out.println(allText.toString());

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Error: File not found or cannot be accessed.");
            }

        return allText.toString();
        }

}
