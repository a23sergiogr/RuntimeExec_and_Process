package ProcessBuilder;

import java.io.IOException;
import java.util.Map;

public class Ex5ProcessBuilderSetEnvironment {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe /C set /a n3=n2+n1".split(" "));
        Map<String, String> environment = pb.environment();
        environment.put("n1","1");
        environment.put("n2","2");

        pb.inheritIO();
        Process p = null;
        try {
            p = pb.start();
        } catch (IOException e) {
            System.err.println("\nFallo en start()\n" + e);
        }
        int res = 0;
        try {
            if (p != null) {
                res = p.waitFor();
            }
        } catch (InterruptedException e) {
            System.err.println("\nFallo en waitFor()\n" + e);
        }
        System.out.println("\nFinalizado proceso con: " + res);
    }
}
