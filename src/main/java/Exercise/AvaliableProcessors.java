package Exercise;

public class AvaliableProcessors {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Avaliable Processors: " + runtime.availableProcessors());
    }
}
