/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io;

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
public class ReadMNISTTest {

    public ReadMNISTTest() {
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
     * Test of loadMNISTImages method, of class ReadMNIST.
     */
    @Test
    public void testLoadMNISTImages() {
        System.out.println("loadMNISTImages");
        String fileName = "train-images.idx3-ubyte";
        boolean binaryDigits = false;
        int filter = 1;
        DoubleTensor expResult = new DoubleTensor(28,28,filter);
        for(int i = 0; i < 784; i++){
            if(i == 135){
                expResult.data.add(0.215686274509803);
            } else if(i == 136){
                expResult.data.add(0.533333333333333);
            } else if(i == 163){
                expResult.data.add(0.674509803921568);
            } else if(i == 164){
                expResult.data.add(0.992156862745098);
            } else if(i == 190){
                expResult.data.add(0.0705882352941176);
            } else if(i == 191){
                expResult.data.add(0.886274509803921);
            } else if(i == 192){
                expResult.data.add(0.992156862745098);
            } else if(i == 203){
                expResult.data.add(0.192156862745098);
            } else if(i == 204){
                expResult.data.add(0.0705882352941176);
            } else if(i == 218){
                expResult.data.add(0.670588235294117);
            } else if(i == 219){
                expResult.data.add(0.992156862745098);
            } else if(i == 220){
                expResult.data.add(0.992156862745098);
            } else if(i == 230){
                expResult.data.add(0.117647058823529);
            } else if(i == 231){
                expResult.data.add(0.933333333333333);
            } else if(i == 232){
                expResult.data.add(0.858823529411764);
            } else if(i == 233){
                expResult.data.add(0.313725490196078);
            } else{
                expResult.data.add(0.0);
            }
        }

        DoubleTensor result = ReadMNIST.loadMNISTImages(fileName, binaryDigits, filter,0);
        for(int i = 0; i < 234; i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of loadMNISTLabels method, of class ReadMNIST.
     */
    @Test
    public void testLoadMNISTLabels() {
        System.out.println("loadMNISTLabels");
        String fileName = "train-labels.idx1-ubyte";
        boolean binaryDigits = false;
        int filter = 2;
        DoubleTensor expResult = new DoubleTensor(filter);
        expResult.data.add(5.0);
        expResult.data.add(0.0);
        DoubleTensor result = ReadMNIST.loadMNISTLabels(fileName, binaryDigits, filter);
        for(int i = 0; i < 2; i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

}