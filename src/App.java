import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.salesianos.datamanager.filehelper.FileHelper;
import net.salesianos.datamanager.processLauncher.ProcessLauncher;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = new ArrayList<>(FileHelper.getAllLines("files\\users.txt"));
        ArrayList<Process> wordCounterSubprocesses = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            Process subprocess = ProcessLauncher.CountGender(lines.get(i), "gender-" + i + ".txt");
            wordCounterSubprocesses.add(subprocess);

        }

        for (Process process : wordCounterSubprocesses) {
            process.waitFor();
        }
    }

}
