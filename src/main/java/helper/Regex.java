package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static String regexForICAOCode = "A,(.{4}),.*";
    public static String regexForName = "A,.{4},(.*),.*,.*,.*,\\d*,\\d*,\\d*,0";
    public static String regexForLatitude = "A,.{4},.*,(.*),.*,.*,\\d*,\\d*,\\d*,0";
    public static String regexForLongitude = "A,.{4},.*,.*,(.*),.*,\\d*,\\d*,\\d*,0";
    public static String regexForElevation = "A,.{4},.*,.*,.*,(.*),\\d*,\\d*,\\d*,0";
    public static String regexForTransitionAltitude = "A,.{4},.*,.*,.*,.*,(\\d*),\\d*,\\d*,0";
    public static String regexForTransitionLevel = "A,.{4},.*,.*,.*,.*,\\d*,(\\d*),\\d*,0";
    public static String regexForLongestRunway = "A,.{4},.*,.*,.*,.*,\\d*,\\d*,(\\d*),0";

    public static String substitution(String line, String regex, int returnGroup) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()){
            return matcher.group(returnGroup);
        }
        return null;
    }

    public static boolean match (String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
