package backend.objects.metar;

public class Altimeter {
    /**
     * repr requires a value like: Q0990 or A3005, depending on if QNH or inches in use
     */
    private String repr;
    /**
     * value requires the raw value of the altimeter. Like: 990 or 30.05
     */
    private double value;

    public Altimeter(String repr, double value) {
        this.repr = repr;
        this.value = value;
    }

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Altimeter{" +
                "repr='" + repr + '\'' +
                ", value=" + value +
                '}';
    }
}
