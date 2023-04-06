import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.File;  // Import the File class
import java.util.Scanner;

public class Scrambler {
    public static String getScrambledWord(String word) {
        String scrambledWord = "";
        String operatingWord = word;
        Random rand = new Random();
        while (operatingWord.length() > 0) {
            int randomIndex = rand.nextInt(operatingWord.length());
            Character letter = operatingWord.charAt(randomIndex);
            scrambledWord += letter;
            operatingWord = operatingWord.substring(0,randomIndex) + operatingWord.substring(randomIndex + 1, operatingWord.length());
        }
        return scrambledWord;
    }

    public static void scrambleFile(String argFileName, String argNewFile) {
        try {
            File mainFile = new File(argFileName);
            File newFile;
            Scanner mainFileReader = new Scanner(mainFile);
            FileWriter newFileWriter;
            if (!mainFile.exists()) {
                System.out.println("Stopping! Provided main file to read data not found");
                return;
            }
            //initialize files

            if (argNewFile == null) {
                argNewFile = argFileName;
                newFileWriter = null;
                System.out.println(String.format("Scrambling to same file... - %s", mainFile.getName()));
            } else {
                //initialize new file
                newFile = new File(argNewFile);
                if (!newFile.exists()) {
                    System.out.println("not exists");
                    if (newFile.createNewFile()) {
                        System.out.println(String.format("Created file to save scramble %s", argNewFile));
                    }
                } else {

                    System.out.println(String.format("Found file to save scramble %s", argNewFile));
                }

                newFileWriter = new FileWriter(newFile);
                System.out.println(String.format("Scrambling %s to %s", argFileName, argNewFile));
            }
            //scrambling :)
            String standardText = "";
            String scrambled = "";
            while (mainFileReader.hasNextLine()) {
                standardText +=  mainFileReader.nextLine();
                if (mainFileReader.hasNextLine()) {
                    standardText += "\n";
                }
            }
            scrambled = Scrambler.getScrambledWord(standardText);
            if (newFileWriter == null) {
                newFileWriter = new FileWriter(mainFile);

            }
            newFileWriter.write(scrambled);
            newFileWriter.close();

            System.out.println("Scrambled sucessfully! :)");

        } catch (IOException e) {
            System.out.println("An error occured, please check docs!");
            e.printStackTrace();
        }




    }
}
