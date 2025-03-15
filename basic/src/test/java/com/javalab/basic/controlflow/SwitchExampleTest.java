package com.javalab.basic.controlflow;

import org.junit.jupiter.api.Test;

/**
 * @author Tham
 */
public class SwitchExampleTest {
    SwitchExample instance = new SwitchExample();

    @Test
    public void testSwitchExpression() {
        instance.switchExpression(SwitchExample.Shape.Square);
        instance.switchExpression(SwitchExample.Shape.Circle);
    }

    @Test
    public void testNormalSwtich() {
        instance.normalSwitch(SwitchExample.Shape.Square);
        instance.normalSwitch(SwitchExample.Shape.Circle);
    }
}
