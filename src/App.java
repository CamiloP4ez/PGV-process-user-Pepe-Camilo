import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.salesianos.datamanager.filehelper.FileHelper;
import net.salesianos.datamanager.processlauncher.ProcessLauncher;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = new ArrayList<>(FileHelper.getAllLines("files\\users.txt"));
        ArrayList<Process> usersProcess = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            Process subprocess = ProcessLauncher.CountGender(lines.get(i), "gender-" + i + ".txt");
            usersProcess.add(subprocess);

        }

        for (Process process : usersProcess) {
            process.waitFor();
        }

        ArrayList<Process> wordCounterSubprocessesGrowns = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            Process subprocess = ProcessLauncher.CountGrownUps(lines.get(i), "grownups-" + i + ".txt");
            wordCounterSubprocessesGrowns.add(subprocess);

        }

        for (Process process : wordCounterSubprocessesGrowns) {
            process.waitFor();
        }

        System.out.println("En total hay: " + FileHelper.genderCounter(lines) + " hombres" + " y "
                + (lines.size() - FileHelper.genderCounter(lines)) + " mujeres");

        System.out.println("En total hay: " + FileHelper.grownupsCounter(lines) + " mayores " + " y "
                + (lines.size() - FileHelper.grownupsCounter(lines)) + " menores");

    }

}
