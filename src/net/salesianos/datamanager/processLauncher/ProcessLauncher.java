package net.salesianos.datamanager.processLauncher;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {
  public static Process CountGender(String line, String outFileName) throws IOException {
    ProcessBuilder processBuilder = new ProcessBuilder("java",
        "src\\net\\salesianos\\datamanager\\gendercounter\\GenderCounter.java",
        line);
    try {
      String FileOutputRoute = "./src/net/salesianos/datamanager/outputs/";
      processBuilder.redirectOutput(new File(FileOutputRoute + outFileName));
      processBuilder.redirectError(new File(FileOutputRoute + "errorGender.txt"));

    } catch (Exception e) {
      e.printStackTrace();
    }
    return processBuilder.start();
  }
}
