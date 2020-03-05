package cmpr;

import cmpr.Comparator;
import productdata.Organization;

public class OrganizationNameComparator implements Comparator<Organization> {
    @Override
    public int compare(Organization a, Organization b) {
        return a.getName().compareTo(b.getName());
    }
}
