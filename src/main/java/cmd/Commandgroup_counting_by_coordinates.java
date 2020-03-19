package cmd;

import Control.TableController;
import productdata.Coordinates;
import productdata.Product;

import java.io.IOException;
import java.util.*;

public class Commandgroup_counting_by_coordinates implements Command {
    @Override
    public void execute(String[] args) throws IOException {
        int count = 1;
        List<Product> products = new ArrayList<>(TableController.getCurrentTable().getProducts());
        Map<String, Integer> map = new HashMap<>();
        for (Product p : products) {
            map.put(p.getCoordinates().output(),0);
        }
        for (Product p : products) {
            for(Map.Entry<String, Integer> m : map.entrySet()){
                if(p.getCoordinates().output().compareTo(m.getKey())==0){
                    m.setValue(m.getValue()+1);
                    break;
                }
            }
        }
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println("По координатам: " + m.getKey() + " находится " + m.getValue() + " продукта(ов).");
        }
    }

    @Override
    public String toString() {
        return "group_counting_by_coordinates";
    }
}
