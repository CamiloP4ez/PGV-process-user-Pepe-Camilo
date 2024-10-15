
import java.util.ArrayList;

import net.salesianos.datamanager.filehelper.FileHelper;
import net.salesianos.datamanager.processLauncher.ProcessLauncher;

public class App {
    final static String FILE_ROUTE = "files\\users.txt";

    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = new ArrayList<>(FileHelper.getAllLines(FILE_ROUTE));
        ArrayList<Process> usersProcess = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            Process subprocess = ProcessLauncher.CountGender(lines.get(i), "gender-" + i + ".txt");
            usersProcess.add(subprocess);

        }

        for (Process process : usersProcess) {
            process.waitFor();
        }

        ArrayList<Process> CounterSubprocessesGrowns = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            Process subprocess = ProcessLauncher.CountGrownUps(lines.get(i), "grownups-" + i + ".txt");
            CounterSubprocessesGrowns.add(subprocess);

        }

        for (Process process : CounterSubprocessesGrowns) {
            process.waitFor();
        }

        System.out.println("En total hay: " + FileHelper.genderCounter(lines) + " hombres" + " y "
                + (lines.size() - FileHelper.genderCounter(lines)) + " mujeres");

        System.out.println("En total hay: " + FileHelper.grownupsCounter(lines) + " mayores " + " y "
                + (lines.size() - FileHelper.grownupsCounter(lines)) + " menores");

        FileHelper.clearFiles(FILE_ROUTE);
    }

}
