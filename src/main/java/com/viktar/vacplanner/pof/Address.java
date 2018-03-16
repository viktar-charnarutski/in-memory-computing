package com.viktar.vacplanner.pof;

import com.tangosol.io.AbstractEvolvable;
import com.tangosol.io.pof.EvolvablePortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;

import java.io.IOException;

public class Address extends AbstractEvolvable implements EvolvablePortableObject {

    public final static int VERSION = 0;

    public static final int CONTACT_NAME = 0;
    public static final int ADDRESS_LINE = 1;
    public static final int CITY = 2;
    public static final int STATE_US = 3;
    public static final int REGION = 4;
    public static final int ZIP_CODE = 5;
    public static final int COUNTRY = 6;

    private String contactName;
    private String addressLine;
    private String city;
    private StateUs stateUs;
    private String region;
    private String zipCode;
    private String country;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public StateUs getStateUs() {
        return stateUs;
    }

    public void setStateUs(StateUs stateUs) {
        this.stateUs = stateUs;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (contactName != null ? !contactName.equals(address.contactName) : address.contactName != null) return false;
        if (addressLine != null ? !addressLine.equals(address.addressLine) : address.addressLine != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (stateUs != address.stateUs) return false;
        if (region != null ? !region.equals(address.region) : address.region != null) return false;
        if (zipCode != null ? !zipCode.equals(address.zipCode) : address.zipCode != null) return false;
        return country != null ? country.equals(address.country) : address.country == null;
    }

    @Override
    public int hashCode() {
        int result = contactName != null ? contactName.hashCode() : 0;
        result = 31 * result + (addressLine != null ? addressLine.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateUs != null ? stateUs.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Address[contactName=%s, addressLine=%s, city=%s, stateUs=%s, region=%s, zipCode=%s, country=%s]",
                contactName, addressLine, city, stateUs, region, zipCode, country);
    }

    @Override
    public int getImplVersion() {
        return VERSION;
    }

    @Override
    public void readExternal(PofReader pofReader) throws IOException {
        contactName = pofReader.readString(CONTACT_NAME);
        addressLine = pofReader.readString(ADDRESS_LINE);
        city = pofReader.readString(CITY);
        stateUs = StateUs.valueOf(pofReader.readString(STATE_US));
        region = pofReader.readString(REGION);
        zipCode = pofReader.readString(ZIP_CODE);
        country = pofReader.readString(COUNTRY);
    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {
        pofWriter.writeString(CONTACT_NAME, contactName);
        pofWriter.writeString(ADDRESS_LINE, addressLine);
        pofWriter.writeString(CITY, city);
        pofWriter.writeString(STATE_US, stateUs.toString());
        pofWriter.writeString(REGION, region);
        pofWriter.writeString(ZIP_CODE, zipCode);
        pofWriter.writeString(COUNTRY, country);
    }
}
