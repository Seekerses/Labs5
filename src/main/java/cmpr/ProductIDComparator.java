package cmpr;

import productdata.Product;

public class ProductIDComparator implements IDComparator<Product> {

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
