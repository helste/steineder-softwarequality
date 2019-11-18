package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegerSequenceTest
{

    @Test
    public void testSequence()
    {
        IntegerSequence.setValue(100);
        assertEquals(100, IntegerSequence.nextValue());
        assertEquals(101, IntegerSequence.nextValue());

        IntegerSequence.setValue(200);
        assertEquals(200, IntegerSequence.nextValue());
    }
}
