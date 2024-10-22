package ProcessBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SumDepartments {
    public static void main(String[] args) {
        if (args.length != 1)
            return;

        double result = 0;
        Path path = Paths.get(args[0]);
        try (var sc = new Scanner(path)){
            while (sc.hasNext()){
                result = result + Double.parseDouble(sc.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo");
        }
        System.out.println(result);
    }
}
