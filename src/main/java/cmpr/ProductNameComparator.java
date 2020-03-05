package cmpr;

import cmpr.NameComparator;

public class ProductNameComparator implements NameComparator<String> {

    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
}
