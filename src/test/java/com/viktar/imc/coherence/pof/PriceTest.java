package com.viktar.imc.coherence.pof;

import com.viktar.imc.coherence.vacplanner.Price;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class PriceTest extends PofBeanTest<Price> {

    private static final double ORIGINAL_PRICE = 99.99;
    private static final double DISCOUNT_PRICE = 9.99;

    @Test
    @Override
    public void readExternal() throws IOException {
        when(pofReader.readDouble(Price.ORIG_PRICE_INDEX)).thenReturn(ORIGINAL_PRICE);
        when(pofReader.readDouble(Price.DISC_PRICE_INDEX)).thenReturn(DISCOUNT_PRICE);

        super.readExternal();

        assertTrue(ORIGINAL_PRICE == beanInstance.getOriginalPriceInUsd());
        assertTrue(DISCOUNT_PRICE == beanInstance.getDiscountPriceInUsd());
    }

    @Test
    @Override
    public void writeExternal() throws IOException {
        super.writeExternal();

        verify(pofWriter, times(1)).writeDouble(eq(Price.ORIG_PRICE_INDEX), eq(ORIGINAL_PRICE));
        verify(pofWriter, times(1)).writeDouble(eq(Price.DISC_PRICE_INDEX), eq(DISCOUNT_PRICE));
    }

    @Test
    @Override
    public void getImplVersion() {
        beanInstance = getEmptyBeanInstance();
        assertTrue(beanInstance.getImplVersion() == Price.VERSION);
    }

    @Test
    @Override
    public void toStringMethod() {
        assertEquals("Price[originalPriceInUsd=$99.99, discountPriceInUsd=$9.99]", getPopulatedBeanInstance().toString());
    }

    @Override
    protected Price getEmptyBeanInstance() {
        return new Price();
    }

    @Override
    protected Price getPopulatedBeanInstance() {
        Price bean = new Price();
        bean.setOriginalPriceInUsd(99.99);
        bean.setDiscountPriceInUsd(9.99);
        return bean;
    }

    @Override
    protected Price getUniquePopulatedBeanInstance() {
        Price bean = new Price();
        bean.setOriginalPriceInUsd(System.currentTimeMillis());
        bean.setDiscountPriceInUsd(System.currentTimeMillis());
        return bean;
    }

    @Override
    protected List<Price> getAllVarietiesOfTheBeanInstance() {
        List<Price> beans = super.getAllVarietiesOfTheBeanInstance();

        Price bean = getEmptyBeanInstance();
        bean.setOriginalPriceInUsd(System.currentTimeMillis());
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setDiscountPriceInUsd(System.currentTimeMillis());
        beans.add(bean);

        return beans;
    }
}