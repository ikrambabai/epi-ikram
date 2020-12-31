package com.babai.primitives;

import org.junit.Assert;
import org.junit.Test;

public class PrimitivesTest {

    @Test
    public void testOnesCount(){
        int pValue = Primitives.countOnes(10);
        Assert.assertEquals("Wrong value returned by the method", 2, pValue);
    }

    @Test
    public void testIsBinary() throws Exception{
        String binary = Primitives.toBinary(5);
        Assert.assertEquals("Fails.", "101", binary);

        binary = Primitives.toBinary(7);
        Assert.assertEquals("Fails.", "111", binary);
    }

}
