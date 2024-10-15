import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.salesianos.datamanager.filehelper.FileHelper;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = new ArrayList<>(FileHelper.getAllLines("files\\users.txt"));
        ArrayList<Process> wordCounterSubprocesses = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            Process subprocess = CountWord(lines.get(i), "gender-" + i + ".txt");
            wordCounterSubprocesses.add(subprocess);

        }

        for (Process process : wordCounterSubprocesses) {
            process.waitFor();
        }
    }

    public static Process CountWord(String line, String outFileName) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java",
                "src\\net\\salesianos\\datamanager\\gendercounter\\GenderCounter.java",
                line);
        try {
            String FileOutputRoute = "./src/net/salesianos/datamanager/outputs/";
            processBuilder.redirectOutput(new File(FileOutputRoute + outFileName));
            processBuilder.redirectError(new File(FileOutputRoute + "error.txt"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return processBuilder.start();
    }

}
