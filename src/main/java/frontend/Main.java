package frontend;

import frontend.AMFApplication;
import helper.Runtime;

public class Main {
    public static void main(String[] args) throws Exception {
        Runtime.start();

        AMFApplication.main(args);


//        System.out.println(backend.Filter.filterByIcaoCode("EDKK", airportList));
//          System.out.println(Filter.filterByCountry("Canada", airportList));
//        System.out.println(backend.CountryList.getAllCountries());
//        System.out.println(airportList);

        Runtime.end(Runtime.timeUnit.seconds, Runtime.type.program);
    }
}