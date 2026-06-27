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
public class SoftSignTest {

    public SoftSignTest() {
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
     * Test of forward method, of class SoftSign.
     */
    @Test
    public void testForward() {
        System.out.println("forward");
        double input = 5.0;
        SoftSign instance = new SoftSign();
        double expResult = 0.8333333333333333333;
        double result = instance.forward(input, false);
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of derivative method, of class SoftSign.
     */
    @Test
    public void testDerivative() {
        System.out.println("derivative");
        double input = 5.0;
        double output = 0.8333333333333333333;
        SoftSign instance = new SoftSign();
        double expResult = 0.0277777777777778;
        double result = instance.derivative(input, output);
        assertEquals(expResult, result, 1E-7);
    }

}