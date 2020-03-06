package cmpr;

import productdata.Organization;

public class OrganizationNameComparator implements NameComparator<Organization> {
    @Override
    public int compare(Organization a, Organization b) {
        return a.getName().compareTo(b.getName());
    }
}
