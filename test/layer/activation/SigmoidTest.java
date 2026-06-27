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
public class SigmoidTest {

    public SigmoidTest() {
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
     * Test of forward method, of class Sigmoid.
     */
    @Test
    public void testForward() {
        System.out.println("forward");
        double input = 5.0;
        Sigmoid instance = new Sigmoid();
        double expResult = 0.993307149075715;
        double result = instance.forward(input, false);
        assertEquals(expResult, result, 1E-7);
    }

    /**
     * Test of derivative method, of class Sigmoid.
     */
    @Test
    public void testDerivative() {
        System.out.println("derivative");
        double output = 0.993307149075715;
        Sigmoid instance = new Sigmoid();
        double expResult = 0.00664805667079003;
        double result = instance.derivative(1.0,output);
        assertEquals(expResult, result, 1E-7);
    }

}