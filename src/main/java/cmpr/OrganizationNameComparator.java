package cmpr;

import productdata.Organization;

import java.util.Comparator;

public class OrganizationNameComparator implements Comparator<Organization> {
    @Override
    public int compare(Organization a, Organization b) {
        return a.getName().compareTo(b.getName());
    }
}
