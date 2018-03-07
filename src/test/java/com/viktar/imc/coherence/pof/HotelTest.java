package com.viktar.imc.coherence.pof;

import com.viktar.imc.coherence.vacplanner.Hotel;
import com.viktar.imc.coherence.vacplanner.Price;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class HotelTest extends PofBeanTest<Hotel> {

    @Test
    @Override
    public void readExternal() throws IOException {
        when(pofReader.readString(Hotel.NAME_INDEX)).thenReturn("Hilton");
        when(pofReader.readString(Hotel.ADDRESS_INDEX)).thenReturn("505 California St, San Francisco, 94105, CA, US");
        when(pofReader.readString(Hotel.TYPE_INDEX)).thenReturn("Resort");
        when(pofReader.readDouble(Hotel.STARS_INDEX)).thenReturn(4.5);
        when(pofReader.readDouble(Hotel.RATING_INDEX)).thenReturn(5.0);
        when(pofReader.readString(Hotel.URL_INDEX)).thenReturn("https://www.hilton.com");

        super.readExternal();

        assertEquals("Hilton", beanInstance.getName());
        assertEquals("505 California St, San Francisco, 94105, CA, US", beanInstance.getAddress());
        assertEquals("Resort", beanInstance.getType());
        assertTrue(4.5 == beanInstance.getStars());
        assertTrue(5.0 == beanInstance.getRating());
        assertEquals(new URL("https://www.hilton.com"), beanInstance.getUrl());

    }

    @Test
    @Override
    public void writeExternal() throws IOException {
        super.writeExternal();

        verify(pofWriter, times(1)).writeString(eq(Hotel.NAME_INDEX), eq("Hilton"));
        verify(pofWriter, times(1)).writeString(eq(Hotel.ADDRESS_INDEX), eq("505 California St, San Francisco, 94105, CA, US"));
        verify(pofWriter, times(1)).writeString(eq(Hotel.TYPE_INDEX), eq("Resort"));
        verify(pofWriter, times(1)).writeDouble(eq(Hotel.STARS_INDEX), eq(4.5));
        verify(pofWriter, times(1)).writeDouble(eq(Hotel.RATING_INDEX), eq(5.0));
        verify(pofWriter, times(1)).writeString(eq(Hotel.URL_INDEX), eq("https://www.hilton.com"));

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
        assertEquals("Hotel[name=Hilton, address=505 California St, San Francisco, 94105, CA, US, type=Resort, stars=4.5, rating=5.0, url=https://www.hilton.com]", getPopulatedBeanInstance().toString());
    }

    @Override
    protected Hotel getEmptyBeanInstance() {
        return new Hotel();
    }

    @Override
    protected Hotel getPopulatedBeanInstance() {
        Hotel bean = new Hotel();
        bean.setName("Hilton");
        bean.setAddress("505 California St, San Francisco, 94105, CA, US");
        bean.setType("Resort");
        bean.setStars(4.5);
        bean.setRating(5.0);
        try {
            bean.setUrl(new URL("https://www.hilton.com"));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
        return bean;
    }

    @Override
    protected Hotel getUniquePopulatedBeanInstance() {
        Hotel bean = new Hotel();
        bean.setName(String.valueOf(System.currentTimeMillis()));
        bean.setAddress(String.valueOf(System.currentTimeMillis()));
        bean.setType(String.valueOf(System.currentTimeMillis()));
        bean.setStars(System.currentTimeMillis());
        bean.setRating(System.currentTimeMillis());
        try {
            bean.setUrl(new URL("https://www." + String.valueOf(System.currentTimeMillis()) + ".com"));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
        return bean;
    }

    @Override
    protected List<Hotel> getAllVarietiesOfTheBeanInstance() {
        List<Hotel> beans = super.getAllVarietiesOfTheBeanInstance();

        Hotel bean = getEmptyBeanInstance();
        bean.setName(String.valueOf(System.currentTimeMillis()));
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setName(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setAddress(String.valueOf(System.currentTimeMillis()));
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setAddress(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setType(String.valueOf(System.currentTimeMillis()));
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setType(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setStars(System.currentTimeMillis());
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setRating(System.currentTimeMillis());
        beans.add(bean);

        bean = getEmptyBeanInstance();
        try {
            bean.setUrl(new URL("https://www." + String.valueOf(System.currentTimeMillis()) + ".com"));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setUrl(null);
        beans.add(bean);

        return beans;
    }
}