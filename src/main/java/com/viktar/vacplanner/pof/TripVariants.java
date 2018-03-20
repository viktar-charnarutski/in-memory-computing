package com.viktar.vacplanner.pof;

import com.tangosol.io.AbstractEvolvable;
import com.tangosol.io.pof.EvolvablePortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripVariants extends AbstractEvolvable implements EvolvablePortableObject {

    public final static int VERSION = 0;

    public static final int TRIP_VARIANTS_INDEX = 0;

    private List tripVariants;

    public List getTripVariants() {
        return tripVariants;
    }

    public void setTripVariants(List tripVariants) {
        this.tripVariants = tripVariants;
    }

    @Override
    public String toString() {
        return String.format("TripVariants[tripVariants=%s]", tripVariants);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TripVariants)) return false;

        TripVariants tripVariants = (TripVariants) o;

        return this.tripVariants != null ? this.tripVariants.equals(tripVariants.tripVariants) : tripVariants.tripVariants == null;
    }

    @Override
    public int hashCode() {
        return tripVariants != null ? tripVariants.hashCode() : 0;
    }

    @Override
    public int getImplVersion() {
        return VERSION;
    }

    @Override
    public void readExternal(PofReader pofReader) throws IOException {
        tripVariants = pofReader.readCollection(TRIP_VARIANTS_INDEX, new ArrayList<Trip>());
    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {
        pofWriter.writeCollection(TRIP_VARIANTS_INDEX, tripVariants);
    }
}