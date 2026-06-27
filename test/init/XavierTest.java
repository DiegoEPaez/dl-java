/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package init;

import java.util.Arrays;
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
public class XavierTest {

    public XavierTest() {
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
     * Test of initBias method, of class Xavier.
     */
    @Test
    public void testInitBias() {
        System.out.println("initBias");
        int numBias = 5;
        Xavier instance = new Xavier();
        double[] expResult = new double[numBias];
        Arrays.fill(expResult,0.0);
        double[] result = instance.initBias(numBias);
        for(int i = 0; i < expResult.length; i++){
            assertEquals(expResult[i], result[i], 1E-7);
        }
    }

    /**
     * Test of initWeights method, of class Xavier.
     */
    @Test
    public void testInitWeights() {
        System.out.println("initWeights");
        Xavier instance = new Xavier(123);
        double[] expResult = new double[15];
        expResult[0] = 0.386549058529747;
        expResult[1] = 0.850261830597688;
        expResult[2] = -0.427308875722686;
        expResult[3] = 0.188447769377902;
        expResult[4] = 0.529781538878867;
        expResult[5] = 0.650234017866398;
        expResult[6] = 0.374206998470741;
        expResult[7] = -0.741461466896325;
        expResult[8] = 0.513139055524937;
        expResult[9] = 0.136341734892968;
        expResult[10] = 0.706894306478694;
        expResult[11] = -0.608097787306885;
        expResult[12] = 0.823105006896263;
        expResult[13] = -0.752409746202657;
        expResult[14] = -0.745616899260029;

        double[] result = instance.initWeights(3,5,new int[]{3,5});
        for(int i = 0; i < expResult.length; i++){
            assertEquals(expResult[i], result[i], 1E-7);
        }
    }

}