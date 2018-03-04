package com.viktar.imc.coherence.vacplanner;

import java.net.URL;

public class Hotel {

    private String name;
    private String address;
    private String type;
    private double stars;
    private double rating;
    private URL url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
        if (!(o instanceof Hotel)) return false;

        Hotel hotel = (Hotel) o;

        if (Double.compare(hotel.stars, stars) != 0) return false;
        if (Double.compare(hotel.rating, rating) != 0) return false;
        if (!name.equals(hotel.name)) return false;
        if (!address.equals(hotel.address)) return false;
        if (!type.equals(hotel.type)) return false;
        return url.equals(hotel.url);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + type.hashCode();
        temp = Double.doubleToLongBits(stars);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Hotel[name=%s, address=%s, type=%s, stars=%s, rating=%s, url=%s]",
                name, address, type, stars, rating, url);
    }
}
