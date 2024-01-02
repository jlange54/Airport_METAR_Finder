package backend.objects.metar;

public class WxCodes {
    /**
     * repr requires a value like: RA or -SN
     */
    private String repr;
    /**
     *value requires a value like: Light Snow or Mist
     */
    private String value;

    public WxCodes(String repr, String value) {
        this.repr = repr;
        this.value = value;
    }

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "wxCodes{" +
                "repr='" + repr + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
