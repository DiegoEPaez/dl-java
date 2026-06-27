/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import layer.Layer;
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
public class NeuralNetModelTest {

    public NeuralNetModelTest() {
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
     * Test of gradCE_Softmax method, of class NeuralNetModel.
     */
    @Test
    public void testGradCE_Softmax() {
        System.out.println("gradCE_Softmax");
        DoubleTensor nnOut = new DoubleTensor(3,3);
        nnOut.data.add(0.390693833269816);
        nnOut.data.add(0.31987305633592);
        nnOut.data.add(0.289433110394265);

        nnOut.data.add(0.260302546693899);
        nnOut.data.add(0.351371685289223);
        nnOut.data.add(0.388325768016878);

        nnOut.data.add(5.24288566336346E-22);
        nnOut.data.add(1);
        nnOut.data.add(1.42516408274094E-21);

        DoubleTensor y = new DoubleTensor(3);
        y.data.add(0);
        y.data.add(2.0);
        y.data.add(0);
        DoubleTensor expResult = new DoubleTensor(3,3);

        expResult.data.add(-0.609306166730184);
        expResult.data.add(0.319873056335919);
        expResult.data.add(0.289433110394264);

        expResult.data.add(0.260302546693899);
        expResult.data.add(0.351371685289223);
        expResult.data.add(-0.611674231983121);

        expResult.data.add(-2.26032429790357E-06);
        expResult.data.add(2.26032429790357E-06);
        expResult.data.add(3.2213330047188E-27);

        DoubleTensor result = NeuralNetModel.gradCE_Softmax(nnOut, y);
        
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of gradWCE_Softmax method, of class NeuralNetModel.
     */
    @Test
    public void testGradWCE_Softmax() {
        System.out.println("gradWCE_Softmax");
        DoubleTensor nnOut = new DoubleTensor(3,3);
        nnOut.data.add(0.390693833269816);
        nnOut.data.add(0.31987305633592);
        nnOut.data.add(0.289433110394265);

        nnOut.data.add(0.260302546693899);
        nnOut.data.add(0.351371685289223);
        nnOut.data.add(0.388325768016878);

        nnOut.data.add(5.24288566336346E-22);
        nnOut.data.add(1);
        nnOut.data.add(1.42516408274094E-21);

        DoubleTensor y = new DoubleTensor(3);
        y.data.add(0);
        y.data.add(2.0);
        y.data.add(0);

        DoubleTensor yWeights = new DoubleTensor(3);
        yWeights.data.add(4.0);
        yWeights.data.add(3.0);
        yWeights.data.add(2.0);

        DoubleTensor expResult = new DoubleTensor(3,3);

        expResult.data.add(-2.43722466692074);
        expResult.data.add(1.27949222534368);
        expResult.data.add(1.15773244157706);

        expResult.data.add(0.780907640081696);
        expResult.data.add(1.05411505586767);
        expResult.data.add(-1.83502269594936);

        expResult.data.add(-4.52064859580715E-06);
        expResult.data.add(4.52064859580715E-06);
        expResult.data.add(6.44266600943759E-27);

        DoubleTensor result = NeuralNetModel.gradWCE_Softmax(nnOut, y, yWeights);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

}