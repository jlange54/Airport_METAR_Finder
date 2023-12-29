package objects;

public class CountryPrefix {
    private String prefix;
    private String country;

    public CountryPrefix(String prefix, String country) {
        this.prefix = prefix;
        this.country = country;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CountryPrefix{" +
                "prefix='" + prefix + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
