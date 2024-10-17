package ProcessBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class CountVowelsCall {
    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        ProcessBuilder pb = new ProcessBuilder("java -cp target/classes ProcessBuilder.CountProcess".split(" "));
        pb.inheritIO();

        ArrayList<Process> processList = new ArrayList<>();
        String[] vowels = {"aA","eE","iI","oO","uU"};
        for (String vowel : vowels){
            pb.command().add(vowel);
            System.out.println(pb.command().toString());
            Process process = pb.start();
            processList.add(process);
            pb.command().removeLast();
        }

        try{
            for (Process p : processList){
                p.waitFor();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long time2 = System.currentTimeMillis();
        System.out.println(time2-time);

//        Path datos = Paths.get("src/main/resources/vowels/");
//        Files.list(datos).forEach(System.out::println);
//
//        ArrayList<Path> pathArrayList = new ArrayList<>();
//        Files.list(datos).forEach(pathArrayList::add);
//        for (Path path : pathArrayList){
//            System.out.println(String.valueOf(path));
//            try(var fr = new BufferedReader(new FileReader(path.toFile()))){
//                System.out.println(fr.readLine());
//            }
//        }
    }
}

