package net.salesianos.datamanager.grownUpsCounter;

public class GrownUpsCounter {
  public static void main(String[] args) {
    String line = args[0];
    String[] datauser = line.split(",");
    if (Integer.parseInt(datauser[2]) >= 18) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }
}
