package ProcessBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.concurrent.TimeUnit;

public class Ex8TracertToTxt {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("tracert", "www.google.com");
        pb.inheritIO();
        File errorFile = new File("src/main/resources/Ex8ERROR.log");
        File outputFile = new File("src/main/resources/Ex8Tracer.log");

        if (!errorFile.exists()) {
            try {
                errorFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        pb.redirectErrorStream(true);
        pb.redirectError(errorFile);
        pb.redirectOutput(outputFile);

        try {
            Process p = pb.start();
            p.waitFor(500, TimeUnit.MILLISECONDS);
            p.destroyForcibly();
            throw new InterruptedException("Process interrupted by time");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
//        int res = 0;
//        try {
//            if (p != null) {
//                res = p.waitFor();
//            }
//        } catch (InterruptedException e) {
//            System.err.println("\nFallo en waitFor()\n" + e);
//        }
//        System.out.println("\nFinalizado proceso con: " + res);
    }
}
