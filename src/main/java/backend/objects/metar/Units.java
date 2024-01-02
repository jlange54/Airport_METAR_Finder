package backend.objects.metar;

public class Units {
    /**
     * accumulation requires a value like: in
     */
    private String accumulation;
    /**
     * altimeter requires a value like: hPa or inches
     */
    private String altimeter;
    /**
     * altitude requires a value like: ft or m
     */
    private String altitude;
    /**
     * temperature requires a value like: C or F
     */
    private String temperature;
    /**
     * visibility requires a value like: m or sm
     */
    private String visibility;
    /**
     * windSpeed requires a value like: kt or m/s
     */
    private String windSpeed;

    public Units(String accumulation, String altimeter, String altitude, String temperature, String visibility, String windSpeed) {
        this.accumulation = accumulation;
        this.altimeter = altimeter;
        this.altitude = altitude;
        this.temperature = temperature;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
    }

    public String getAccumulation() {
        return accumulation;
    }

    public void setAccumulation(String accumulation) {
        this.accumulation = accumulation;
    }

    public String getAltimeter() {
        return altimeter;
    }

    public void setAltimeter(String altimeter) {
        this.altimeter = altimeter;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "Units{" +
                "accumulation='" + accumulation + '\'' +
                ", altimeter='" + altimeter + '\'' +
                ", altitude='" + altitude + '\'' +
                ", temperature='" + temperature + '\'' +
                ", visibility='" + visibility + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                '}';
    }
}
