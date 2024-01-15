package backend;

public class appsettings {
    public static String airports_txt = "/data/airports.txt";
    public static String countryPrefixes_csv = "/data/countryPrefixes.csv";
    public static String avwxToken = System.getenv("AirportMetarFinderAvwxApiToken");
}
