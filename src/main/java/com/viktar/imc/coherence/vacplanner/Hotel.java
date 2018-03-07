package com.viktar.imc.coherence.vacplanner;

import com.tangosol.io.AbstractEvolvable;
import com.tangosol.io.pof.EvolvablePortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;

import java.io.IOException;
import java.net.URL;

public class Hotel extends AbstractEvolvable implements EvolvablePortableObject {

    public final static int VERSION = 0;

    public static final int NAME_INDEX = 0;
    public static final int ADDRESS_INDEX = 1;
    public static final int TYPE_INDEX = 2;
    public static final int STARS_INDEX = 3;
    public static final int RATING_INDEX = 4;
    public static final int URL_INDEX = 5;

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
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Hotel[name=%s, address=%s, type=%s, stars=%s, rating=%s, url=%s]",
                name, address, type, stars, rating, url);
    }

    @Override
    public int getImplVersion() {
        return VERSION;
    }

    @Override
    public void readExternal(PofReader pofReader) throws IOException {
        name = pofReader.readString(NAME_INDEX);
        address = pofReader.readString(ADDRESS_INDEX);
        type = pofReader.readString(TYPE_INDEX);
        stars = pofReader.readDouble(STARS_INDEX);
        rating = pofReader.readDouble(RATING_INDEX);
        url = new URL(pofReader.readString(URL_INDEX));

    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {
        pofWriter.writeString(NAME_INDEX, name);
        pofWriter.writeString(ADDRESS_INDEX, address);
        pofWriter.writeString(TYPE_INDEX, type);
        pofWriter.writeDouble(STARS_INDEX, stars);
        pofWriter.writeDouble(RATING_INDEX, rating);
        pofWriter.writeString(URL_INDEX, url.toString());
    }
}
