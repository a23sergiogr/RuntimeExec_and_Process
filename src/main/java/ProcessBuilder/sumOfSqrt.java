package ProcessBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sumOfSqrt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double sum = 0;
        for (int i = 0; i < n; i++){
            int j = Integer.parseInt(sc.nextLine());
            sum = sum + j*j;
        }

        System.out.println(sum);
    }
}
