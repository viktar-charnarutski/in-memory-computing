package com.viktar.imc.coherence.pof;

import com.tangosol.io.AbstractEvolvable;
import com.tangosol.io.pof.EvolvablePortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;

import java.io.IOException;

public class Inventory extends AbstractEvolvable implements EvolvablePortableObject {

    public static final int VERSION = 1;

    public static final int POF_INDEX_FOR_PRODUCT_ID = 0;
    public static final int POF_INDEX_FOR_STOCK_LEVEL = 1;

    private String productId;
    private long stockLevel;

    // default empty constructor required for POF deserialization
    public Inventory() {
    }

    public Inventory(String productId, long stockLevel) {
        checkInitParameters(productId, stockLevel);

        this.productId = productId;
        this.stockLevel = stockLevel;
    }

    private static void checkInitParameters(String productId, long stockLevel) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("Product ID should not be null or empty.");
        }
        if (stockLevel < 0) {
            throw new IllegalArgumentException("Stock level should not be negative.");
        }
    }

    @Override
    public int getImplVersion() {
        return VERSION;
    }

    @Override
    public void readExternal(PofReader pofReader) throws IOException {
        productId = pofReader.readString(POF_INDEX_FOR_PRODUCT_ID);
        stockLevel = pofReader.readLong(POF_INDEX_FOR_STOCK_LEVEL);
    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {
        pofWriter.writeString(POF_INDEX_FOR_PRODUCT_ID, productId);
        pofWriter.writeLong(POF_INDEX_FOR_STOCK_LEVEL, stockLevel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;

        Inventory inventory = (Inventory) o;

        if (stockLevel != inventory.stockLevel) return false;
        return productId.equals(inventory.productId);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + (int) (stockLevel ^ (stockLevel >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("Inventory[productId=%s, stockLevel=%d]", productId, stockLevel);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(long stockLevel) {
        this.stockLevel = stockLevel;
    }
}
