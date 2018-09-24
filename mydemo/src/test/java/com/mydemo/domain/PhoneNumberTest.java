package com.mydemo.domain;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PhoneNumberTest {

    @Test
    public void testReflexive(){
        PhoneNumber p1= PhoneNumber.of(123,1234);
        assertTrue(p1.equals(p1));

    }
    @Test
    public void testTransitive(){
        PhoneNumber p1= PhoneNumber.of(123,1234);
        PhoneNumber p2= PhoneNumber.of(123,1234);
        PhoneNumber p3= PhoneNumber.of(123,1234);

        assertTrue(p1.equals(p2));
        assertTrue(p2.equals(p3));
        assertTrue(p1.equals(p3));

    }

    @Test
    public void testSymmetrical(){
        PhoneNumber p1= PhoneNumber.of(123,1234);
        PhoneNumber p2= PhoneNumber.of(123,1234);

        assertTrue(p1.equals(p2));
        assertTrue(p2.equals(p1));
    }
    @Test
    public void testNonNullity(){
        PhoneNumber p1= PhoneNumber.of(123,1234);
        assertFalse(p1.equals(null));
    }
    @Test
    public void testConsistent(){
        PhoneNumber p1= PhoneNumber.of(123,1234);
        PhoneNumber p2= PhoneNumber.of(123,1234);
        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p2));

    }

}