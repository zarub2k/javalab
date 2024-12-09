package com.javalab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.javalab.model.CoreModel;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class CoreAppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
        CoreModel coreModel = new CoreModel("Tham");
        assertEquals("Tham", coreModel.getName());
    }
}
