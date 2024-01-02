package backend.objects.metar;

public class Visibility {
    /**
     * repr requires a value like: 6000 or CAVOK
     */
    private String repr;
    /**
     * value requires a value like: 9999
     */
    private int value;

    public Visibility(String repr, int value) {
        this.repr = repr;
        this.value = value;
    }

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Visibility{" +
                "repr='" + repr + '\'' +
                ", value=" + value +
                '}';
    }
}
