package cmpr;

import productdata.Organization;

public class OrganizationIDComparator implements IDComparator<Organization> {
    @Override
    public int compare(Organization a, Organization b) {
        if(a.getId()> b.getId())
            return 1;
        else if(a.getId()< b.getId())
            return -1;
        else
            return 0;
    }
}
