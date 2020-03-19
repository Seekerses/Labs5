package cmpr;

import productdata.Product;

import java.util.Comparator;

public class ProductIDComparator implements Comparator<Product> {

    @Override
    public int compare(Product a, Product b) {
        if(a.getId()> b.getId())
            return 1;
        else if(a.getId()< b.getId())
            return -1;
        else
            return 0;
    }
}
