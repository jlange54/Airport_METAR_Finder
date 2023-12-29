import backend.AirportList;
import backend.Filter;
import frontend.AMFApplication;
import helper.Runtime;
import backend.objects.Airport;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Runtime.start();

        AMFApplication.main(args);

        List<Airport> airportList = AirportList.generate();

//        System.out.println(backend.Filter.filterByIcaoCode("EDKK", airportList));
          System.out.println(Filter.filterByCountry("Canada", airportList));
//        System.out.println(backend.CountryList.getAllCountries());
//        System.out.println(airportList);

        Runtime.end(Runtime.timeUnit.ms, Runtime.type.program);
    }
}