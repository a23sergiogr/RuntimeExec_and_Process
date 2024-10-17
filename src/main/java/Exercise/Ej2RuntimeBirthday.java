package Exercise;

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Ej2RuntimeBirthday {

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Random random = new Random();
        int nc = random.nextInt(10);

        StringBuilder sb = new StringBuilder();
        sb.append("java;-cp;PSP0-Birthdate.jar;org.example.Main;").append(nc).append(";");

        for (int i = 0; i < nc; i++){
            int n = random.nextInt(1200);
            System.out.println(n);
            sb.append(n).append(";");
        }
        String[] datos = sb.toString().split(";");
        Process process = runtime.exec(datos);

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
