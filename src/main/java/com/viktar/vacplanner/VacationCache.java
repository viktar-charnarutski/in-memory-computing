package com.viktar.vacplanner;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.viktar.vacplanner.pof.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The class emulates distributed cache population with vacation-related objects.
 * <p>Should be ran with the following VM parameter specified:
 * <ul>
 * <li>-Dtangosol.coherence.cacheconfig=/Users/viktar_charnarutski/Projects/Education/in-memory-computing/src/main/resources/cache-config.xml</li>
 * <li>-Dtangosol.coherence.override=/Users/viktar_charnarutski/Projects/Education/in-memory-computing/src/main/resources/tangosol-coherence-override.xml</li>
 * <li>-Dtangosol.pof.config=/Users/viktar_charnarutski/Projects/Education/in-memory-computing/src/main/resources/pof-config.xml</li>
 * <li>-Djava.net.preferIPv4Stack=true</li>
 * </ul>
 * </p>
 */
public class VacationCache {

    private static final String CACHE_NAME = "vacation-planner";

    private static final String DEPARTURE = "SFO";
    private static final String DESTINATION = "MBJ";

    private static final LocalDate START_DATE = LocalDate.now().plusDays(10);
    private static final LocalDate END_DATE = LocalDate.now().plusDays(15);

    private static TripVariantsKey key;

    public static void main(String[] args) throws Exception {
        NamedCache<TripVariantsKey, TripVariants> cache = CacheFactory.getCache(CACHE_NAME);

        cache.put(key(), tripVariants());
        System.out.println(cache.get(key()));
    }

    private static TripVariantsKey key() {
        if (key == null) {
            key = new TripVariantsKey();
            key.setDeparture(DEPARTURE);
            key.setDestination(DESTINATION);
            key.setStartDate(START_DATE);
            key.setEndDate(END_DATE);
        }
        return key;
    }

    private static TripVariants tripVariants() throws MalformedURLException {
        TripVariants tripVariantsBean = new TripVariants();
        List<Trip> tripVariants = new ArrayList<>();
        tripVariants.add(trip());
        tripVariantsBean.setTripVariants(tripVariants);
        return tripVariantsBean;
    }

    private static Trip trip() throws MalformedURLException {
        Trip bean = new Trip();
        bean.setDeparture(DEPARTURE);
        bean.setDestination(DESTINATION);
        bean.setStartDate(START_DATE);
        bean.setEndDate(END_DATE);
        bean.setPrice(price());
        bean.setHotel(hotel());
        bean.setUrl(new URL("https://www.viktarx.com"));
        return bean;
    }

    private static Hotel hotel() throws MalformedURLException {
        Hotel hotel = new Hotel();
        hotel.setName("Hilton");
        hotel.setAddress(address());
        hotel.setType(HotelType.BED_AND_BREAKFAST);
        hotel.setStars(4.5);
        hotel.setRating(5.0);
        hotel.setUrl(new URL("https://www.viktarx.com"));
        return hotel;
    }

    private static Address address() {
        Address address = new Address();
        address.setContactName("Bob");
        address.setAddressLine("6 Jones St, Apt.1");
        address.setCity("San Francisco");
        address.setZipCode("94102");
        address.setStateUs(StateUs.CALIFORNIA);
        address.setRegion("N/A");
        address.setCountry("US");
        return address;
    }

    private static Price price() {
        Price price = new Price();
        price.setOriginalPriceInUsd(99.99);
        price.setDiscountPriceInUsd(9.99);
        return price;
    }
}