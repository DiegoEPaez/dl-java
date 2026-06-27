/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package loss;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tensor.DoubleTensor;

/**
 *
 * @author dp12577
 */
public class MeanSquaredErrorTest {

    public MeanSquaredErrorTest() {
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
     * Test of eval method, of class MeanSquaredError.
     */
    @Test
    public void testEval() {
        System.out.println("eval");
        DoubleTensor output = new DoubleTensor(5);
        output.data.add(0.7);
        output.data.add(0.5);
        output.data.add(0.1);
        output.data.add(0.5);
        output.data.add(0.6);
        
        DoubleTensor y = new DoubleTensor(5);
        y.data.add(0.65);
        y.data.add(0.52);
        y.data.add(0.19);
        y.data.add(0.45);
        y.data.add(0.66);

        DoubleTensor yWeights = null;
        MeanSquaredError instance = new MeanSquaredError();
        double expResult = 0.00342;
        double result = instance.eval(output, y, yWeights);
        assertEquals(expResult, result, 1E-7);
    }

    /**
     * Test of bProp method, of class MeanSquaredError.
     */
    @Test
    public void testBProp() {
        System.out.println("bProp");
        DoubleTensor output = new DoubleTensor(5);
        output.data.add(0.7);
        output.data.add(0.5);
        output.data.add(0.1);
        output.data.add(0.5);
        output.data.add(0.6);

        DoubleTensor y = new DoubleTensor(5);
        y.data.add(0.65);
        y.data.add(0.52);
        y.data.add(0.19);
        y.data.add(0.45);
        y.data.add(0.66);

        DoubleTensor yWeights = null;
        MeanSquaredError instance = new MeanSquaredError();
        DoubleTensor expResult = new DoubleTensor(5);
        expResult.data.add(0.02);
        expResult.data.add(-0.008);
        expResult.data.add(-0.036);
        expResult.data.add(0.02);
        expResult.data.add(-0.024);

        DoubleTensor result = instance.bProp(output, y, yWeights);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

}