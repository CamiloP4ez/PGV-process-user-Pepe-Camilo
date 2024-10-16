package net.salesianos.datamanager.processLauncher;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {
  public static Process CountGender(String line, String outFileName) throws IOException {
    ProcessBuilder processBuilder = new ProcessBuilder("java",
        "src\\net\\salesianos\\datamanager\\gendercounter\\GenderCounter.java",
        line);
    try {
      String FileOutputRoute = "outputs\\files\\gender\\";
      processBuilder.redirectOutput(new File(FileOutputRoute + outFileName));
      processBuilder.redirectError(new File("./outputs/errors/" + "errorGender.txt"));

    } catch (Exception e) {
      e.printStackTrace();
    }
    return processBuilder.start();
  }

  public static Process CountGrownUps(String line, String outFileName) throws IOException {
    ProcessBuilder processBuilder = new ProcessBuilder("java",
        "src\\net\\salesianos\\datamanager\\grownupscounter\\GrownUpsCounter.java",
        line);
    try {
      String FileOutputRoute = "outputs\\files\\grownups\\";
      processBuilder.redirectOutput(new File(FileOutputRoute + outFileName));
      processBuilder.redirectError(new File("./outputs/errors/" + "errorGrownups.txt"));

    } catch (Exception e) {
      e.printStackTrace();
    }
    return processBuilder.start();
  }
}
