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
public class ReLUTest {

    public ReLUTest() {
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
     * Test of forward method, of class ReLU.
     */
    @Test
    public void testForward() {
        System.out.println("forward");
        double input = 4.0;
        ReLU instance = new ReLU();
        double expResult = 4.0;
        double result = instance.forward(input, false);
        assertEquals(expResult, result, 0.0);

        input = -4.0;
        expResult = 0.0;
        result = instance.forward(input, false);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of derivative method, of class ReLU.
     */
    @Test
    public void testDerivative() {
        System.out.println("derivative");
        double output = 4.0;
        ReLU instance = new ReLU();
        double expResult = 1.0;
        double result = instance.derivative(1.0,output);
        assertEquals(expResult, result, 0.0);

        output = 0.0;
        expResult = 0.0;
        result = instance.derivative(1.0,output);
        assertEquals(expResult, result, 0.0);
    }

}