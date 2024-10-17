package Exercise;

import java.io.IOException;

public class LaunchYoutubeOnGoogleChrome {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String[] str = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", "https://www.youtube.com/"};
        Process process = runtime.exec(str);
    }
}
