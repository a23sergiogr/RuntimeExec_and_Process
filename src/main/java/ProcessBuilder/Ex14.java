package ProcessBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        String[] sqrtOfSum = "java -cp target/classes ProcessBuilder.sqrtOfSum".split(" ");
        String[] sumOfSqrt = "java -cp target/classes ProcessBuilder.sumOfSqrt".split(" ");

        ProcessBuilder processBuilderSqrtOfSum = new ProcessBuilder(sqrtOfSum);
        ProcessBuilder processBuilderSumOfSqrt = new ProcessBuilder(sumOfSqrt);


        Process processSqrtOfSum = null;
        Process processSumOfSqrt = null;
        try {
            processSqrtOfSum = processBuilderSqrtOfSum.start();
            processSumOfSqrt = processBuilderSumOfSqrt.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> strings = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        strings.add(String.valueOf(n) + "\n");
        for (int i = 0; i < n; i++){
            strings.add(String.valueOf(sc.nextInt()) + "\n");
        }

        try(var bwSqrtOfSum = new OutputStreamWriter(processSqrtOfSum.getOutputStream());
            var bwSumOfSqrt = new OutputStreamWriter(processSumOfSqrt.getOutputStream());){
            for (String str : strings){
                bwSqrtOfSum.write(str);
                bwSumOfSqrt.write(str);
            }
        } catch (IOException e) {
            System.err.println("Error al escribir");
        }

        var scSqrtOfSum = new Scanner(processSqrtOfSum.getInputStream());
        while(scSqrtOfSum.hasNextLine()){
            System.out.println("SqrtOfSum: " + scSqrtOfSum.nextLine());
        }
        scSqrtOfSum.close();

        var scSumOfSqrt = new Scanner(processSumOfSqrt.getInputStream());
        while(scSumOfSqrt.hasNextLine()){
            System.out.println("SumOfSqrt: " + scSumOfSqrt.nextLine());
        }
        scSumOfSqrt.close();
    }
}

