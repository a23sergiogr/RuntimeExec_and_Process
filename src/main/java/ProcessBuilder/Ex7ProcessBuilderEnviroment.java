package ProcessBuilder;

import java.io.IOException;
import java.util.Map;

public class Ex7ProcessBuilderEnviroment {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe /C echo Mapa".split(" "));
        Map<String, String> environment = pb.environment();
        System.out.println(environment);
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
