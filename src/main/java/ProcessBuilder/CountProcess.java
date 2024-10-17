package ProcessBuilder;


import java.io.File;
import java.io.IOException;

class CountProcess{
    public static void main(String[] args) throws IOException {
        String comandPt1 = "powershell (Get-Content src\\main\\resources\\fileData.txt | Select-String -Pattern '[";
        String comandPt2 = "]' -AllMatches).Matches.Count";
        String finalComand = comandPt1 + args[0] + comandPt2;;
        ProcessBuilder pb = new ProcessBuilder(finalComand.split(" "));
        pb.inheritIO();
        pb.redirectOutput(new File("src/main/resources/vowels/" + args[0] + ".txt"));
        Process p = pb.start();
    }
}
