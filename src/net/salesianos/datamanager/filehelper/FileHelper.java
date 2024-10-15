package net.salesianos.datamanager.filehelper;

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
}
