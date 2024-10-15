package net.salesianos.datamanager.filehelper;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileHelper {

  public static ArrayList<String> getAllLines(String fileRoute) {
    ArrayList<String> lines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileRoute, StandardCharsets.UTF_8))) {
      String currentLine = reader.readLine();
      while (currentLine != null) {
        lines.add(currentLine);
        currentLine = reader.readLine();
      }
    } catch (Exception e) {
      System.out.println("No se ha encontrado el fichero");
    }
    return lines;
  }

  public static int genderCounter(ArrayList<String> users) {
    BufferedReader reader = null;
    try {
      int gender = 0;
      for (int i = 0; i < users.size(); i++) {
        reader = new BufferedReader(
            new FileReader("./outputs/files/gender/gender-" + i + ".txt", StandardCharsets.UTF_8));
        String line = reader.readLine();
        if (line.equals("Hombre")) {
          gender++;
        }
        reader.close();
      }
      return gender;
    } catch (Exception e) {
      return -1;
    }
  }

  public static int grownupsCounter(ArrayList<String> users) {
    BufferedReader reader = null;
    try {
      int grownups = 0;
      for (int i = 0; i < users.size(); i++) {
        reader = new BufferedReader(
            new FileReader("./outputs/files/grownups/grownups-" + i + ".txt", StandardCharsets.UTF_8));
        String line = reader.readLine();
        if (line.equals("True")) {
          grownups++;
        }
        reader.close();
      }
      return grownups;
    } catch (Exception e) {
      return -1;
    }
  }

  public static void clearFiles(String fileRoute) {
    ArrayList<String> lines = new ArrayList<>(getAllLines(fileRoute));
    for (int i = 0; i < lines.size(); i++) {
      File file = new File("outputs\\files\\gender\\gender-" + i + ".txt");
      File file2 = new File("outputs\\files\\grownups\\grownups-" + i + ".txt");
      file.delete();
      file2.delete();
    }
  }

}
