package com.viktar.imc.coherence.pof;

public class Price {

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
        return String.format("Price[originalPriceInUsd=%s, discountPriceInUsd=%s]", originalPriceInUsd, discountPriceInUsd);
    }
}
