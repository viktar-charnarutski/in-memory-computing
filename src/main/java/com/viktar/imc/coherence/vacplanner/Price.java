package com.viktar.imc.coherence.vacplanner;

import com.tangosol.io.AbstractEvolvable;
import com.tangosol.io.pof.EvolvablePortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;

import java.io.IOException;

public class Price extends AbstractEvolvable implements EvolvablePortableObject {

    private final static int VERSION = 0;

    private static final int ORIG_PRICE_INDEX = 0;
    private static final int DISC_PRICE_INDEX = 1;

    private double originalPriceInUsd;
    private double discountPriceInUsd;

    public double getOriginalPriceInUsd() {
        return originalPriceInUsd;
    }

    public void setOriginalPriceInUsd(double originalPriceInUsd) {
        this.originalPriceInUsd = originalPriceInUsd;
    }

    public double getDiscountPriceInUsd() {
        return discountPriceInUsd;
    }

    public void setDiscountPriceInUsd(double discountPriceInUsd) {
        this.discountPriceInUsd = discountPriceInUsd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;

        Price price = (Price) o;

        if (Double.compare(price.originalPriceInUsd, originalPriceInUsd) != 0) return false;
        return Double.compare(price.discountPriceInUsd, discountPriceInUsd) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(originalPriceInUsd);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discountPriceInUsd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("Price[originalPriceInUsd=$%s, discountPriceInUsd=$%s]", originalPriceInUsd, discountPriceInUsd);
    }

    @Override
    public int getImplVersion() {
        return VERSION;
    }

    @Override
    public void readExternal(PofReader pofReader) throws IOException {
        originalPriceInUsd = pofReader.readDouble(ORIG_PRICE_INDEX);
        discountPriceInUsd = pofReader.readDouble(DISC_PRICE_INDEX);
    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {
        pofWriter.writeDouble(ORIG_PRICE_INDEX, originalPriceInUsd);
        pofWriter.writeDouble(DISC_PRICE_INDEX, discountPriceInUsd);
    }
}