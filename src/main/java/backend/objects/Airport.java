package backend.objects;

/**
 * Object Airport contains datasets for ICAO Code, Name, Latitude, Longitude, Elevation, Transition Altitude, Transition Level & longest Runway
 */
public class Airport {
    /**
     * icaoCode must contain the 4 char ICAO Identifier
     */
    private String icaoCode = null;
    private CountryPrefix countryPrefix = null;
    /**
     * name must contain the name of the Airport
     */
    private String name = null;
    /**
     * latitude must contain the latitude of the airport in decimal degrees
     */
    private double latitude = -9999;
    /**
     * longitude must contain the longitude of the airport in decimal degrees
     */
    private double longitude = -9999;
    /**
     * elevation must contain the airport elevation in feet
     */
    private int elevation = -9999;
    /**
     * transitionAltitude can contain the transitionAltitude in feet
     */
    private int transitionAltitude = -9999;
    /**
     * transitionLevel can contain the transitionLevel in feet
     */
    private int transitionLevel = -9999;
    /**
     * longestRunway must contain the longestRunway in feet
     */
    private int longestRunway = -9999;

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public int getTransitionAltitude() {
        return transitionAltitude;
    }

    public void setTransitionAltitude(int transitionAltitude) {
        this.transitionAltitude = transitionAltitude;
    }

    public int getTransitionLevel() {
        return transitionLevel;
    }

    public void setTransitionLevel(int transitionLevel) {
        this.transitionLevel = transitionLevel;
    }

    public int getLongestRunway() {
        return longestRunway;
    }

    public void setLongestRunway(int longestRunway) {
        this.longestRunway = longestRunway;
    }

    public CountryPrefix getCountryPrefix() {
        return countryPrefix;
    }

    public void setCountryPrefix(CountryPrefix countryPrefix) {
        this.countryPrefix = countryPrefix;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "icaoCode='" + icaoCode + '\'' +
                ", countryPrefix=" + countryPrefix +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", elevation=" + elevation +
                ", transitionAltitude=" + transitionAltitude +
                ", transitionLevel=" + transitionLevel +
                ", longestRunway=" + longestRunway +
                '}';
    }
}
