package ProcessBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Ex11Departments {
    public static void main(String[] args) throws IOException {
        String filename = "src/main/resources/departments/department10";
        ProcessBuilder processBuilder = new ProcessBuilder("java -cp target/classes ProcessBuilder.SumDepartments".split(" "));
        long start = System.nanoTime();

        ArrayList<Process> processList = new ArrayList<>();
        Queue<String> nameQueue = new PriorityQueue<>();
        for (int i = 1; i < 9; i++) {
            String completePath = filename + i + ".txt";
            processBuilder.command().add(completePath);
            System.out.println(processBuilder.command().toString());
            Process process = processBuilder.start();
            processList.add(process);
            processBuilder.command().removeLast();
            String[] files = completePath.split("/");
            nameQueue.add(files[files.length - 1]);
        }

        try {
            for (Process p : processList) {
                p.waitFor();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.nanoTime();

        for (Process process : processList) {
            var scanner = new Scanner(process.getErrorStream());
            while (scanner.hasNextLine()) {
                String errorStr = scanner.nextLine();
                System.out.println("ERROR: " + errorStr);
            }
            scanner.close();
        }

        boolean append = false;
        for (Process process : processList) {
            var scanner = new Scanner(process.getInputStream());
            try (var fw = new FileWriter(Paths.get("src\\main\\resources\\departments\\departmentResult").toFile(), append)) {
                fw.write(nameQueue.remove() + "\n");
                fw.write("====================\n");
                fw.write(scanner.nextLine() + "\n");
                fw.write("====================\n");
                fw.write("\n");
            }
            scanner.close();
            append = true;

        }

        System.out.println("Tiempo: " + (end - start));

    }
}

/*
department101.txt
====================
-17700363.41
====================

department102.txt
====================
-118644799.58
====================

department103.txt
====================
-109031607.43
====================

department105.txt
====================
-2902057.91
====================

department106.txt
====================
-29874593.72
====================

department107.txt
====================
3081871008.55
====================

department108.txt
====================
-44008133.39
====================
*/

