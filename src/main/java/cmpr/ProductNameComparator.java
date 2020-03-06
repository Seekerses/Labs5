package cmpr;

import cmpr.NameComparator;
import productdata.Product;

public class ProductNameComparator implements NameComparator<Product> {

    @Override
    public int compare(Product a, Product b) {
        return a.getName().compareTo(b.getName());
    }
}
