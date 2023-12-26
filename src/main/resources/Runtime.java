package main.resources;

public class Runtime {

    private static long startTime;

    public static long currentTime () {
        return System.currentTimeMillis();
    }

    public static void start () {
       startTime = currentTime();
    }

    public static String end (timeUnit timeUnit) {
        long endTime = currentTime();
        long duration = endTime - startTime;

        switch (timeUnit) {
            case seconds:
                return "Program finished in: "+duration/1000L+ " seconds";
            case minutes:
                return "Program finished in: "+duration/60000L+ " minutes";
            case ms:
            default:
                return "Program finished in: "+duration+ " ms";
        }
    }

    public enum timeUnit {
        ms, seconds, minutes
    }
}
