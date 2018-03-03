package com.viktar.imc.coherence.pof;

import java.net.URL;
import java.time.LocalDate;

public class Trip {

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

        Trip flightHotelBundle = (Trip) o;

        if (!departure.equals(flightHotelBundle.departure)) return false;
        if (!destination.equals(flightHotelBundle.destination)) return false;
        if (!startDate.equals(flightHotelBundle.startDate)) return false;
        if (!endDate.equals(flightHotelBundle.endDate)) return false;
        if (!price.equals(flightHotelBundle.price)) return false;
        if (!hotel.equals(flightHotelBundle.hotel)) return false;
        return url.equals(flightHotelBundle.url);
    }

    @Override
    public int hashCode() {
        int result = departure.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + hotel.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("FlightHotelBundle[departure=%s, destination=%s, startDate=%s, endDate=%s, price=%s, hotel=%s, url=%s]",
                departure, destination, startDate, endDate, price, hotel, url);
    }
}
