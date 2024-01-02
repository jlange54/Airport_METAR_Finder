package backend.objects.metar;

public class Clouds {
    /**
     * repr requires a value like: FEW025
     */
    private String repr;
    /**
     * altitude requires a value like: 25 or 300
     */
    private int altitude;
    /**
     * type requires a value like: FEW or BKN
     */
    private String type;
    private String modifier;

    public Clouds(String repr, int altitude, String type, String modifier) {
        this.repr = repr;
        this.altitude = altitude;
        this.type = type;
        this.modifier = modifier;
    }

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "repr='" + repr + '\'' +
                ", altitude=" + altitude +
                ", type='" + type + '\'' +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}
