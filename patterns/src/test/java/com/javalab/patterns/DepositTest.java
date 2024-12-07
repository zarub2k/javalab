package com.javalab.patterns;

import com.javalab.patterns.builder.Deposit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DepositTest {
    @Test
    public void testSimple() {
        Deposit deposit = Deposit.DepositBuilder.instance()
                .amount(1000.0)
                .build();
        assertEquals(1000.0, deposit.getAmount());
    }
}
