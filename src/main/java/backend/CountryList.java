package backend;

import helper.FileRW;
import helper.Regex;
import backend.objects.CountryPrefix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryList {

    private static final String countryPrefixListDirectory = CountryPrefix.class.getResource(Config.countryPrefixes_csv).getPath().substring(1);

    private static List<CountryPrefix> countryPrefixList = new ArrayList<>();

    public static List<CountryPrefix> generateCountryPrefixList () throws IOException {
        List<CountryPrefix> result = new ArrayList<>();

        for (String line : FileRW.read(countryPrefixListDirectory)) {
            result.add(new CountryPrefix(Regex.substitution(line, "(\\w*);(.*)", 1), Regex.substitution(line, "(\\w*);(.*)", 2)));
        }
        countryPrefixList = result;
        return result;
    }

    public static List<String> getAllCountries () throws Exception {
        if (countryPrefixList.isEmpty()) {
            throw new Exception("List countryPrefixList is not initialized // Run generateCountryPrefixList first");
        }

        List<String> result = new ArrayList<>();

        for (CountryPrefix countryPrefix : countryPrefixList) {
            result.add(countryPrefix.getCountry());
        }
        return result;
    }
}
