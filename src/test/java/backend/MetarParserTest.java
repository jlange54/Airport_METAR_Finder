package backend;

import backend.objects.metar.Metar;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MetarParserTest {



    @Test
    void parse() throws IOException {
         String jsonString = "{\"" +
            "altimeter\":{\"repr\":\"A3009\",\"spoken\":\"three zero point zero nine\",\"value\":30.09},\"" +
            "clouds\":[" +
            "{\"altitude\":5,\"modifier\":null,\"repr\":\"SCT005\",\"type\":\"SCT\"}," +
            "{\"altitude\":11,\"modifier\":null,\"repr\":\"BKN011\",\"type\":\"BKN\"}," +
            "{\"altitude\":17,\"modifier\":null,\"repr\":\"OVC017\",\"type\":\"OVC\"}" +
            "],\"" +
            "density_altitude\":2466,\"" +
            "dewpoint\":{\"repr\":\"02\",\"spoken\":\"two\",\"value\":2},\"" +
            "flight_rules\":\"MVFR\",\"" +
            "meta\":{\"stations_updated\":\"2023-10-28\",\"timestamp\":\"2024-01-02T18:42:18.548816Z\"},\"" +
            "other\":[],\"" +
            "pressure_altitude\":3088,\"" +
            "raw\":\"KMHS 021833Z AUTO 00000KT 4SM -RA BR SCT005 BKN011 OVC017 03/02 A3009 RMK AO2 CIG 007V014 P0001 T00330022\",\"" +
            "relative_humidity\":0.9249173515197439,\"" +
            "remarks\":\"RMK AO2 CIG 007V014 P0001 T00330022\",\"" +
            "remarks_info\":{\"codes\":[{\"repr\":\"AO2\",\"value\":\"Automated with precipitation sensor\"}],\"" +
            "dewpoint_decimal\":{\"repr\":\"0022\",\"spoken\":\"two point two\",\"value\":2.2},\"" +
            "maximum_temperature_24\":null,\"" +
            "maximum_temperature_6\":null,\"" +
            "minimum_temperature_24\":null,\"" +
            "minimum_temperature_6\":null,\"" +
            "precip_24_hours\":null,\"" +
            "precip_36_hours\":null,\"" +
            "precip_hourly\":{\"repr\":\"P0001\",\"spoken\":\"zero point zero one\",\"value\":0.01},\"" +
            "pressure_tendency\":null,\"" +
            "sea_level_pressure\":null,\"" +
            "snow_depth\":null,\"" +
            "sunshine_minutes\":null,\"" +
            "temperature_decimal\":{\"repr\":\"0033\",\"spoken\":\"three point three\",\"value\":3.3}},\"" +
            "runway_visibility\":[],\"" +
            "sanitized\":\"KMHS 021833Z 00000KT 4SM -RA BR SCT005 BKN011 OVC017 03/02 A3009 RMK AO2 CIG 007V014 P0001 T00330022\",\"" +
            "station\":\"KMHS\",\"" +
            "temperature\":{\"repr\":\"03\",\"spoken\":\"three\",\"value\":3},\"" +
            "time\":{\"dt\":\"2024-01-02T18:33:00Z\",\"repr\":\"021833Z\"},\"" +
            "units\":{\"accumulation\":\"in\",\"altimeter\":\"inHg\",\"altitude\":\"ft\",\"temperature\":\"C\",\"visibility\":\"sm\",\"wind_speed\":\"kt\"},\"" +
            "visibility\":{\"repr\":\"4\",\"spoken\":\"four\",\"value\":4},\"" +
            "wind_direction\":{\"repr\":\"000\",\"spoken\":\"zero zero zero\",\"value\":0},\"" +
            "wind_gust\":null,\"" +
            "wind_speed\":{\"repr\":\"00\",\"spoken\":\"zero\",\"value\":0},\"" +
            "wind_variable_direction\":[],\"" +
            "wx_codes\":[{\"repr\":\"-RA\",\"value\":\"Light Rain\"},{\"repr\":\"BR\",\"value\":\"Mist\"}]}";

        Metar testMetar = MetarParser.parse(jsonString);
        System.out.println(testMetar);

        assertEquals(testMetar.getAltimeter().getRepr(), "A3009");
        assertEquals(testMetar.getAltimeter().getValue(), 30.09);

        assertEquals(testMetar.getWindGusts(), 0);
    }
}