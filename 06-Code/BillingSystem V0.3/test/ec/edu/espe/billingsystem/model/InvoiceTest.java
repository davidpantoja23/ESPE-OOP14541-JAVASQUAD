/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.billingsystem.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class InvoiceTest {
    
    public InvoiceTest() {
    }

    /**
     * Test of addLine method, of class Invoice.
     */
    @Test
    public void testAddLine() {
        System.out.println("addLine");
        InvoiceLine line = null;
        Invoice instance = null;
        instance.addLine(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class Invoice.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        Invoice instance = null;
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentMethod method, of class Invoice.
     */
    @Test
    public void testGetPaymentMethod() {
        System.out.println("getPaymentMethod");
        Invoice instance = null;
        PaymentMethod expResult = null;
        PaymentMethod result = instance.getPaymentMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLines method, of class Invoice.
     */
    @Test
    public void testGetLines() {
        System.out.println("getLines");
        Invoice instance = null;
        List<InvoiceLine> expResult = null;
        List<InvoiceLine> result = instance.getLines();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubtotal method, of class Invoice.
     */
    @Test
    public void testGetSubtotal() {
        System.out.println("getSubtotal");
        Invoice instance = null;
        double expResult = 0.0;
        double result = instance.getSubtotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVat method, of class Invoice.
     */
    @Test
    public void testGetVat() {
        System.out.println("getVat");
        Invoice instance = null;
        double expResult = 0.0;
        double result = instance.getVat();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Invoice.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Invoice instance = null;
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeOfId method, of class Invoice.
     */
    @Test
    public void testGetTypeOfId() {
        System.out.println("getTypeOfId");
        Invoice instance = null;
        TypeOfId expResult = null;
        TypeOfId result = instance.getTypeOfId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Invoice.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Invoice instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
