package com.viktar.vacplanner.pof;

import com.tangosol.io.AbstractEvolvable;
import com.tangosol.io.pof.EvolvablePortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class Trip extends AbstractEvolvable implements EvolvablePortableObject {

    public final static int VERSION = 0;

    public static final int DEPARTURE_INDEX = 0;
    public static final int DESTINATION_INDEX = 1;
    public static final int START_DATE_INDEX = 2;
    public static final int END_DATE_INDEX = 3;
    public static final int PRICE_INDEX = 4;
    public static final int HOTEL_INDEX = 5;
    public static final int URL_INDEX = 6;

    private String departure;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private Price price;
    private Hotel hotel;
    private URL url;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip)) return false;

        Trip trip = (Trip) o;

        if (departure != null ? !departure.equals(trip.departure) : trip.departure != null) return false;
        if (destination != null ? !destination.equals(trip.destination) : trip.destination != null) return false;
        if (startDate != null ? !startDate.equals(trip.startDate) : trip.startDate != null) return false;
        if (endDate != null ? !endDate.equals(trip.endDate) : trip.endDate != null) return false;
        if (price != null ? !price.equals(trip.price) : trip.price != null) return false;
        if (hotel != null ? !hotel.equals(trip.hotel) : trip.hotel != null) return false;
        return url != null ? url.equals(trip.url) : trip.url == null;
    }

    @Override
    public int hashCode() {
        int result = departure != null ? departure.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Trip[departure=%s, destination=%s, startDate=%s, endDate=%s, price=%s, hotel=%s, url=%s]",
                departure, destination, startDate, endDate, price, hotel, url);
    }

    @Override
    public int getImplVersion() {
        return VERSION;
    }

    @Override
    public void readExternal(PofReader pofReader) throws IOException {
        destination = pofReader.readString(DESTINATION_INDEX);
        departure = pofReader.readString(DEPARTURE_INDEX);
        startDate = pofReader.readLocalDate(START_DATE_INDEX);
        endDate = pofReader.readLocalDate(END_DATE_INDEX);
        price = pofReader.readObject(PRICE_INDEX);
        hotel = pofReader.readObject(HOTEL_INDEX);
        url = pofReader.readObject(URL_INDEX);
    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {
        pofWriter.writeString(DESTINATION_INDEX, destination);
        pofWriter.writeString(DEPARTURE_INDEX, departure);
        pofWriter.writeDate(START_DATE_INDEX, startDate);
        pofWriter.writeDate(END_DATE_INDEX, endDate);
        pofWriter.writeObject(PRICE_INDEX, price);
        pofWriter.writeObject(HOTEL_INDEX, hotel);
        pofWriter.writeObject(URL_INDEX, url);
    }
}