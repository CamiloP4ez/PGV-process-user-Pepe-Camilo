import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.salesianos.datamanager.filehelper.FileHelper;
import net.salesianos.datamanager.processLauncher.*;

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

        ArrayList<Process> wordCounterSubprocessesGrowns = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            Process subprocess = ProcessLauncher.CountGrownUps(lines.get(i), "growsup-" + i + ".txt");
            wordCounterSubprocessesGrowns.add(subprocess);

        }

        for (Process process : wordCounterSubprocessesGrowns) {
            process.waitFor();
        }

        int maleCounter = 0;
        int femaleCounter = 0;
        int notGrownUp = 0;
        int grownUp = 0;

        for (int i = 0; i < lines.size(); i++) {
            File file = new File("./outputs/gender-" + i + ".txt");
            String line = FileHelper.getWordCounter(file);
            allNumbers = allNumbers + Integer.parseInt(line);
            System.out.println(" En la linea " + i + " hay " + line + " palabras");
            file.delete();
        }

    }

}
