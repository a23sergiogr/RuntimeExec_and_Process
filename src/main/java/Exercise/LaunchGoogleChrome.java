package Exercise;

import java.io.IOException;

public class LaunchGoogleChrome {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String[] str = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};
        Process process = runtime.exec(str);
    }
}
