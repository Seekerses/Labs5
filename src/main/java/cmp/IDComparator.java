package cmp;

import productdata.Product;

import java.util.Comparator;
import java.util.Map;

public class IDComparator implements Comparator<Product> {

    private Map<String, Product> map;

    public IDComparator(Map<String, Product> map) {
        this.map = map;
    }

    @Override
    public int compare(Product a, Product b) {
        return map.get(a).compareTo(map.get(b));
    }
}
