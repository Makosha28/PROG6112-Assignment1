/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class InpatientTest {
    
    public InpatientTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getWardNumber method, of class Inpatient.
     */
    @Test
    public void testGetWardNumber() {
        System.out.println("getWardNumber");
        Inpatient instance = null;
        String expResult = "";
        String result = instance.getWardNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBedNumber method, of class Inpatient.
     */
    @Test
    public void testGetBedNumber() {
        System.out.println("getBedNumber");
        Inpatient instance = null;
        String expResult = "";
        String result = instance.getBedNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWardNumber method, of class Inpatient.
     */
    @Test
    public void testSetWardNumber() {
        System.out.println("setWardNumber");
        String wardNumber = "";
        Inpatient instance = null;
        instance.setWardNumber(wardNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBedNumber method, of class Inpatient.
     */
    @Test
    public void testSetBedNumber() {
        System.out.println("setBedNumber");
        String bedNumber = "";
        Inpatient instance = null;
        instance.setBedNumber(bedNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayDetails method, of class Inpatient.
     */
    @Test
    public void testDisplayDetails() {
        System.out.println("displayDetails");
        Inpatient instance = null;
        instance.displayDetails();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Inpatient.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Inpatient instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
