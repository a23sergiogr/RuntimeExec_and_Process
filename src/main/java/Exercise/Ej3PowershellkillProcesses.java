package Exercise;

import java.io.IOException;
import java.util.Scanner;

public class Ej3PowershellkillProcesses {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Scanner sc = new Scanner(System.in);
        String processKill = sc.nextLine();

        //Proceso de Edge: msedge
        String[] str1 = {"powershell", "Get-Process", processKill};
        String[] str2 = {"powershell", " Stop-Process", "-Force", "-Name", processKill};

        Process process = runtime.exec(str1);
        readProcessOutput(process);

        Process process2 = runtime.exec(str2);
        readProcessOutput(process2);
    }

    public static void readProcessOutput(Process process) throws InterruptedException {
        var scRead = new Scanner(process.getInputStream());
        while(scRead.hasNextLine()){
            System.out.println(scRead.nextLine());
        }
        scRead.close();

        int exitStatus = process.waitFor();
        System.out.println("Exit Status Process Data: " + exitStatus);
        if (exitStatus != 0){
            var scerr = new Scanner(process.getErrorStream());
            while (scerr.hasNextLine()){
                System.err.println(scerr.nextLine());
            }
            scerr.close();
        }
    }
}
