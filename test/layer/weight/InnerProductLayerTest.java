/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package layer.weight;

import init.Xavier;
import java.util.Random;
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
public class InnerProductLayerTest {

    public InnerProductLayerTest() {
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
     * Test of fProp method, of class InnerProductLayer.
     */
    @Test
    public void testFProp() {
        System.out.println("fProp");
        DoubleTensor input = new DoubleTensor(5,3);
        input.data.add(1.0);
        input.data.add(3.0);
        input.data.add(5.0);
        input.data.add(12.0);
        input.data.add(6.0);

        input.data.add(9.0);
        input.data.add(31.0);
        input.data.add(11.0);
        input.data.add(21.0);
        input.data.add(12.0);

        input.data.add(19.0);
        input.data.add(81.0);
        input.data.add(-3.0);
        input.data.add(-12.0);
        input.data.add(-1.0);

        InnerProductLayer instance = new InnerProductLayer(new Xavier(123), 3);
        instance.setDimsOfInputsWOE(5);
        instance.initParams();
        // one value per neuron
        instance.bias = new DoubleTensor(new double[]{1.0,2.0,3.0}, 3);
        instance.initSpaceInMemory(3);

        DoubleTensor expResult = new DoubleTensor(5,3);
        expResult.data.add(7.24085263751743);
        expResult.data.add(7.04126675445408);
        expResult.data.add(-7.50449237095270);

        expResult.data.add(36.45144226582892);
        expResult.data.add(23.70846796227036);
        expResult.data.add(-25.18283503372241);

        expResult.data.add(75.70641224623233);
        expResult.data.add(40.59558721508843);
        expResult.data.add(-25.51971011575931);

        DoubleTensor result = instance.fProp(input, false);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of bProp method, of class InnerProductLayer.
     */
    @Test
    public void testBProp() {
        System.out.println("bProp");
        DoubleTensor chainGrad = new DoubleTensor(3,3);
        chainGrad.data.add(1.0);
        chainGrad.data.add(2.0);
        chainGrad.data.add(3.0);

        chainGrad.data.add(4.0);
        chainGrad.data.add(5.0);
        chainGrad.data.add(6.0);

        chainGrad.data.add(7.0);
        chainGrad.data.add(8.0);
        chainGrad.data.add(9.0);

        InnerProductLayer instance = new InnerProductLayer(new Xavier(123), 3);
        instance.setDimsOfInputsWOE(5);
        instance.initParams();
        instance.initSpaceInMemory(3);

        DoubleTensor expResult = new DoubleTensor(5,3);
        expResult.data.add(3.807700013698630);
        expResult.data.add(-0.225617534381480);
        expResult.data.add(0.559083211173457);
        expResult.data.add(-1.042503358180192);
        expResult.data.add(-1.434385689115280);

        expResult.data.add(9.038732162323157);
        expResult.data.add(1.623495590903157);
        expResult.data.add(-0.477912795994782);
        expResult.data.add(-1.194972122079640);
        expResult.data.add(-1.672866565579854);

        expResult.data.add(14.269764310947682);
        expResult.data.add(3.472608716187795);
        expResult.data.add(-1.514908803163022);
        expResult.data.add(-1.347440885979086);
        expResult.data.add(-1.911347442044429);

        DoubleTensor result = instance.bProp(chainGrad);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of updateLayerWGrad method, of class InnerProductLayer.
     */
    @Test
    public void testUpdateLayerWGrad() {
        System.out.println("updateLayerWGrad");
        DoubleTensor chainGrad = new DoubleTensor(3,3);
        chainGrad.data.add(1.0);
        chainGrad.data.add(2.0);
        chainGrad.data.add(3.0);

        chainGrad.data.add(4.0);
        chainGrad.data.add(5.0);
        chainGrad.data.add(6.0);

        chainGrad.data.add(7.0);
        chainGrad.data.add(8.0);
        chainGrad.data.add(9.0);

        DoubleTensor input = new DoubleTensor(5,3);
        input.data.add(1.0);
        input.data.add(3.0);
        input.data.add(5.0);
        input.data.add(12.0);
        input.data.add(6.0);

        input.data.add(9.0);
        input.data.add(31.0);
        input.data.add(11.0);
        input.data.add(21.0);
        input.data.add(12.0);

        input.data.add(19.0);
        input.data.add(81.0);
        input.data.add(-3.0);
        input.data.add(-12.0);
        input.data.add(-1.0);

        InnerProductLayer instance = new InnerProductLayer(new Xavier(123), 3);
        instance.setDimsOfInputsWOE(5);
        instance.initParams();
        instance.bias = new DoubleTensor(new double[]{1.0,2.0,3.0}, 3);
        instance.initSpaceInMemory(3);
        instance.fProp(input, false);
        instance.updateLayerWGrad(chainGrad);

        DoubleTensor expWGrad = new DoubleTensor(5,3);
        expWGrad.data.add(170);
        expWGrad.data.add(694);
        expWGrad.data.add(28);
        expWGrad.data.add(12);
        expWGrad.data.add(47);
        
        expWGrad.data.add(199);
        expWGrad.data.add(809);
        expWGrad.data.add(41);
        expWGrad.data.add(33);
        expWGrad.data.add(64);
        
        expWGrad.data.add(228);
        expWGrad.data.add(924);
        expWGrad.data.add(54);
        expWGrad.data.add(54);
        expWGrad.data.add(81);
        
        DoubleTensor expBGrad = new DoubleTensor(3);
        expBGrad.data.add(12);
        expBGrad.data.add(15);
        expBGrad.data.add(18);

        for(int i = 0; i < expWGrad.size(); i++){
            assertEquals(expWGrad.data.getQuick(i), instance.weightsGrad.data.getQuick(i), 1E-7);
        }

        for(int i = 0; i < expBGrad.size(); i++){
            assertEquals(expBGrad.data.getQuick(i), instance.biasGrad.data.getQuick(i), 1E-7);
        }
    }
}