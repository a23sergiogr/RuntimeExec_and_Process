package org.RuntimeExec;


import java.io.IOException;

public class NotepadPlusPlusFile {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String[] command = {"C:\\Program Files\\Notepad++\\notepad++.exe","./src/main/resources/info.txt"};
        Process process = runtime.exec(command);
        System.out.println(process.info());
        while (process.isAlive()){
        }
        System.out.println(process.exitValue());
    }
}