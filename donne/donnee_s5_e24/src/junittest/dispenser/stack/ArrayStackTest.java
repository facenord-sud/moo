/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dispenser.stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leo
 */
public class ArrayStackTest {
    
    public ArrayStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of put method, of class ArrayStack.
     */
    @Test
    public void testPut() throws Exception {
        Object item = null;
        ArrayStack instance = new ArrayStack();
        instance.put(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of slowPut method, of class ArrayStack.
     */
    @Test
    public void testSlowPut() throws Exception {
        System.out.println("slowPut");
        Object item = null;
        ArrayStack instance = new ArrayStack();
        instance.slowPut(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ArrayStack.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        ArrayStack instance = new ArrayStack();
        Object expResult = null;
        Object result = instance.remove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of item method, of class ArrayStack.
     */
    @Test
    public void testItem() throws Exception {
        System.out.println("item");
        ArrayStack instance = new ArrayStack();
        Object expResult = null;
        Object result = instance.item();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class ArrayStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayStack instance = new ArrayStack();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}