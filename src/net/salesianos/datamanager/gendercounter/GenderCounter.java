package net.salesianos.datamanager.gendercounter;

public class GenderCounter {
  public static void main(String[] args) {
    String line = args[0];
    String[] datauser = line.split(",");
    if (datauser[1].equals("H")) {
      System.out.println("Hombre");
    } else {
      System.out.println("Mujer");
    }
  }
}