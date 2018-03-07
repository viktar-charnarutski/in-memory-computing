package com.viktar.imc.coherence.pof;

import com.tangosol.io.pof.EvolvablePortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.viktar.imc.coherence.BeanTest;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;

public abstract class PofBeanTest<T extends EvolvablePortableObject> extends BeanTest<T> {

    T beanInstance;

    @Mock
    PofReader pofReader;

    @Mock
    PofWriter pofWriter;

    @Test
    public abstract void getImplVersion();

    @Test
    public void readExternal() throws IOException {
        beanInstance = getEmptyBeanInstance();
        beanInstance.readExternal(pofReader);
    }

    @Test
    public void writeExternal() throws IOException {
        beanInstance = getPopulatedBeanInstance();
        beanInstance.writeExternal(pofWriter);
    }
}