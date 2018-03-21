package com.viktar.vacplanner.pof;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class TripVariantsTest extends PofBeanTest<TripVariants> {

    private static final String DEPARTURE = "SFO";
    private static final String DESTINATION = "MBJ";

    private static final LocalDate START_DATE = LocalDate.now().plusDays(10);
    private static final LocalDate END_DATE = LocalDate.now().plusDays(15);

    private final URL URL = new URL("https://www.viktarx.com");

    private TripVariants tripVariantsThree;
    private TripVariants tripVariantsTwo;
    private TripVariants tripVariantsOne;

    private LinkedList<Trip> variantsThree = new LinkedList<>();
    private LinkedList<Trip> variantsTwo = new LinkedList<>();
    private LinkedList<Trip> variantsOne = new LinkedList<>();

    public TripVariantsTest() throws Exception {
    }

    @Before
    public void setup() {

        Trip tripVariant1 = new Trip();
        tripVariant1.setDeparture(DEPARTURE);
        tripVariant1.setDestination(DESTINATION);
        tripVariant1.setStartDate(START_DATE);
        tripVariant1.setEndDate(END_DATE);
        tripVariant1.setPrice(getPopulatedPrice());
        tripVariant1.setHotel(getPopulatedHotel());
        tripVariant1.setUrl(URL);
        variantsThree.add(tripVariant1);
        variantsTwo.add(tripVariant1);
        variantsOne.add(tripVariant1);

        Trip tripVariant2 = new Trip();
        tripVariant2.setDeparture(DEPARTURE);
        tripVariant2.setDestination(DESTINATION);
        tripVariant2.setStartDate(START_DATE);
        tripVariant2.setEndDate(END_DATE);
        tripVariant2.setPrice(getUniquePopulatedPrice());
        tripVariant2.setHotel(getUniquePopulatedHotel());
        tripVariant2.setUrl(URL);
        variantsThree.add(tripVariant2);
        variantsTwo.add(tripVariant2);

        Trip tripVariant3 = new Trip();
        tripVariant3.setDeparture(DEPARTURE);
        tripVariant3.setDestination(DESTINATION);
        tripVariant3.setStartDate(START_DATE);
        tripVariant3.setEndDate(END_DATE);
        tripVariant3.setPrice(getPopulatedPrice());
        tripVariant3.setHotel(getUniquePopulatedHotel());
        tripVariant3.setUrl(URL);
        variantsThree.add(tripVariant3);

        tripVariantsThree = new TripVariants();
        tripVariantsThree.setTripVariants(variantsThree);

        tripVariantsTwo = new TripVariants();
        tripVariantsTwo.setTripVariants(variantsTwo);

        tripVariantsOne = new TripVariants();
        tripVariantsOne.setTripVariants(variantsOne);
    }

    private Address getUniquePopulatedAddress() {
        Address address = new Address();
        address.setContactName(UNIQUE_STR);
        address.setAddressLine(UNIQUE_STR);
        address.setCity(UNIQUE_STR);
        address.setZipCode(UNIQUE_STR);
        address.setStateUs(StateUs.ALASKA);
        address.setRegion(UNIQUE_STR);
        address.setCountry(UNIQUE_STR);
        return address;
    }

    private Address getPopulatedAddress() {
        Address address = new Address();
        address.setContactName("Rob");
        address.setAddressLine("33 Mason St., St. 303");
        address.setCity("San Francisco");
        address.setZipCode("94107");
        address.setStateUs(StateUs.CALIFORNIA);
        address.setRegion("N/A");
        address.setCountry("US");
        return address;
    }

    private Hotel getUniquePopulatedHotel() {
        Hotel hotel = new Hotel();
        hotel.setName(UNIQUE_STR);
        hotel.setAddress(getUniquePopulatedAddress());
        hotel.setType(HotelType.CASINO);
        hotel.setStars(UNIQUE_NUM);
        hotel.setRating(UNIQUE_NUM);
        hotel.setUrl(URL);
        return hotel;
    }

    private Hotel getPopulatedHotel() {
        Hotel bean = new Hotel();
        bean.setName("Hilton");
        bean.setAddress(getPopulatedAddress());
        bean.setType(HotelType.GUEST_HOUSE);
        bean.setStars(4.0);
        bean.setRating(3.0);
        bean.setUrl(URL);
        return bean;
    }

    private Price getUniquePopulatedPrice() {
        Price price = new Price();
        price.setOriginalPriceInUsd(UNIQUE_NUM);
        price.setDiscountPriceInUsd(UNIQUE_NUM);
        return price;
    }

    private Price getPopulatedPrice() {
        Price price = new Price();
        price.setOriginalPriceInUsd(99.99);
        price.setDiscountPriceInUsd(9.99);
        return price;
    }

    @Test
    @Override
    public void readExternal() throws IOException {
        when(pofReader.readCollection(TripVariants.TRIP_VARIANTS_INDEX, new LinkedList<Trip>())).thenReturn(variantsTwo);

        super.readExternal();

        assertEquals(variantsTwo, beanInstance.getTripVariants());
    }

    @Test
    @Override
    public void writeExternal() throws IOException {
        super.writeExternal();

        verify(pofWriter, times(1)).writeCollection(eq(TripVariants.TRIP_VARIANTS_INDEX), eq(variantsThree));
    }

    @Test
    @Override
    public void getImplVersion() {
        beanInstance = getEmptyBeanInstance();
        assertTrue(beanInstance.getImplVersion() == TripVariants.VERSION);
    }

    @Test
    @Override
    public void toStringMethod() {
        assertEquals(String.format("%s", tripVariantsThree), getPopulatedBeanInstance().toString());
    }

    @Override
    protected TripVariants getEmptyBeanInstance() {
        return new TripVariants();
    }

    @Override
    protected TripVariants getPopulatedBeanInstance() {
        TripVariants bean = new TripVariants();
        bean.setTripVariants(variantsThree);
        return bean;
    }

    @Override
    protected TripVariants getUniquePopulatedBeanInstance() {
        TripVariants bean = new TripVariants();
        bean.setTripVariants(variantsOne);
        return bean;
    }

    @Override
    protected List<TripVariants> getAllVarietiesOfTheBeanInstance() {
        List<TripVariants> beans = super.getAllVarietiesOfTheBeanInstance();

        beans.add(tripVariantsTwo);

        return beans;
    }
}