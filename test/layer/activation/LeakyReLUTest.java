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
public class LeakyReLUTest {

    public LeakyReLUTest() {
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
     * Test of forward method, of class LeakyReLU.
     */
    @Test
    public void testForward() {
        System.out.println("forward");
        double input = 4.0;
        LeakyReLU instance = new LeakyReLU();
        double expResult = 4.0;
        double result = instance.forward(input, false);
        assertEquals(expResult, result, 1E-7);

        input = -4.0;
        expResult = -4.0 * 1.0 / 5.5;
        result = instance.forward(input, false);
        assertEquals(expResult, result, 1E-7);
    }

    /**
     * Test of derivative method, of class LeakyReLU.
     */
    @Test
    public void testDerivative() {
        System.out.println("derivative");
        double output = 4.0;
        LeakyReLU instance = new LeakyReLU();
        double expResult = 1.0;
        double result = instance.derivative(1.0,output);
        assertEquals(expResult, result, 1E-7);

        output = -4.0;
        expResult = 1.0 / 5.5;
        result = instance.derivative(1.0,output);
        assertEquals(expResult, result, 1E-7);
    }

}