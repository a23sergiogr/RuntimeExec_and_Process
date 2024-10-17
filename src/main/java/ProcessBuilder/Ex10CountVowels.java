package ProcessBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex10CountVowels {
    public static void main(String[] args) throws IOException {
        File outputData = new File("src/main/resources/res.dat");
        File inputData = new File("src/main/resources/fileData.txt");
//        ProcessBuilder pba = new ProcessBuilder("powershell (Get-Content C:\\Users\\a23sergiogr\\Desktop\\PSP\\RuntimeExec\\src\\main\\resources\\fileData.txt | Select-String -Pattern '[aeiou]' -AllMatches).Matches.Count".split(" "));
//        FileOutputStream fos = new FileOutputStream(outputData);
        FileOutputStream fos = new FileOutputStream(outputData);

        ProcessBuilder pb = new ProcessBuilder("java -cp target/classes ProcessBuilder.CountVowelsCall".split(" "));
        pb.inheritIO();
        Process p  = pb.start();

        try {
            p.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
