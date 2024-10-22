package ProcessBuilder;

public class AddEvenNumbers {
    public static void main(String[] args) {
        if (args.length != 2)
            throw new IllegalArgumentException("You need 2 numbers");

        long sum = 0;
        for (int i = Integer.parseInt(args[0]); i <= Integer.parseInt(args[1]); i++) {
            if (i % 2 == 1){
                sum = sum + i;
            }
        }

        System.out.println(sum);
    }
}
