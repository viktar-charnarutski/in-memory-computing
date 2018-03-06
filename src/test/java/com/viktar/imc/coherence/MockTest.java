package com.viktar.imc.coherence;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public abstract class MockTest {

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
