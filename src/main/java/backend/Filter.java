package backend;

import backend.objects.Airport;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static List<Airport> filterByRunwayLength (int minLength, int maxLength, List<Airport> airportList) {
        return airportList.stream().filter(p -> p.getLongestRunway() >= minLength && p.getLongestRunway() <= maxLength).collect(Collectors.toList());
    }

    public static Airport filterByIcaoCode (String icaoCode, List<Airport> airportList) {
        return airportList.stream().filter(p -> p.getIcaoCode().equals(icaoCode)).findAny().orElse(null);
    }

    public static List<Airport> filterByCountry (String country, List<Airport> airportList) {
        return airportList.stream().filter(p -> p.getCountryPrefix().getCountry().equals(country)).collect(Collectors.toList());
    }
}
