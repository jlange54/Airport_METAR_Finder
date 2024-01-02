package backend.objects.metar;

import java.time.LocalDateTime;
import java.util.List;

public class Metar {
    private Altimeter altimeter;
    private List<Clouds> clouds;
    private int densityAltitude;
    private int dewpoint;
    private String flightRules;
    private LocalDateTime timestamp;
    private int pressureAltitude;
    private String raw;
    private double relativeHumidity;
    private String remarks;
    private int temperature;
    private Units units;
    private Visibility visibility;
    private int windDirection;
    private int windGusts;
    private int windSpeed;
    private List<Integer> windVariableDirection;
    private List<WxCodes> wxCode;

    public Altimeter getAltimeter() {
        return altimeter;
    }

    public void setAltimeter(Altimeter altimeter) {
        this.altimeter = altimeter;
    }

    public List<Clouds> getClouds() {
        return clouds;
    }

    public void setClouds(List<Clouds> clouds) {
        this.clouds = clouds;
    }

    public int getDensityAltitude() {
        return densityAltitude;
    }

    public void setDensityAltitude(int densityAltitude) {
        this.densityAltitude = densityAltitude;
    }

    public int getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(int dewpoint) {
        this.dewpoint = dewpoint;
    }

    public String getFlightRules() {
        return flightRules;
    }

    public void setFlightRules(String flightRules) {
        this.flightRules = flightRules;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getPressureAltitude() {
        return pressureAltitude;
    }

    public void setPressureAltitude(int pressureAltitude) {
        this.pressureAltitude = pressureAltitude;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public double getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public int getWindGusts() {
        return windGusts;
    }

    public void setWindGusts(int windGusts) {
        this.windGusts = windGusts;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public List<Integer> getWindVariableDirection() {
        return windVariableDirection;
    }

    public void setWindVariableDirection(List<Integer> windVariableDirection) {
        this.windVariableDirection = windVariableDirection;
    }

    public List<WxCodes> getWxCode() {
        return wxCode;
    }

    public void setWxCode(List<WxCodes> wxCode) {
        this.wxCode = wxCode;
    }

    @Override
    public String toString() {
        return "Metar{" +
                "altimeter=" + altimeter +
                ", clouds=" + clouds +
                ", densityAltitude=" + densityAltitude +
                ", dewpoint=" + dewpoint +
                ", flightRules='" + flightRules + '\'' +
                ", timestamp=" + timestamp +
                ", pressureAltitude=" + pressureAltitude +
                ", raw='" + raw + '\'' +
                ", relativeHumidity=" + relativeHumidity +
                ", remarks='" + remarks + '\'' +
                ", temperature=" + temperature +
                ", units=" + units +
                ", visibility=" + visibility +
                ", windDirection=" + windDirection +
                ", windGusts=" + windGusts +
                ", windSpeed=" + windSpeed +
                ", windVariableDirection=" + windVariableDirection +
                ", wxCode=" + wxCode +
                '}';
    }
}
