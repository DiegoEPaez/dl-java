/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package layer.subsampling;

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
public class MeanPooling2DLayerTest {

    public MeanPooling2DLayerTest() {
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
     * Test of fProp method, of class MeanPooling2DLayer.
     */
    @Test
    public void testFProp() {
        System.out.println("fProp");
        DoubleTensor input = new DoubleTensor(16,16,1,1);
        for(int i = 0; i < 16 * 16; i++){
            input.data.add(i + 1);
        }

        boolean isTest = false;
        MeanPooling2DLayer instance = new MeanPooling2DLayer(2, 2);
        instance.setDimsOfInputsWOE(16,16,1);
        instance.initSpaceInMemory(1);

        DoubleTensor expResult = new DoubleTensor(8,8,1,1);
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                expResult.data.add(9.5 + i * 32 + j * 2);
            }
        }

        DoubleTensor result = instance.fProp(input, isTest);
        
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of bProp method, of class MeanPooling2DLayer.
     */
    @Test
    public void testBProp() {
        System.out.println("bProp");
        DoubleTensor input = new DoubleTensor(16,16,1,1);
        DoubleTensor chainGrad = new DoubleTensor(8,8,1,1);
        for(int i = 0; i < 16 * 16; i++){
            input.data.add(i + 1);
        }
        for(int i = 0; i < 8 * 8; i++){
            chainGrad.data.add(i + 1);
        }

        MeanPooling2DLayer instance = new MeanPooling2DLayer(2, 2);
        instance.setDimsOfInputsWOE(16,16,1);
        instance.initSpaceInMemory(1);

        DoubleTensor expResult = new DoubleTensor(16,16,1,1);
        expResult.setPosToLast();

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 2; k++){
                    for(int l = 0; l < 2; l++){
                        expResult.data.setQuick( (i * 2 + l) * 16 + (j * 2 + k),chainGrad.getQuick(i * 8 + j) / 4);
                    }
                }
            }
        }

        instance.fProp(input, true);
        DoubleTensor result = instance.bProp(chainGrad);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

}