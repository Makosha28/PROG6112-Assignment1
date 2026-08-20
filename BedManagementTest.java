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
public class BedManagementTest {
    
    public BedManagementTest() {
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
     * Test of getBedNumber method, of class BedManagement.
     */
    @Test
    public void testGetBedNumber() {
        System.out.println("getBedNumber");
        BedManagement instance = null;
        String expResult = "";
        String result = instance.getBedNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOccupied method, of class BedManagement.
     */
    @Test
    public void testIsOccupied() {
        System.out.println("isOccupied");
        BedManagement instance = null;
        boolean expResult = false;
        boolean result = instance.isOccupied();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientId method, of class BedManagement.
     */
    @Test
    public void testGetPatientId() {
        System.out.println("getPatientId");
        BedManagement instance = null;
        String expResult = "";
        String result = instance.getPatientId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of allocate method, of class BedManagement.
     */
    @Test
    public void testAllocate() {
        System.out.println("allocate");
        String patientId = "";
        BedManagement instance = null;
        instance.allocate(patientId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of release method, of class BedManagement.
     */
    @Test
    public void testRelease() {
        System.out.println("release");
        BedManagement instance = null;
        instance.release();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class BedManagement.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BedManagement instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
