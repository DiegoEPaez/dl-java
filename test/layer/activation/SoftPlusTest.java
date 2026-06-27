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
public class SoftPlusTest {

    public SoftPlusTest() {
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
     * Test of forward method, of class SoftPlus.
     */
    @Test
    public void testForward() {
        System.out.println("forward");
        double input = 8.0;
        SoftPlus instance = new SoftPlus();
        double expResult = 8.000335406372896;
        double result = instance.forward(input, false);
        assertEquals(expResult, result, 1E-16);

        input = 37.0;
        expResult = 37.0;
        result = instance.forward(input, false);
        assertEquals(expResult, result, 1E-16);
    }

    /**
     * Test of derivative method, of class SoftPlus.
     */
    @Test
    public void testDerivative() {
        System.out.println("derivative");
        double output = 8.000335406372896;
        double input = 8.0;
        SoftPlus instance = new SoftPlus();
        double expResult = 0.999664649869534;
        double result = instance.derivative(input,output);
        assertEquals(expResult, result, 1E-8);

        input = 37.0;
        output = 37.0;
        expResult = 1.0;
        result = instance.derivative(input, output);
        assertEquals(expResult, result, 1E-8);
    }

}