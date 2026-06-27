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
public class TanhTest {

    public TanhTest() {
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
     * Test of forward method, of class Tanh.
     */
    @Test
    public void testForward() {
        System.out.println("forward");
        double input = 0.5;
        Tanh instance = new Tanh();
        double expResult = 0.46211715726001;
        double result = instance.forward(input, false);
        assertEquals(expResult, result, 1E-7);
    }

    /**
     * Test of derivative method, of class Tanh.
     */
    @Test
    public void testDerivative() {
        System.out.println("derivative");
        double input = 0.5;
        double output = 0.46211715726001;
        Tanh instance = new Tanh();
        double expResult = 0.786447732965927;
        double result = instance.derivative(input, output);
        assertEquals(expResult, result, 1E-7);
    }

}