package ProcessBuilder;

import java.io.IOException;
import java.util.Arrays;

public class Ex4ProcesssBuilderPing {
    public static void main(String[] args) throws IOException, InterruptedException {

        ProcessBuilder pb = new ProcessBuilder(args);
        pb.inheritIO();

        Process p = pb.start();
        int returnValue = p.waitFor();
        System.out.println((returnValue == 0) ? "(OK)" : "(ERROR)");
    }
}

//        if (args.length == 0) {
//            System.out.println("You must indicate the command to execute");
//            System.exit(1);
//        }
//
//        ProcessBuilder pb = new ProcessBuilder(args);
//        pb.inheritIO();
//
//        try {
//            Process p = pb.start();
//            int codRet = p.waitFor();
//            System.out.println("The execution of " + Arrays.toString(args)
//                    + " returns " + codRet
//                    + " " + (codRet == 0 ? "(OK)" : "(ERROR)")
//            );
//        } catch (IOException e) {
//            System.err.println("Error during the execution of the process");
//            System.err.println("Detailed information");
//            System.err.println("---------------------");
//            e.printStackTrace();
//            System.err.println("---------------------");
//            System.exit(2);
//        } catch (InterruptedException e) {
//            System.err.println("Interrupted process");
//            System.exit(3);
//        }


