package main.resources;

public class Runtime {

    private static long startTime;

    private static long currentTime () {
        return System.currentTimeMillis();
    }

    public static void start () {
       startTime = currentTime();
    }

    public static void end (timeUnit timeUnit, type type) {
        long endTime = currentTime();
        long duration = endTime - startTime;

        switch (timeUnit) {
            case seconds:
                System.out.println(type.toString()+" finished in: "+duration/1000L+ " seconds");
            case minutes:
                System.out.println(type.toString()+" finished in: "+duration/60000L+ " minutes");
            case ms:
            default:
                System.out.println(type.toString()+" finished in: "+duration+ " ms");
        }
    }

    public enum timeUnit {
        ms, seconds, minutes
    }

    public enum type {
        program, process
    }
}
