package net.salesianos.datamanager.gendercounter;

import java.io.BufferedReader;
import java.io.FileReader;

public class GenderCounter {
  public static void main(String[] args) {
    String line = args[0];
    String[] datauser = line.split(",");
    if (datauser[2] == "H") {
      System.out.println("Hombre");
    } else {
      System.out.println("Mujer");
    }
  }
}