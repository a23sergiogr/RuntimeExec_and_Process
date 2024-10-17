package ProcessBuilder;

import java.util.Scanner;

public class sqrtOfSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double sum = 0;
        for (int i = 0; i < n; i++){
            sum = sum + Integer.parseInt(sc.nextLine());
        }

        System.out.println(sum*sum);
    }
}
