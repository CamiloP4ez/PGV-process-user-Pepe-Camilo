package net.salesianos.datamanager.gendercounter;

import java.io.BufferedReader;
import java.io.FileReader;

public class GenderCounter {
  public static void main(String[] args) {
    String file = "files/users.txt";
    int male = 0;
    int female = 0;
    try (BufferedReader buffReader = new BufferedReader(new FileReader(file))) {
      String currentLine;

      while ((currentLine = buffReader.readLine()) != null) {
        String[] data = currentLine.split(",");
        if (data[2].equals("H")) {
          male++;
        } else if (data[2].equals("M")) {
          female++;
        }
      }

    } catch (Exception e) {
      // TODO: handle exception
    }
    System.out.println("Hombres," + male + "\nMujeres," + female);
  }
}
