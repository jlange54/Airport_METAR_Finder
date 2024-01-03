package frontend;

import backend.AvwxApi;
import backend.MetarParser;
import helper.Runtime;

public class Main {
    public static void main(String[] args) throws Exception {
        Runtime.start();

        AMFApplication.main(args);
//        System.out.println(AvwxApi.getMetarForStation("KBAB"));
//        System.out.println(MetarParser.parse("{\"altimeter\":{\"repr\":\"A3010\",\"spoken\":\"three zero point one zero\",\"value\":30.1},\"clouds\":[{\"altitude\":34,\"modifier\":null,\"repr\":\"FEW034\",\"type\":\"FEW\"},{\"altitude\":60,\"modifier\":null,\"repr\":\"BKN060\",\"type\":\"BKN\"},{\"altitude\":85,\"modifier\":null,\"repr\":\"OVC085\",\"type\":\"OVC\"}],\"density_altitude\":-400,\"dewpoint\":{\"repr\":\"09\",\"spoken\":\"nine\",\"value\":9},\"flight_rules\":\"VFR\",\"meta\":{\"cache-timestamp\":\"2024-01-02T23:34:04.332000Z\",\"stations_updated\":\"2023-10-28\",\"timestamp\":\"2024-01-02T23:35:01.539273Z\"},\"other\":[],\"pressure_altitude\":-67,\"raw\":\"KBAB 022314Z AUTO 23007KT 10SM -DZ FEW034 BKN060 OVC085 12/09 A3010 RMK AO2 DZB14 SLP196 $\",\"relative_humidity\":0.8186649539519323,\"remarks\":\"RMK AO2 DZB14 SLP196 $\",\"remarks_info\":{\"codes\":[{\"repr\":\"$\",\"value\":\"ASOS requires maintenance\"},{\"repr\":\"AO2\",\"value\":\"Automated with precipitation sensor\"},{\"repr\":\"DZB14\",\"value\":\"Drizzle began at :14\"}],\"dewpoint_decimal\":null,\"maximum_temperature_24\":null,\"maximum_temperature_6\":null,\"minimum_temperature_24\":null,\"minimum_temperature_6\":null,\"precip_24_hours\":null,\"precip_36_hours\":null,\"precip_hourly\":null,\"pressure_tendency\":null,\"sea_level_pressure\":{\"repr\":\"SLP196\",\"spoken\":\"one zero one nine point six\",\"value\":1019.6},\"snow_depth\":null,\"sunshine_minutes\":null,\"temperature_decimal\":null},\"runway_visibility\":[],\"sanitized\":\"KBAB 022314Z 23007KT 10SM -DZ FEW034 BKN060 OVC085 12/09 A3010 RMK AO2 DZB14 SLP196 $\",\"station\":\"KBAB\",\"temperature\":{\"repr\":\"12\",\"spoken\":\"one two\",\"value\":12},\"time\":{\"dt\":\"2024-01-02T23:14:00Z\",\"repr\":\"022314Z\"},\"units\":{\"accumulation\":\"in\",\"altimeter\":\"inHg\",\"altitude\":\"ft\",\"temperature\":\"C\",\"visibility\":\"sm\",\"wind_speed\":\"kt\"},\"visibility\":{\"repr\":\"10\",\"spoken\":\"one zero\",\"value\":10},\"wind_direction\":{\"repr\":\"230\",\"spoken\":\"two three zero\",\"value\":230},\"wind_gust\":null,\"wind_speed\":{\"repr\":\"07\",\"spoken\":\"seven\",\"value\":7},\"wind_variable_direction\":[],\"wx_codes\":[{\"repr\":\"-DZ\",\"value\":\"Light Drizzle\"}]}"));

//        System.out.println(backend.Filter.filterByIcaoCode("EDKK", airportList));
//          System.out.println(Filter.filterByCountry("Canada", airportList));
//        System.out.println(backend.CountryList.getAllCountries());
//        System.out.println(airportList);

        Runtime.end(Runtime.timeUnit.seconds, Runtime.type.program);
    }
}