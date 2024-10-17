package ProcessBuilder;

import java.io.File;
import java.io.IOException;

public class Ex6ProcessBuilderDir {
    public static void main(String[] args) {
        //ProcessBuilder pb = pb1();
        //ProcessBuilder pb = pb2();
        ProcessBuilder pb = pb3();
        pb.inheritIO();
        Process p = null;
        try {
            p = pb.start();
        } catch (IOException e) {
            System.err.println("\nFallo en start()\n" + e);
        }
        int res = 0;
        try {
            if (p != null) {
                res = p.waitFor();
            }
        } catch (InterruptedException e) {
            System.err.println("\nFallo en waitFor()\n" + e);
        }
        System.out.println("\nFinalizado proceso con: " + res);
    }

    //Create a program to show what the default directory of execution of a process is. Use the directory() method of ProcessBuilder.
    public static ProcessBuilder pb1(){
        ProcessBuilder pb = new ProcessBuilder("cmd.exe /c echo Esto es un Proceso".split(" "));
        File f = pb.directory();
        if (f!=null)
            System.out.println(f.getAbsolutePath());
        System.out.println("Directorio: " + pb.directory());
        return pb;
    }

    //Execute a process that shows the result of the dir command in the C directory.
    public static ProcessBuilder pb2(){
        ProcessBuilder pb = new ProcessBuilder("cmd.exe /c dir".split(" "));
        pb.directory(new File("C:/"));
        System.out.println("Directorio: " + pb.directory());
        return pb;
    }

    //Request a path to the user and execute a process that shows the result of the dir command in that path.
    public static ProcessBuilder pb3(){
        String path = "C:\\Users\\a23sergiogr\\Desktop";
        ProcessBuilder pb = new ProcessBuilder("cmd.exe /c dir".split(" "));
        pb.directory(new File(path));
        //System.out.println("Directorio: " + pb.directory());
        return pb;
    }
}
