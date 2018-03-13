package com.viktar.imc.coherence.pof;

import com.viktar.imc.coherence.vacplanner.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class TripTest extends PofBeanTest<Trip> {

    private static final String DEPARTURE = "SFO";
    private static final String DESTINATION = "MBJ";

    private static final LocalDate START_DATE = LocalDate.now().plusDays(10);
    private static final LocalDate END_DATE = LocalDate.now().plusDays(15);

    private final URL URL = new URL("https://www.viktarx.com");

    private Hotel hotel = new Hotel();
    private Price price = new Price();
    private Address address = new Address();

    public TripTest() throws Exception {
    }

    @Before
    public void setup() {
        address.setContactName("Bob");
        address.setAddressLine("6 Jones St, Apt.1");
        address.setCity("San Francisco");
        address.setZipCode("94102");
        address.setStateUs(StateUs.CALIFORNIA);
        address.setRegion("N/A");
        address.setCountry("US");

        hotel.setName("Hilton");
        hotel.setAddress(address);
        hotel.setType(HotelType.BED_AND_BREAKFAST);
        hotel.setStars(4.5);
        hotel.setRating(5.0);
        hotel.setUrl(URL);

        price.setOriginalPriceInUsd(99.99);
        price.setDiscountPriceInUsd(9.99);
    }

    @Test
    @Override
    public void readExternal() throws IOException {
        when(pofReader.readString(Trip.DEPARTURE_INDEX)).thenReturn(DEPARTURE);
        when(pofReader.readString(Trip.DESTINATION_INDEX)).thenReturn(DESTINATION);
        when(pofReader.readLocalDate(Trip.START_DATE_INDEX)).thenReturn(START_DATE);
        when(pofReader.readLocalDate(Trip.END_DATE_INDEX)).thenReturn(END_DATE);
        when(pofReader.readObject(Trip.HOTEL_INDEX)).thenReturn(hotel);
        when(pofReader.readObject(Trip.PRICE_INDEX)).thenReturn(price);
        when(pofReader.readObject(Trip.URL_INDEX)).thenReturn(URL);

        super.readExternal();

        assertEquals(DEPARTURE, beanInstance.getDeparture());
        assertEquals(DESTINATION, beanInstance.getDestination());
        assertEquals(START_DATE, beanInstance.getStartDate());
        assertEquals(END_DATE, beanInstance.getEndDate());
        assertEquals(hotel, beanInstance.getHotel());
        assertEquals(price, beanInstance.getPrice());
        assertEquals(URL, beanInstance.getUrl());
    }

    @Test
    @Override
    public void writeExternal() throws IOException {
        super.writeExternal();

        verify(pofWriter, times(1)).writeString(eq(Trip.DEPARTURE_INDEX), eq(DEPARTURE));
        verify(pofWriter, times(1)).writeString(eq(Trip.DESTINATION_INDEX), eq(DESTINATION));
        verify(pofWriter, times(1)).writeDate(eq(Trip.START_DATE_INDEX), eq(START_DATE));
        verify(pofWriter, times(1)).writeDate(eq(Trip.END_DATE_INDEX), eq(END_DATE));
        verify(pofWriter, times(1)).writeObject(eq(Trip.PRICE_INDEX), eq(price));
        verify(pofWriter, times(1)).writeObject(eq(Trip.HOTEL_INDEX), eq(hotel));
        verify(pofWriter, times(1)).writeObject(eq(Trip.URL_INDEX), eq(URL));
    }

    @Test
    @Override
    public void getImplVersion() {
        beanInstance = getEmptyBeanInstance();
        assertTrue(beanInstance.getImplVersion() == Trip.VERSION);
    }

    @Test
    @Override
    public void toStringMethod() {
        assertEquals(String.format("Trip[departure=%s, destination=%s, startDate=%s, endDate=%s, price=%s, hotel=%s, url=%s]",
                DEPARTURE,
                DESTINATION,
                START_DATE,
                END_DATE,
                price,
                hotel,
                URL),
                getPopulatedBeanInstance().toString());
    }

    @Override
    protected Trip getEmptyBeanInstance() {
        return new Trip();
    }

    @Override
    protected Trip getPopulatedBeanInstance() {
        Trip bean = new Trip();
        bean.setDeparture(DEPARTURE);
        bean.setDestination(DESTINATION);
        bean.setStartDate(START_DATE);
        bean.setEndDate(END_DATE);
        bean.setPrice(price);
        bean.setHotel(hotel);
        bean.setUrl(URL);
        return bean;
    }

    @Override
    protected Trip getUniquePopulatedBeanInstance() {
        Trip bean = new Trip();
        bean.setDeparture(UNIQUE_STR);
        bean.setDestination(UNIQUE_STR);
        bean.setStartDate(LocalDate.now().plusDays((int) UNIQUE_NUM));
        bean.setEndDate(LocalDate.now().plusDays((int) UNIQUE_NUM));
        bean.setPrice(price);
        bean.setHotel(hotel);
        bean.setUrl(URL);
        return bean;
    }

    @Override
    protected List<Trip> getAllVarietiesOfTheBeanInstance() {
        List<Trip> beans = super.getAllVarietiesOfTheBeanInstance();

        Trip bean = getEmptyBeanInstance();
        bean.setDeparture(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setDeparture(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setDestination(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setDestination(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setStartDate(LocalDate.now().plusDays((int) UNIQUE_NUM));
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setStartDate(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setEndDate(LocalDate.now().plusDays((int) UNIQUE_NUM));
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setEndDate(null);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setHotel(null);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setPrice(null);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setUrl(null);
        beans.add(bean);

        return beans;
    }
}