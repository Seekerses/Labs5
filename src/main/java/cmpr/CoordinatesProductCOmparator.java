package cmpr;

import productdata.Product;

import java.util.Comparator;

public class CoordinatesProductCOmparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getCoordinates().getY().equals(o2.getCoordinates().getY()) && o1.getCoordinates().getX()-o2.getCoordinates().getX()>-1 && o1.getCoordinates().getX()-o2.getCoordinates().getX()<1){
            return 0;
        }else{return -1;}
    }
}
