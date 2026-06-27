/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package layer.activation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dp12577
 */
public class RReLUTest {

    public RReLUTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of forward method, of class RReLU.
     */
    @Test
    public void testForward() {
        System.out.println("forward");
        double input = 2.0;
        RReLU instance = new RReLU(123);
        double expResult = 2.0;
        double result = instance.forward(input, false);
        assertEquals(expResult, result, 1E-7);

        input = -2.0;
        expResult = -2.0 * 0.3314372701619248;
        result = instance.forward(input, false);
        assertEquals(expResult, result, 1E-7);
    }

    /**
     * Test of derivative method, of class RReLU.
     */
    @Test
    public void testDerivative() {
        System.out.println("derivative");
        double output = 2.0;
        RReLU instance = new RReLU(123);
        double expResult = 1.0;
        instance.forward(output, false);
        double result = instance.derivative(1.0,output);
        assertEquals(expResult, result, 1E-7);

        output = -2.0;
        expResult = 0.3314372701619248;
        instance.forward(output, false);
        result = instance.derivative(1.0,output);
        assertEquals(expResult, result, 1E-7);
    }

}