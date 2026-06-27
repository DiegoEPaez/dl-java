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
public class CrossEntropyTest {

    public CrossEntropyTest() {
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
     * Test of eval method, of class CrossEntropy.
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
        
        DoubleTensor yWeights = null;
        CrossEntropy instance = new CrossEntropy();
        double sc = TensorFunctions.smallConst;
        double expResult = -(Math.log(0.2 + sc) + Math.log(0.2 + sc)
                + Math.log(0.9 + sc));
        double result = instance.eval(output, y, yWeights);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testEval2() {
        System.out.println("eval2");
        DoubleTensor output = new DoubleTensor(3,3);
        output.data.add(0.7);
        output.data.add(0.2);
        output.data.add(0.1);

        output.data.add(0.49999999999999999999);
        output.data.add(0.5);
        output.data.add(0.00000000000000000001);

        output.data.add(0.99999999999999999999);
        output.data.add(0.0);
        output.data.add(0.00000000000000000001);

        DoubleTensor y = new DoubleTensor(3);
        y.data.add(1);
        y.data.add(2);
        y.data.add(0);

        DoubleTensor yWeights = null;
        CrossEntropy instance = new CrossEntropy();
        double sc = TensorFunctions.smallConst;
        double expResult = -(Math.log(0.2 + sc) + Math.log(0.00000000000000000001 + sc)
                + Math.log(0.99999999999999999999 + sc));
        double result = instance.eval(output, y, yWeights);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of bProp method, of class CrossEntropy.
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
        
        DoubleTensor yWeights = null;
        CrossEntropy instance = new CrossEntropy();
        DoubleTensor expResult = new DoubleTensor(3,3);
        double sc = TensorFunctions.smallConst;
        expResult.data.add(0.0);
        expResult.data.add(-1.0 / (0.2 + sc));
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(-1.0 / (0.2 + sc));

        expResult.data.add(-1.0 / (0.9 + sc));
        expResult.data.add(0.0);
        expResult.data.add(0.0);

        DoubleTensor result = instance.bProp(output, y, yWeights);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    @Test
    public void testBProp2() {
        System.out.println("bProp2");
        DoubleTensor output = new DoubleTensor(3,3);
        output.data.add(0.7);
        output.data.add(0.2);
        output.data.add(0.1);

        output.data.add(0.49999999999999999999);
        output.data.add(0.5);
        output.data.add(0.00000000000000000001);

        output.data.add(0.99999999999999999999);
        output.data.add(0.0);
        output.data.add(0.00000000000000000001);

        DoubleTensor y = new DoubleTensor(3);
        y.data.add(1);
        y.data.add(2);
        y.data.add(0);

        DoubleTensor yWeights = null;
        CrossEntropy instance = new CrossEntropy();
        DoubleTensor expResult = new DoubleTensor(3,3);
        double sc = TensorFunctions.smallConst;
        expResult.data.add(0.0);
        expResult.data.add(-1.0 / (0.2 + sc));
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(-1.0 / (0.00000000000000000001 + sc));

        expResult.data.add(-1.0 / (0.99999999999999999999 + sc));
        expResult.data.add(0.0);
        expResult.data.add(0.0);

        DoubleTensor result = instance.bProp(output, y, yWeights);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

}