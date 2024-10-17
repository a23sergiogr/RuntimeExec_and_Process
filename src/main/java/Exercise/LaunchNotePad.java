package Exercise;

import java.io.IOException;

public class LaunchNotePad {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String[] str = {"C:\\Program Files\\WindowsApps\\Microsoft.WindowsNotepad_11.2407.9.0_x64__8wekyb3d8bbwe\\Notepad\\Notepad.exe"};
        Process process = runtime.exec(str);
    }
}
