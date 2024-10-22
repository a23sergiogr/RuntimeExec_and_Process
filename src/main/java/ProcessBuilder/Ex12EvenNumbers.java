package ProcessBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Ex12EvenNumbers {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*Create a program in Java that takes two numbers from command line and add all even numbers between the smaller and the greater both inclusive,
        Test the program to verify it works properly.

        Create a new program to launch the previous program. Redirect the errors to a file named errors.txt.
        Redirect the output to a file named output.txt. Its important to wait until the launched process is finished.*/

        List<String> command = new java.util.ArrayList<>(List.of("java -cp target/classes ProcessBuilder.AddEvenNumbers".split(" ")));

        Scanner sc = new Scanner(System.in);
        System.out.println("First number");
        command.add(sc.nextLine());
        System.out.println("Second number");
        command.add(sc.nextLine());

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
        process.waitFor();

        var errorScanner = new Scanner(process.getErrorStream());
        try (var fw = new FileWriter(Paths.get("src\\main\\resources\\Ex12\\errors.txt").toFile())){
            while (errorScanner.hasNextLine())
                fw.write(errorScanner.nextLine());
        }

        var inputScanner = new Scanner(process.getInputStream());
        try (var fw = new FileWriter(Paths.get("src\\main\\resources\\Ex12\\output.txt").toFile())) {
            while (inputScanner.hasNextLine())
                fw.write(inputScanner.nextLine());
        }
        inputScanner.close();

    }
}
