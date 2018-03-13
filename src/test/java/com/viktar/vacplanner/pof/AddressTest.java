package com.viktar.vacplanner.pof;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class AddressTest extends PofBeanTest<Address> {

    private final static String CONTACT_NAME = "Bob";
    private final static String ADDRESS_LINE = "525 Market St, Apt.2";
    private final static String CITY = "San Francisco";
    private final static StateUs STATE_US = StateUs.CALIFORNIA;
    private final static String REGION = "none";
    private final static String ZIP_CODE = "94105";
    private final static String COUNTRY = "US";

    @Test
    @Override
    public void readExternal() throws IOException {
        when(pofReader.readString(Address.CONTACT_NAME)).thenReturn(CONTACT_NAME);
        when(pofReader.readString(Address.ADDRESS_LINE)).thenReturn(ADDRESS_LINE);
        when(pofReader.readString(Address.CITY)).thenReturn(CITY);
        when(pofReader.readObject(Address.STATE_US)).thenReturn(STATE_US);
        when(pofReader.readString(Address.REGION)).thenReturn(REGION);
        when(pofReader.readString(Address.ZIP_CODE)).thenReturn(ZIP_CODE);
        when(pofReader.readString(Address.COUNTRY)).thenReturn(COUNTRY);

        super.readExternal();

        assertEquals(CONTACT_NAME, beanInstance.getContactName());
        assertEquals(ADDRESS_LINE, beanInstance.getAddressLine());
        assertEquals(CITY, beanInstance.getCity());
        assertEquals(STATE_US, beanInstance.getStateUs());
        assertEquals(ZIP_CODE, beanInstance.getZipCode());
        assertEquals(REGION, beanInstance.getRegion());
        assertEquals(COUNTRY, beanInstance.getCountry());
    }

    @Test
    @Override
    public void writeExternal() throws IOException {
        super.writeExternal();

        verify(pofWriter, times(1)).writeString(eq(Address.CONTACT_NAME), eq(CONTACT_NAME));
        verify(pofWriter, times(1)).writeString(eq(Address.ADDRESS_LINE), eq(ADDRESS_LINE));
        verify(pofWriter, times(1)).writeString(eq(Address.CITY), eq(CITY));
        verify(pofWriter, times(1)).writeObject(eq(Address.STATE_US), eq(STATE_US));
        verify(pofWriter, times(1)).writeString(eq(Address.REGION), eq(REGION));
        verify(pofWriter, times(1)).writeString(eq(Address.ZIP_CODE), eq(ZIP_CODE));
        verify(pofWriter, times(1)).writeString(eq(Address.COUNTRY), eq(COUNTRY));
    }

    @Test
    @Override
    public void getImplVersion() {
        beanInstance = getEmptyBeanInstance();
        assertTrue(beanInstance.getImplVersion() == Hotel.VERSION);
    }

    @Test
    @Override
    public void toStringMethod() {
        assertEquals(String.format("Address[contactName=%s, addressLine=%s, city=%s, stateUs=%s, region=%s, zipCode=%s, country=%s]",
                CONTACT_NAME,
                ADDRESS_LINE,
                CITY,
                STATE_US,
                REGION,
                ZIP_CODE,
                COUNTRY),
                getPopulatedBeanInstance().toString());
    }

    @Override
    protected Address getEmptyBeanInstance() {
        return new Address();
    }

    @Override
    protected Address getPopulatedBeanInstance() {
        Address bean = new Address();
        bean.setContactName(CONTACT_NAME);
        bean.setAddressLine(ADDRESS_LINE);
        bean.setCity(CITY);
        bean.setZipCode(ZIP_CODE);
        bean.setStateUs(STATE_US);
        bean.setRegion(REGION);
        bean.setCountry(COUNTRY);
        return bean;
    }

    @Override
    protected Address getUniquePopulatedBeanInstance() {
        Address bean = new Address();
        bean.setContactName(UNIQUE_STR);
        bean.setAddressLine(UNIQUE_STR);
        bean.setCity(UNIQUE_STR);
        bean.setZipCode(UNIQUE_STR);
        bean.setStateUs(StateUs.ALASKA);
        bean.setRegion(UNIQUE_STR);
        bean.setCountry(UNIQUE_STR);
        return bean;
    }

    @Override
    protected List<Address> getAllVarietiesOfTheBeanInstance() {
        List<Address> beans = super.getAllVarietiesOfTheBeanInstance();

        Address bean = getEmptyBeanInstance();
        bean.setContactName(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setContactName(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setAddressLine(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setAddressLine(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setCity(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setCity(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setZipCode(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setZipCode(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setStateUs(StateUs.AMERICAN_SAMOA);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setStateUs(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setRegion(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setRegion(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setCountry(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setCountry(null);
        beans.add(bean);

        return beans;
    }
}