package com.viktar.vacplanner.pof;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class TripVariantsKeyTest extends PofBeanTest<TripVariantsKey> {

    private static final String DEPARTURE = "SFO";
    private static final String DESTINATION = "MBJ";
    private static final LocalDate START_DATE = LocalDate.now().plusDays(10);
    private static final LocalDate END_DATE = LocalDate.now().plusDays(15);

    @Test
    @Override
    public void readExternal() throws IOException {
        when(pofReader.readString(TripVariantsKey.DEPARTURE_INDEX)).thenReturn(DEPARTURE);
        when(pofReader.readString(TripVariantsKey.DESTINATION_INDEX)).thenReturn(DESTINATION);
        when(pofReader.readLocalDate(TripVariantsKey.START_DATE_INDEX)).thenReturn(START_DATE);
        when(pofReader.readLocalDate(TripVariantsKey.END_DATE_INDEX)).thenReturn(END_DATE);

        super.readExternal();

        assertEquals(DEPARTURE, beanInstance.getDeparture());
        assertEquals(DESTINATION, beanInstance.getDestination());
        assertEquals(START_DATE, beanInstance.getStartDate());
        assertEquals(END_DATE, beanInstance.getEndDate());
    }

    @Test
    @Override
    public void writeExternal() throws IOException {
        super.writeExternal();

        verify(pofWriter, times(1)).writeString(eq(TripVariantsKey.DEPARTURE_INDEX), eq(DEPARTURE));
        verify(pofWriter, times(1)).writeString(eq(TripVariantsKey.DESTINATION_INDEX), eq(DESTINATION));
        verify(pofWriter, times(1)).writeDate(eq(TripVariantsKey.START_DATE_INDEX), eq(START_DATE));
        verify(pofWriter, times(1)).writeDate(eq(TripVariantsKey.END_DATE_INDEX), eq(END_DATE));
    }

    @Test
    @Override
    public void getImplVersion() {
        beanInstance = getEmptyBeanInstance();
        assertTrue(beanInstance.getImplVersion() == Trip.VERSION);
    }

    @Test
    @Override
    public void toStringMethod() {
        assertEquals(String.format("TripVariantsKey[departure=%s, destination=%s, startDate=%s, endDate=%s]",
                DEPARTURE,
                DESTINATION,
                START_DATE,
                END_DATE),
                getPopulatedBeanInstance().toString());
    }

    @Override
    protected TripVariantsKey getEmptyBeanInstance() {
        return new TripVariantsKey();
    }

    @Override
    protected TripVariantsKey getPopulatedBeanInstance() {
        TripVariantsKey bean = new TripVariantsKey();
        bean.setDeparture(DEPARTURE);
        bean.setDestination(DESTINATION);
        bean.setStartDate(START_DATE);
        bean.setEndDate(END_DATE);
        return bean;
    }

    @Override
    protected TripVariantsKey getUniquePopulatedBeanInstance() {
        TripVariantsKey bean = new TripVariantsKey();
        bean.setDeparture(UNIQUE_STR);
        bean.setDestination(UNIQUE_STR);
        bean.setStartDate(LocalDate.now().plusDays((int) UNIQUE_NUM));
        bean.setEndDate(LocalDate.now().plusDays((int) UNIQUE_NUM));
        return bean;
    }

    @Override
    protected List<TripVariantsKey> getAllVarietiesOfTheBeanInstance() {
        List<TripVariantsKey> beans = super.getAllVarietiesOfTheBeanInstance();

        TripVariantsKey bean = getEmptyBeanInstance();
        bean.setDeparture(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setDeparture(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setDestination(UNIQUE_STR);
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setDestination(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setStartDate(LocalDate.now().plusDays((int) UNIQUE_NUM));
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setStartDate(null);
        beans.add(bean);

        bean = getEmptyBeanInstance();
        bean.setEndDate(LocalDate.now().plusDays((int) UNIQUE_NUM));
        beans.add(bean);

        bean = getPopulatedBeanInstance();
        bean.setEndDate(null);
        beans.add(bean);

        return beans;
    }
}