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
import tensor.DoubleTensor;

/**
 *
 * @author dp12577
 */
public class SoftMaxLayerTest {

    public SoftMaxLayerTest() {
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
     * Test of fProp method, of class SoftMaxLayer.
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
        input.data.add(12.0);
        input.data.add(-3.0);
        input.data.add(-12.0);
        input.data.add(-1.0);

        SoftMaxLayer instance = new SoftMaxLayer();
        
        DoubleTensor expResult = new DoubleTensor(5,3);
        expResult.data.add(0.0000166429388064997);
        expResult.data.add(0.000122975608492296);
        expResult.data.add(0.000908673669949709);
        expResult.data.add(0.996481676657728);
        expResult.data.add(0.00247003112502349);

        expResult.data.add(2.78934143480825E-10);
        expResult.data.add(0.999954594189122);
        expResult.data.add(2.06106003408699E-09);
        expResult.data.add(0.0000453978683418602);
        expResult.data.add(5.60254203802184E-09);

        expResult.data.add(0.999088946469726);
        expResult.data.add(0.000911051192270605);
        expResult.data.add(2.78692673811533E-10);
        expResult.data.add(3.43934082754742E-14);
        expResult.data.add(2.0592758011544E-09);

        instance.setDimsOfInputsWOE(5);
        instance.initSpaceInMemory(3);

        DoubleTensor result = instance.fProp(input, false);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of bProp method, of class SoftMaxLayer.
     */
    @Test
    public void testBProp() {
        System.out.println("bProp");
        
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
        input.data.add(12.0);
        input.data.add(-3.0);
        input.data.add(-12.0);
        input.data.add(-1.0);
        
        // out, examples
        DoubleTensor chainGrad = new DoubleTensor(5,3);
        chainGrad.data.add(1.0);
        chainGrad.data.add(3.0);
        chainGrad.data.add(5.0);
        chainGrad.data.add(12.0);
        chainGrad.data.add(6.0);

        chainGrad.data.add(9.0);
        chainGrad.data.add(31.0);
        chainGrad.data.add(11.0);
        chainGrad.data.add(21.0);
        chainGrad.data.add(12.0);

        chainGrad.data.add(19.0);
        chainGrad.data.add(12.0);
        chainGrad.data.add(-3.0);
        chainGrad.data.add(-12.0);
        chainGrad.data.add(-1.0);
       
        SoftMaxLayer instance = new SoftMaxLayer();
        
        instance.setDimsOfInputsWOE(5);
        instance.initSpaceInMemory(3);
        instance.fProp(input, false);
        
        DoubleTensor expResult = new DoubleTensor(5,3);
        chainGrad.data.add(-1.82698347467050e-004);
        chainGrad.data.add(-1.10401712163136e-003);
        chainGrad.data.add(-6.34029710601468e-003);
        chainGrad.data.add(2.23916958604006e-002);
        chainGrad.data.add(-1.47646832852877e-002);

        chainGrad.data.add(-6.13642448352117e-009);
        chainGrad.data.add(4.54111869212085e-004);
        chainGrad.data.add(-4.12202646874156e-008);
        chainGrad.data.add(-4.53958066771636e-004);
        chainGrad.data.add(-1.06445754426052e-007);

        chainGrad.data.add(6.37159550578110e-003);
        chainGrad.data.add(-6.37154820286070e-003);
        chainGrad.data.add(-6.12946148761732e-009);
        chainGrad.data.add(-1.06597631582297e-012);
        chainGrad.data.add(-4.11723831859306e-008);
        
        DoubleTensor result = instance.bProp(chainGrad);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

}