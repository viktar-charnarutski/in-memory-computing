package com.viktar.vacplanner.pof;

import com.tangosol.io.AbstractEvolvable;
import com.tangosol.io.pof.EvolvablePortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;

import java.io.IOException;
import java.time.LocalDate;

public class TripVariantsKey extends AbstractEvolvable implements EvolvablePortableObject {

    public final static int VERSION = 0;

    public static final int DEPARTURE_INDEX = 0;
    public static final int DESTINATION_INDEX = 1;
    public static final int START_DATE_INDEX = 2;
    public static final int END_DATE_INDEX = 3;

    private String departure;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;

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

    @Override
    public String toString() {
        return String.format("TripVariantsKey[departure=%s, destination=%s, startDate=%s, endDate=%s]",
                departure, destination, startDate, endDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TripVariantsKey)) return false;

        TripVariantsKey that = (TripVariantsKey) o;

        if (departure != null ? !departure.equals(that.departure) : that.departure != null) return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }

    @Override
    public int hashCode() {
        int result = departure != null ? departure.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Override
    public int getImplVersion() {
        return VERSION;
    }

    @Override
    public void readExternal(PofReader pofReader) throws IOException {
        departure = pofReader.readString(DEPARTURE_INDEX);
        destination = pofReader.readString(DESTINATION_INDEX);
        startDate = pofReader.readLocalDate(START_DATE_INDEX);
        endDate = pofReader.readLocalDate(END_DATE_INDEX);
    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {
        pofWriter.writeString(DEPARTURE_INDEX, departure);
        pofWriter.writeString(DESTINATION_INDEX, destination);
        pofWriter.writeDate(START_DATE_INDEX, startDate);
        pofWriter.writeDate(END_DATE_INDEX, endDate);
    }
}