package com.viktar.imc.coherence.pof;

import com.viktar.imc.coherence.vacplanner.Address;
import com.viktar.imc.coherence.vacplanner.Hotel;
import com.viktar.imc.coherence.vacplanner.HotelType;
import com.viktar.imc.coherence.vacplanner.StateUs;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class HotelTest extends PofBeanTest<Hotel> {

    private static final String NAME = "Hilton";
    private static final HotelType TYPE = HotelType.RESORT;
    private static final double STARS = 4.5;
    private static final double RATING = 5.0;
    private static URL URL;

    private static URL UNIQUE_URL;
    private Address address = new Address();

    @Before
    public void setup() throws Exception {
        URL = new URL("https://www.hilton.com");
        UNIQUE_URL = new URL("https://www." + UNIQUE_STR + ".com");

        address.setContactName("Bob");
        address.setAddressLine("6 Jones St, Apt.1");
        address.setCity("San Francisco");
        address.setZipCode("94102");
        address.setStateUs(StateUs.CALIFORNIA);
        address.setRegion("N/A");
        address.setCountry("US");
    }

    @Test
    @Override
    public void readExternal() throws IOException {
        when(pofReader.readString(Hotel.NAME_INDEX)).thenReturn(NAME);
        when(pofReader.readObject(Hotel.ADDRESS_INDEX)).thenReturn(address);
        when(pofReader.readObject(Hotel.TYPE_INDEX)).thenReturn(TYPE);
        when(pofReader.readDouble(Hotel.STARS_INDEX)).thenReturn(STARS);
        when(pofReader.readDouble(Hotel.RATING_INDEX)).thenReturn(RATING);
        when(pofReader.readObject(Hotel.URL_INDEX)).thenReturn(URL);

        super.readExternal();

        assertEquals(NAME, beanInstance.getName());
        assertEquals(address, beanInstance.getAddress());
        assertEquals(TYPE, beanInstance.getType());
        assertTrue(STARS == beanInstance.getStars());
        assertTrue(RATING == beanInstance.getRating());
        assertEquals(URL, beanInstance.getUrl());
    }

    @Test
    @Override
    public void writeExternal() throws IOException {
        super.writeExternal();

        verify(pofWriter, times(1)).writeString(eq(Hotel.NAME_INDEX), eq(NAME));
        verify(pofWriter, times(1)).writeObject(eq(Hotel.ADDRESS_INDEX), eq(address));
        verify(pofWriter, times(1)).writeObject(eq(Hotel.TYPE_INDEX), eq(TYPE));
        verify(pofWriter, times(1)).writeDouble(eq(Hotel.STARS_INDEX), eq(STARS));
        verify(pofWriter, times(1)).writeDouble(eq(Hotel.RATING_INDEX), eq(RATING));
        verify(pofWriter, times(1)).writeObject(eq(Hotel.URL_INDEX), eq(URL));
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
        assertEquals(String.format("Hotel[name=%s, address=%s, type=%s, stars=%s, rating=%s, url=%s]", NAME, address, TYPE, STARS, RATING, URL),
                getPopulatedBeanInstance().toString());
    }

    @Override
    protected Hotel getEmptyBeanInstance() {
        return new Hotel();
    }

    @Override
    protected Hotel getPopulatedBeanInstance() {
        Hotel bean = new Hotel();
        bean.setName(NAME);
        bean.setAddress(address);
        bean.setType(TYPE);
        bean.setStars(STARS);
        bean.setRating(RATING);
        bean.setUrl(URL);
        return bean;
    }

    @Override
    protected Hotel getUniquePopulatedBeanInstance() {
        Hotel bean = new Hotel();
        bean.setName(UNIQUE_STR);
        bean.setAddress(address);
        bean.setType(HotelType.CASINO);
        bean.setStars(UNIQUE_NUM);
        bean.setRating(UNIQUE_NUM);
        bean.setUrl(UNIQUE_URL);
        return bean;
    }

    @Override
    protected List<Hotel> getAllVarietiesOfTheBeanInstance() {
        List<Hotel> beans = super.getAllVarietiesOfTheBeanInstance();

        Hotel bean = getEmptyBeanInstance();
        bean.setName(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setName(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setAddress(address);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setAddress(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setType(HotelType.BED_AND_BREAKFAST);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setType(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setStars(UNIQUE_NUM);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setRating(UNIQUE_NUM);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setUrl(UNIQUE_URL);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setUrl(null);
        beans.add(bean);

        return beans;
    }
}