import helper.Runtime;
import objects.Airport;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Runtime.start();

        List<Airport> airportList = AirportList.generate();

//        System.out.println(Filter.filterByIcaoCode("EDKK", airportList));
          System.out.println(Filter.filterByCountry("Canada", airportList));
//        System.out.println(CountryList.getAllCountries());
//        System.out.println(airportList);

        Runtime.end(Runtime.timeUnit.ms, Runtime.type.program);
    }
}