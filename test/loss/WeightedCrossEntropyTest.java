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
import tensor.TensorFunctions;

/**
 *
 * @author dp12577
 */
public class WeightedCrossEntropyTest {

    public WeightedCrossEntropyTest() {
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
     * Test of eval method, of class WeightedCrossEntropy.
     */
    @Test
    public void testEval() {
        System.out.println("eval");
        DoubleTensor output = new DoubleTensor(3,3);
        output.data.add(0.7);
        output.data.add(0.2);
        output.data.add(0.1);

        output.data.add(0.3);
        output.data.add(0.5);
        output.data.add(0.2);

        output.data.add(0.9);
        output.data.add(0.05);
        output.data.add(0.05);

        DoubleTensor y = new DoubleTensor(3);
        y.data.add(1);
        y.data.add(2);
        y.data.add(0);

        DoubleTensor yWeights = new DoubleTensor(3);
        yWeights.data.add(2.0);
        yWeights.data.add(5.0);
        yWeights.data.add(3.0);

        WeightedCrossEntropy instance = new WeightedCrossEntropy();
        double sc = TensorFunctions.smallConst;
        double expResult = -(2.0 * Math.log(0.2 + sc) + 5.0 * Math.log(0.2 + sc)
                + 3.0 * Math.log(0.9 + sc));
        double result = instance.eval(output, y, yWeights);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of bProp method, of class WeightedCrossEntropy.
     */
    @Test
    public void testBProp() {
        System.out.println("bProp");
        DoubleTensor output = new DoubleTensor(3,3);
        output.data.add(0.7);
        output.data.add(0.2);
        output.data.add(0.1);

        output.data.add(0.3);
        output.data.add(0.5);
        output.data.add(0.2);

        output.data.add(0.9);
        output.data.add(0.05);
        output.data.add(0.05);

        DoubleTensor y = new DoubleTensor(3);
        y.data.add(1);
        y.data.add(2);
        y.data.add(0);

        DoubleTensor yWeights = new DoubleTensor(3);
        yWeights.data.add(2.0);
        yWeights.data.add(5.0);
        yWeights.data.add(3.0);

        WeightedCrossEntropy instance = new WeightedCrossEntropy();
        DoubleTensor expResult = new DoubleTensor(3,3);
        double sc = TensorFunctions.smallConst;
        expResult.data.add(0.0);
        expResult.data.add(-2.0 / (0.2 + sc));
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(-5.0 / (0.2 + sc));

        expResult.data.add(-3.0 / (0.9 + sc));
        expResult.data.add(0.0);
        expResult.data.add(0.0);

        DoubleTensor result = instance.bProp(output, y, yWeights);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

}