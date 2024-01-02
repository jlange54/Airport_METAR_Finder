package backend;

import backend.objects.metar.*;
import helper.Json;
import org.codehaus.jackson.JsonNode;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MetarParser {
    public static Metar parse (String input) throws IOException {
        String sanitizedInput = input.replace("body:", "");

        Altimeter altimeter = parseAltimeter(sanitizedInput);
        List<Clouds> clouds = parseClouds(sanitizedInput);
        int densityAltitude = parseDensityAltitude(sanitizedInput);
        int dewpoint = parseDewpoint(sanitizedInput);
        String flightRules = parseFlightRules(sanitizedInput);
        int pressureAltitude = parsePressureAltitude(sanitizedInput);
        String raw = parseRaw(sanitizedInput);
        double relativeHumidity = parseRelativeHumidity(sanitizedInput);
        String remarks = parseRemarks(sanitizedInput);
        int temperature = parseTemperature(sanitizedInput);
        LocalDateTime timestamp = parseTimestamp(sanitizedInput);
        Units units = parseUnits(sanitizedInput);
        Visibility visibility = parseVisibility(sanitizedInput);
        int windDirection = parseWindDirection(sanitizedInput);
        int windGusts = parseWindGusts(sanitizedInput);
        int windSpeed = parseWindSpeed(sanitizedInput);
        int[] windVariableDirection = parseWindVariableDirection(sanitizedInput);
        List<WxCodes> wxCodes = parseWxCodes(sanitizedInput);

        return new Metar(altimeter,clouds,densityAltitude,dewpoint,flightRules,pressureAltitude,raw,relativeHumidity,remarks,temperature,timestamp,units,visibility,windDirection,windGusts,windSpeed,windVariableDirection,wxCodes);
    }

    private static Altimeter parseAltimeter (String sanitizedInput) throws IOException {
        String repr = Json.parse(sanitizedInput).get("altimeter").get("repr").toString().replace("\"", "");
        double value = Json.parse(sanitizedInput).get("altimeter").get("value").asDouble();
        return new Altimeter(repr, value);
    }

    private static List<Clouds> parseClouds (String sanitizedInput) throws IOException {
        List<Clouds> result = new ArrayList<>();
        JsonNode array = Json.parse(sanitizedInput).get("clouds");
        for (int i=0; i<array.size(); i++) {
            String repr = array.get(i).get("repr").toString().replace("\"", "");
            int altitude = array.get(i).get("altitude").asInt();
            String type = array.get(i).get("type").toString().replace("\"", "");
            String modifier = array.get(i).get("modifier").toString().replace("\"", "");
            result.add(new Clouds(repr,altitude,type,modifier));
        }
        return result;
    }

    private static int parseDensityAltitude (String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("density_altitude").asInt();
    }

    private static int parseDewpoint(String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("dewpoint").get("value").asInt();
    }
    private static String parseFlightRules(String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("flight_rules").toString().replace("\"", "");
    }

    private static int parsePressureAltitude(String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("pressure_altitude").asInt();
    }

    private static String parseRaw(String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("raw").toString().replace("\"", "");
    }

    private static double parseRelativeHumidity(String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("relative_humidity").asDouble();
    }

    private static String parseRemarks(String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("remarks").toString().replace("\"", "");
    }

    private static int parseTemperature(String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("temperature").get("value").asInt();
    }

    private static LocalDateTime parseTimestamp (String sanitizedInput) throws IOException {
        String dateFromJson = Json.parse(sanitizedInput).get("time").get("dt").toString().replace("\"", "").replace("Z", "");
        return LocalDateTime.parse(dateFromJson, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    private static Units parseUnits(String sanitizedInput) throws IOException {
        String accumulation = Json.parse(sanitizedInput).get("units").get("accumulation").toString().replace("\"", "");
        String altimeter = Json.parse(sanitizedInput).get("units").get("altimeter").toString().replace("\"", "");
        String altitude = Json.parse(sanitizedInput).get("units").get("altitude").toString().replace("\"", "");
        String temperature = Json.parse(sanitizedInput).get("units").get("temperature").toString().replace("\"", "");
        String visibility = Json.parse(sanitizedInput).get("units").get("visibility").toString().replace("\"", "");
        String windSpeed = Json.parse(sanitizedInput).get("units").get("wind_speed").toString().replace("\"", "");

        return new Units(accumulation,altimeter,altitude,temperature,visibility,windSpeed);
    }

    private static Visibility parseVisibility(String sanitizedInput) throws IOException {
        String repr = Json.parse(sanitizedInput).get("visibility").get("repr").toString().replace("\"", "");
        int value = Json.parse(sanitizedInput).get("visibility").get("value").asInt();

        return new Visibility(repr,value);
    }

    private static int parseWindDirection(String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("wind_direction").get("value").asInt();
    }

    private static int parseWindGusts(String sanitizedInput) throws IOException {
        if(!Json.parse(sanitizedInput).get("wind_gust").toString().equals("null")) {
            return Json.parse(sanitizedInput).get("wind_gust").get("value").asInt();
        } else {
            return 0;
        }
    }

    private static int parseWindSpeed(String sanitizedInput) throws IOException {
        return Json.parse(sanitizedInput).get("wind_speed").get("value").asInt();
    }

    private static int[] parseWindVariableDirection(String sanitizedInput) throws IOException {
        int[] result = new int[2];
        JsonNode array = Json.parse(sanitizedInput).get("wind_variable_direction");
        if (array.size() > 2) {
            throw new IOException("WindVariableDirection Array larger than 2 @parseWindVariableDirection");
        }
        for (int i=0; i<array.size(); i++) {
            result[i] = array.get(i).get("value").asInt();
        }

        return result;
    }

    private static List<WxCodes> parseWxCodes(String sanitizedInput) throws IOException {
        List<WxCodes> result = new ArrayList<>();
        JsonNode array = Json.parse(sanitizedInput).get("wx_codes");
        for (int i=0; i<array.size(); i++) {
            String repr = array.get(i).get("repr").toString().replace("\"", "");
            String value = array.get(i).get("value").toString().replace("\"", "");
            result.add(new WxCodes(repr,value));
        }
        return result;
    }
}
