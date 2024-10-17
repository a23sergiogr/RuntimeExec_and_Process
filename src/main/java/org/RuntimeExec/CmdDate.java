package org.RuntimeExec;

import java.io.IOException;
import java.util.Scanner;

public class CmdDate {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        String[] command = {"cmd","/C","data", "/T"};
        Process process = runtime.exec(command);
        var sc = new Scanner(process.getInputStream());
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();

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