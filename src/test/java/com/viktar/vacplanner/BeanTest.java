package com.viktar.vacplanner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public abstract class BeanTest<T> extends MockTest {

    protected static final String UNIQUE_STR = String.valueOf(System.currentTimeMillis());

    protected static final long UNIQUE_NUM = System.currentTimeMillis();

    protected abstract T getEmptyBeanInstance();

    protected abstract T getPopulatedBeanInstance();

    protected abstract T getUniquePopulatedBeanInstance();

    protected List<T> getAllVarietiesOfTheBeanInstance() {
        List<T> beans = new ArrayList<>();
        beans.add(getPopulatedBeanInstance());
        beans.add(getEmptyBeanInstance());
        return beans;
    }

    public abstract void toStringMethod();

    @Test
    public void equalsForEaqualObjects() {
        assertTrue(getPopulatedBeanInstance().equals(getPopulatedBeanInstance()));
    }

    @Test
    public void equalsForNullObject() {
        assertFalse(getPopulatedBeanInstance().equals(null));
    }

    @Test
    public void equalsForDifferentTypeObject() {
        assertFalse(getPopulatedBeanInstance().equals(new Object()));
    }

    @Test
    public void equalsForTheSameObjects() {
        T beanInstance = getPopulatedBeanInstance();
        assertTrue(beanInstance.equals(beanInstance));
    }

    @Test
    public void equalsForNotEaqualObjects() {
        T beanInstance = getUniquePopulatedBeanInstance();
        for (T beanInstanceVaraity : getAllVarietiesOfTheBeanInstance()) {
            assertFalse(beanInstance.equals(beanInstanceVaraity));
        }
    }

    @Test
    public void hashCodeForEaqualObjects() {
        T beanInstance1 = getPopulatedBeanInstance();
        T beanInstance2 = getPopulatedBeanInstance();
        assertEquals(beanInstance1.hashCode(), beanInstance2.hashCode());
    }

    @Test
    public void hashCodeForNotEaqualObjects() {
        T beanInstance = getUniquePopulatedBeanInstance();
        for (T beanInstanceVaraity : getAllVarietiesOfTheBeanInstance()) {
            assertNotEquals(beanInstance.hashCode(), beanInstanceVaraity.hashCode());
        }
    }

    @Test
    public void hashCodeEqualContract() {
        T beanInstance1 = getPopulatedBeanInstance();
        T beanInstance2 = getPopulatedBeanInstance();

        assertTrue(beanInstance1.equals(beanInstance2));
        assertEquals(beanInstance1.hashCode(), beanInstance2.hashCode());

        T beanInstance3 = getUniquePopulatedBeanInstance();

        for (T beanInstanceVaraity : getAllVarietiesOfTheBeanInstance()) {
            assertFalse(beanInstance3.equals(beanInstanceVaraity));
            assertNotEquals(beanInstance3.hashCode(), beanInstanceVaraity.hashCode());
        }
    }
}
