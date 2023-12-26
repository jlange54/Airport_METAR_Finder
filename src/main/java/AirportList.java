package main.java;

import main.resources.FileRW;
import main.resources.Regex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AirportList {
    public static List<Airport> generate () throws IOException {
        String directory = "./data/airports/airports.txt";

        return generateFromFile(directory);
    }

    private static List<Airport> generateFromFile (String directory) throws IOException {
        List<Airport> result = new ArrayList<Airport>();
        Iterator<String> inputIterator = FileRW.read(directory).iterator();

        while (inputIterator.hasNext()) {
            String line = inputIterator.next();
            Airport currentAirport = new Airport();

            if(Regex.match(line, Regex.regexForICAOCode)) {
                currentAirport.setIcaoCode(Regex.substitution(line, Regex.regexForICAOCode, 1));
            } if (Regex.match(line, Regex.regexForName)) {
                currentAirport.setName(Regex.substitution(line, Regex.regexForName, 1));
            } if (Regex.match(line, Regex.regexForLatitude)) {
                currentAirport.setLatitude(Double.parseDouble(Regex.substitution(line, Regex.regexForLatitude, 1)));
            } if (Regex.match(line, Regex.regexForLongitude)) {
                currentAirport.setLongitude(Double.parseDouble(Regex.substitution(line, Regex.regexForLongitude, 1)));
            } if (Regex.match(line, Regex.regexForElevation)) {
                currentAirport.setElevation(Integer.parseInt(Regex.substitution(line, Regex.regexForElevation, 1)));
            } if (Regex.match(line, Regex.regexForTransitionAltitude)) {
                currentAirport.setTransitionAltitude(Integer.parseInt(Regex.substitution(line, Regex.regexForTransitionAltitude, 1)));
            } if (Regex.match(line, Regex.regexForTransitionLevel)) {
                currentAirport.setTransitionLevel(Integer.parseInt(Regex.substitution(line, Regex.regexForTransitionLevel, 1)));
            } if (Regex.match(line, Regex.regexForLongestRunway)) {
                currentAirport.setLongestRunway(Integer.parseInt(Regex.substitution(line, Regex.regexForLongestRunway, 1)));
            }

            result.add(currentAirport);
        }

        return result;
    }
}
