/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tensor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tensor.DoubleTensor.MathOperations;

/**
 *
 * @author dp12577
 */
public class DoubleTensorTest {

    public DoubleTensorTest() {
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
     * Test of size method, of class DoubleTensor.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        DoubleTensor instance = new DoubleTensor(5,4,3);
        for(int i = 0; i < 60; i++){
            instance.data.add(5.3);
        }
        int expResult = 60;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of reshape method, of class DoubleTensor.
     */
    @Test
    public void testReshape() throws Exception {
        System.out.println("reshape");
        DoubleTensor instance = new DoubleTensor(5,4,3);
        instance.reshape(3,4,5);
        assertEquals(instance.dims[0], 3);
        assertEquals(instance.dims[1], 4);
        assertEquals(instance.dims[2], 5);
    }

    /**
     * Test of resize method, of class DoubleTensor.
     */
    @Test
    public void testResize() {
        System.out.println("resize");
        DoubleTensor instance = new DoubleTensor(5,4,3);
        instance.resize(120);
        assertEquals(instance.dims[0], 120);
    }

    /**
     * Test of add method, of class DoubleTensor.
     */
    @Test
    public void testAddi_double() {
        System.out.println("addi");
        double scalar = 5.0;
        DoubleTensor instance = new DoubleTensor(3,2);
        instance.data.add(3.5);
        instance.data.add(2);
        instance.data.add(7);
        instance.data.add(-0.1);
        instance.data.add(12.0);
        instance.data.add(3.0);

        DoubleTensor expResult = new DoubleTensor(3,2);
        expResult.data.add(8.5);
        expResult.data.add(7.0);
        expResult.data.add(12.0);
        expResult.data.add(4.9);
        expResult.data.add(17.0);
        expResult.data.add(8.0);

        DoubleTensor result = instance.addi(scalar);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    @Test
    public void testAdd_double() {
        System.out.println("add_double");
        double scalar = 5.0;
        DoubleTensor instance = new DoubleTensor(3,2);
        instance.data.add(3.5);
        instance.data.add(2);
        instance.data.add(7);
        instance.data.add(-0.1);
        instance.data.add(12.0);
        instance.data.add(3.0);

        DoubleTensor expResult = new DoubleTensor(3,2);
        expResult.data.add(8.5);
        expResult.data.add(7.0);
        expResult.data.add(12.0);
        expResult.data.add(4.9);
        expResult.data.add(17.0);
        expResult.data.add(8.0);

        DoubleTensor result = instance.add(scalar);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of addiLowerDimTensor method, of class DoubleTensor.
     */
    @Test
    public void testAddiLowerDimTensor() {
        System.out.println("addiLowerDimTensor");
        int fixedDim = 1;

        // Test 1
        DoubleTensor x = new DoubleTensor(3,2);
        x.data.add(3.5);
        x.data.add(2);
        x.data.add(7);
        x.data.add(-0.1);
        x.data.add(12.0);
        x.data.add(3.0);
        
        DoubleTensor instance = new DoubleTensor(3);
        instance.data.add(1.0);
        instance.data.add(2.0);
        instance.data.add(3.0);

        DoubleTensor expResult = new DoubleTensor(3,2);
        expResult.data.add(4.5);
        expResult.data.add(4.0);
        expResult.data.add(10.0);
        expResult.data.add(0.9);
        expResult.data.add(14.0);
        expResult.data.add(6.0);

        DoubleTensor result = x.addiLowerDimTensor(fixedDim, instance);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of numToIndices method, of class DoubleTensor.
     */
    @Test
    public void testNumToIndices() {
        System.out.println("numToIndices");

        // Test 1
        int num = 9;
        int[] dims = {2,2,3};
        int[] expResult = {1,0,2};
        int[] result = new int[3];
        DoubleTensor.numToIndices(num, dims,result);
        assertArrayEquals(expResult, result);

        // Test 2
        num = 20;
        dims = new int[]{3,4,2,1};
        expResult = new int[]{2,2,1,0};
        result = new int[4];
        DoubleTensor.numToIndices(num, dims,result);
        assertArrayEquals(expResult, result);

        // Test 3
        num = 50;
        dims = new int[]{3,4,2,1};
        expResult = new int[4];
        result = new int[4];
        DoubleTensor.numToIndices(num, dims,result);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of indicesToNum method, of class DoubleTensor.
     */
    @Test
    public void testIndicesToNum() {
        System.out.println("indicesToNum");

        // Test 1
        int[] indices = {1,0,2};
        int[] dims = {2,2,3};
        int expResult = 9;
        int result = DoubleTensor.indicesToNum(indices, dims);
        assertEquals(expResult, result);

        // Test 2
        indices = new int[]{2,2,1,0};
        dims = new int[]{3,4,2,1};
        expResult = 20;
        result = DoubleTensor.indicesToNum(indices, dims);
        assertEquals(expResult, result);

        // Test 3
        indices = new int[]{2,2,5,0};
        dims = new int[]{3,4,2,1};
        expResult = -1;
        result = DoubleTensor.indicesToNum(indices, dims);
        assertEquals(expResult, result);
    }

    /**
     * Test of subiLowerDimTensor method, of class DoubleTensor.
     */
    @Test
    public void testSubiLowerDimTensor() {
        System.out.println("subiLowerDimTensor");
        int fixedDim = 1;

        // Test 1
        DoubleTensor x = new DoubleTensor(3,2);
        x.data.add(3.5);
        x.data.add(2);
        x.data.add(7);
        x.data.add(-0.1);
        x.data.add(12.0);
        x.data.add(3.0);

        DoubleTensor instance = new DoubleTensor(3);
        instance.data.add(1.0);
        instance.data.add(2.0);
        instance.data.add(3.0);

        DoubleTensor expResult = new DoubleTensor(3,2);
        expResult.data.add(2.5);
        expResult.data.add(0.0);
        expResult.data.add(4.0);
        expResult.data.add(-1.1);
        expResult.data.add(10.0);
        expResult.data.add(0.0);

        DoubleTensor result = x.subiLowerDimTensor(fixedDim, instance);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of muliLowerDimTensor method, of class DoubleTensor.
     */
    @Test
    public void testMuliLowerDimTensor() {
        System.out.println("muliLowerDimTensor");
        int fixedDim = 1;

        // Test 1
        DoubleTensor x = new DoubleTensor(3,2);
        x.data.add(3.5);
        x.data.add(2.0);
        x.data.add(7.0);
        x.data.add(-0.1);
        x.data.add(12.0);
        x.data.add(3.0);

        DoubleTensor instance = new DoubleTensor(3);
        instance.data.add(1.0);
        instance.data.add(2.0);
        instance.data.add(3.0);

        DoubleTensor expResult = new DoubleTensor(3,2);
        expResult.data.add(3.5);
        expResult.data.add(4.0);
        expResult.data.add(21.0);
        expResult.data.add(-0.1);
        expResult.data.add(24.0);
        expResult.data.add(9.0);

        DoubleTensor result = x.muliLowerDimTensor(fixedDim, instance);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of diviLowerDimTensor method, of class DoubleTensor.
     */
    @Test
    public void testDiviLowerDimTensor() {
        System.out.println("diviLowerDimTensor");
        int fixedDim = 1;

        // Test 1
        DoubleTensor x = new DoubleTensor(3,2);
        x.data.add(3.5);
        x.data.add(2);
        x.data.add(7);
        x.data.add(-0.1);
        x.data.add(12.0);
        x.data.add(3.0);

        DoubleTensor instance = new DoubleTensor(3);
        instance.data.add(1.0);
        instance.data.add(2.0);
        instance.data.add(3.0);

        DoubleTensor expResult = new DoubleTensor(3,2);
        expResult.data.add(3.5);
        expResult.data.add(1.0);
        expResult.data.add(2.33333333);
        expResult.data.add(-0.1);
        expResult.data.add(6.0);
        expResult.data.add(1.0);

        DoubleTensor result = x.diviLowerDimTensor(fixedDim, instance);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of rsubiLowerDimTensor method, of class DoubleTensor.
     */
    @Test
    public void testRsubiLowerDimTensor() {
        System.out.println("rsubiLowerDimTensor");
        int fixedDim = 1;

        // Test 1
        DoubleTensor x = new DoubleTensor(3,2);
        x.data.add(3.5);
        x.data.add(2);
        x.data.add(7);
        x.data.add(-0.1);
        x.data.add(12.0);
        x.data.add(3.0);

        DoubleTensor instance = new DoubleTensor(3);
        instance.data.add(1.0);
        instance.data.add(2.0);
        instance.data.add(3.0);

        DoubleTensor expResult = new DoubleTensor(3,2);
        expResult.data.add(-2.5);
        expResult.data.add(0.0);
        expResult.data.add(-4.0);
        expResult.data.add(1.1);
        expResult.data.add(-10.0);
        expResult.data.add(0.0);

        DoubleTensor result = x.rsubiLowerDimTensor(fixedDim, instance);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of rdiviLowerDimTensor method, of class DoubleTensor.
     */
    @Test
    public void testRdiviLowerDimTensor() {
        System.out.println("rdiviLowerDimTensor");
        int fixedDim = 1;

        // Test 1
        DoubleTensor x = new DoubleTensor(3,2);
        x.data.add(3.5);
        x.data.add(2);
        x.data.add(7);
        x.data.add(-0.1);
        x.data.add(12.0);
        x.data.add(3.0);

        DoubleTensor instance = new DoubleTensor(3);
        instance.data.add(1.0);
        instance.data.add(2.0);
        instance.data.add(3.0);

        DoubleTensor expResult = new DoubleTensor(3,2);
        expResult.data.add(0.28571428);
        expResult.data.add(1.0);
        expResult.data.add(0.428571428);
        expResult.data.add(-10.0);
        expResult.data.add(0.166666666);
        expResult.data.add(1.0);

        DoubleTensor result = x.rdiviLowerDimTensor(fixedDim, instance);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of add method, of class DoubleTensor.
     */
    @Test
    public void testAdd_DoubleTensor() {
        System.out.println("add");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(7.0);
        expResult.data.add(7.0);
        expResult.data.add(7.0);
        expResult.data.add(7.0);
        expResult.data.add(7.0);
        expResult.data.add(7.0);

        DoubleTensor result = instance.add(x);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of sub method, of class DoubleTensor.
     */
    @Test
    public void testSub_DoubleTensor() {
        System.out.println("sub");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(5.0);
        expResult.data.add(3.0);
        expResult.data.add(1.0);
        expResult.data.add(-1.0);
        expResult.data.add(-3.0);
        expResult.data.add(-5.0);

        DoubleTensor result = instance.sub(x);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of rsub method, of class DoubleTensor.
     */
    @Test
    public void testRsub_DoubleTensor() {
        System.out.println("rsub");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(-5.0);
        expResult.data.add(-3.0);
        expResult.data.add(-1.0);
        expResult.data.add(1.0);
        expResult.data.add(3.0);
        expResult.data.add(5.0);

        DoubleTensor result = instance.rsub(x);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of mul method, of class DoubleTensor.
     */
    @Test
    public void testMul_DoubleTensor() {
        System.out.println("mul");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(6.0);
        expResult.data.add(10.0);
        expResult.data.add(12.0);
        expResult.data.add(12.0);
        expResult.data.add(10.0);
        expResult.data.add(6.0);

        DoubleTensor result = instance.mul(x);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of div method, of class DoubleTensor.
     */
    @Test
    public void testDiv_DoubleTensor() {
        System.out.println("div");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(6.0);
        expResult.data.add(2.5);
        expResult.data.add(1.33333333333);        
        expResult.data.add(0.75);
        expResult.data.add(0.4);
        expResult.data.add(0.16666666666);

        DoubleTensor result = instance.div(x);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of rdiv method, of class DoubleTensor.
     */
    @Test
    public void testRdiv_DoubleTensor() {
        System.out.println("rdiv");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(0.16666666666);
        expResult.data.add(0.4);
        expResult.data.add(0.75);
        expResult.data.add(1.33333333333);
        expResult.data.add(2.5);
        expResult.data.add(6.0);

        DoubleTensor result = instance.rdiv(x);
        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of addi method, of class DoubleTensor.
     */
    @Test
    public void testAddi_DoubleTensor() {
        System.out.println("addi");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(7.0);
        expResult.data.add(7.0);
        expResult.data.add(7.0);
        expResult.data.add(7.0);
        expResult.data.add(7.0);
        expResult.data.add(7.0);

        DoubleTensor result = instance.addi(x);
        assertArrayEquals(expResult.dims, result.dims);
        assertEquals(instance, result);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of subi method, of class DoubleTensor.
     */
    @Test
    public void testSubi_DoubleTensor() {
        System.out.println("subi");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(5.0);
        expResult.data.add(3.0);
        expResult.data.add(1.0);
        expResult.data.add(-1.0);
        expResult.data.add(-3.0);
        expResult.data.add(-5.0);

        DoubleTensor result = instance.subi(x);
        assertArrayEquals(expResult.dims, result.dims);
        assertEquals(instance, result);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of rsubi method, of class DoubleTensor.
     */
    @Test
    public void testRsubi_DoubleTensor() {
        System.out.println("rsubi");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(-5.0);
        expResult.data.add(-3.0);
        expResult.data.add(-1.0);
        expResult.data.add(1.0);
        expResult.data.add(3.0);
        expResult.data.add(5.0);

        DoubleTensor result = instance.rsubi(x);
        assertArrayEquals(expResult.dims, result.dims);
        assertEquals(instance, result);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of muli method, of class DoubleTensor.
     */
    @Test
    public void testMuli_DoubleTensor() {
        System.out.println("muli");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(6.0);
        expResult.data.add(10.0);
        expResult.data.add(12.0);
        expResult.data.add(12.0);
        expResult.data.add(10.0);
        expResult.data.add(6.0);

        DoubleTensor result = instance.muli(x);
        assertArrayEquals(expResult.dims, result.dims);
        assertEquals(instance, result);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of divi method, of class DoubleTensor.
     */
    @Test
    public void testDivi_DoubleTensor() {
        System.out.println("divi");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(6.0);
        expResult.data.add(2.5);
        expResult.data.add(1.33333333333);
        expResult.data.add(0.75);
        expResult.data.add(0.4);
        expResult.data.add(0.16666666666);

        DoubleTensor result = instance.divi(x);
        assertArrayEquals(expResult.dims, result.dims);
        assertEquals(instance, result);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of rdivi method, of class DoubleTensor.
     */
    @Test
    public void testRdivi_DoubleTensor() {
        System.out.println("rdivi");
        DoubleTensor x = new DoubleTensor(2,2,2);
        x.data.add(1.0);
        x.data.add(2.0);
        x.data.add(3.0);
        x.data.add(4.0);
        x.data.add(5.0);
        x.data.add(6.0);

        DoubleTensor instance = new DoubleTensor(2,2,2);
        instance.data.add(6.0);
        instance.data.add(5.0);
        instance.data.add(4.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(2,2,2);
        expResult.data.add(0.16666666666);
        expResult.data.add(0.4);
        expResult.data.add(0.75);
        expResult.data.add(1.33333333333);
        expResult.data.add(2.5);
        expResult.data.add(6.0);

        DoubleTensor result = instance.rdivi(x);
        assertArrayEquals(expResult.dims, result.dims);
        assertEquals(instance, result);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of byDimSum method, of class DoubleTensor.
     */
    @Test
    public void testByDimSum() {
        System.out.println("byDimSum");
        int aggDim = 0;
        DoubleTensor instance = new DoubleTensor(4,2);
        instance.data.add(5.0);
        instance.data.add(8.0);
        instance.data.add(1.0);
        instance.data.add(-2.0);
        instance.data.add(7.6);
        instance.data.add(-0.12);
        instance.data.add(4.0);
        instance.data.add(9.0);

        DoubleTensor expResult = new DoubleTensor(2);
        expResult.data.add(12.0);
        expResult.data.add(20.48);

        DoubleTensor result = instance.byDimSum(aggDim);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of byDimProduct method, of class DoubleTensor.
     */
    @Test
    public void testByDimProduct() {
        System.out.println("byDimProduct");
        int aggDim = 0;
        DoubleTensor instance = new DoubleTensor(4,2);
        instance.data.add(5.0);
        instance.data.add(8.0);
        instance.data.add(1.0);
        instance.data.add(-2.0);
        instance.data.add(7.6);
        instance.data.add(-0.12);
        instance.data.add(4.0);
        instance.data.add(9.0);

        DoubleTensor expResult = new DoubleTensor(2);
        expResult.data.add(-80.0);
        expResult.data.add(-32.832);

        DoubleTensor result = instance.byDimProduct(aggDim);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of byDimMin method, of class DoubleTensor.
     */
    @Test
    public void testByDimMin() {
        System.out.println("byDimMin");
        int aggDim = 0;
        DoubleTensor instance = new DoubleTensor(4,2);
        instance.data.add(5.0);
        instance.data.add(8.0);
        instance.data.add(1.0);
        instance.data.add(-2.0);
        instance.data.add(7.6);
        instance.data.add(-0.12);
        instance.data.add(4.0);
        instance.data.add(9.0);

        DoubleTensor expResult = new DoubleTensor(2);
        expResult.data.add(-2.0);
        expResult.data.add(-0.12);

        DoubleTensor result = instance.byDimMin(aggDim);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of byDimMax method, of class DoubleTensor.
     */
    @Test
    public void testByDimMax() {
        System.out.println("byDimMax");
        int aggDim = 0;
        DoubleTensor instance = new DoubleTensor(4,2);
        instance.data.add(5.0);
        instance.data.add(8.0);
        instance.data.add(1.0);
        instance.data.add(-2.0);
        instance.data.add(7.6);
        instance.data.add(-0.12);
        instance.data.add(4.0);
        instance.data.add(9.0);

        DoubleTensor expResult = new DoubleTensor(2);
        expResult.data.add(8.0);
        expResult.data.add(9.0);

        DoubleTensor result = instance.byDimMax(aggDim);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test 1 of mmul method, of class DoubleTensor.
     */
    @Test
    public void testMmul() {
        System.out.println("mmul");
        boolean trans = false;
        boolean transOther = false;

        DoubleTensor instance = new DoubleTensor(new int[]{2,3});
        instance.data.add(1.0);
        instance.data.add(5.0);
        instance.data.add(7.0);
        instance.data.add(-1.0);
        instance.data.add(3.0);
        instance.data.add(4.0);
        DoubleTensor other = new DoubleTensor(new int[]{3,4});
        other.data.add(8.0);
        other.data.add(-5.0);
        other.data.add(9.0);
        other.data.add(12.0);
        other.data.add(31.0);
        other.data.add(10.0);
        other.data.add(11.0);
        other.data.add(-3.0);
        other.data.add(21.0);
        other.data.add(99.0);
        other.data.add(12.0);
        other.data.add(5.5);
        DoubleTensor expResult = new DoubleTensor(new int[]{2,4});
        expResult.data.add(0.0);
        expResult.data.add(81.0);
        expResult.data.add(259.0);
        expResult.data.add(69.0);
        expResult.data.add(53.0);
        expResult.data.add(142.0);
        expResult.data.add(199.5);
        expResult.data.add(505.0);
        DoubleTensor result = instance.mmul(trans, transOther, other);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test 2 of mmul method, of class DoubleTensor.
     */
    @Test
    public void testMmul2() {
        System.out.println("mmul");
        boolean trans = true;
        boolean transOther = false;

        DoubleTensor instance = new DoubleTensor(new int[]{3,2});
        instance.data.add(1.0);
        instance.data.add(5.0);
        instance.data.add(7.0);
        instance.data.add(-1.0);
        instance.data.add(3.0);
        instance.data.add(4.0);
        DoubleTensor other = new DoubleTensor(new int[]{3,4});
        other.data.add(8.0);
        other.data.add(-5.0);
        other.data.add(9.0);
        other.data.add(12.0);
        other.data.add(31.0);
        other.data.add(10.0);
        other.data.add(11.0);
        other.data.add(-3.0);
        other.data.add(21.0);
        other.data.add(99.0);
        other.data.add(12.0);
        other.data.add(5.5);
        DoubleTensor expResult = new DoubleTensor(new int[]{2,4});
        expResult.data.add(46.0);
        expResult.data.add(13.0);
        expResult.data.add(237.0);
        expResult.data.add(121.0);
        expResult.data.add(143.0);
        expResult.data.add(64.0);
        expResult.data.add(197.5);
        expResult.data.add(-41.0);
        DoubleTensor result = instance.mmul(trans, transOther, other);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test 3 of mmul method, of class DoubleTensor.
     */
    @Test
    public void testMmul3() {
        System.out.println("mmul");
        boolean trans = false;
        boolean transOther = false;

        DoubleTensor instance = new DoubleTensor(new int[]{3,2});
        instance.data.add(1.0);
        instance.data.add(5.0);
        instance.data.add(7.0);
        instance.data.add(-1.0);
        instance.data.add(3.0);
        instance.data.add(4.0);
        instance.reshape(2,2);

        DoubleTensor other = new DoubleTensor(new int[]{2,4});
        other.data.add(8.0);
        other.data.add(-5.0);
        other.data.add(9.0);
        other.data.add(12.0);
        other.data.add(31.0);
        other.data.add(10.0);
        other.data.add(11.0);
        other.data.add(-3.0);
        
        DoubleTensor expResult = new DoubleTensor(new int[]{2,4});
        expResult.data.add(-27);
        expResult.data.add(45);
        expResult.data.add(93);
        expResult.data.add(33);
        expResult.data.add(101);
        expResult.data.add(145);
        expResult.data.add(-10);
        expResult.data.add(58);
        DoubleTensor result = instance.mmul(trans, transOther, other);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of copyDims method, of class DoubleTensor.
     */
    @Test
    public void testCopyDims() {
        System.out.println("copyDims");
        DoubleTensor instance = new DoubleTensor(3,4,5);
        int[] expResult = new int[]{3,4,5};
        int[] result = instance.copyDims();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of copy method, of class DoubleTensor.
     */
    @Test
    public void testCopy() {
        System.out.println("copy");
        DoubleTensor instance = new DoubleTensor(new int[]{3,2});
        instance.data.add(1.0);
        instance.data.add(5.0);
        instance.data.add(7.0);
        instance.data.add(-1.0);
        instance.data.add(3.0);
        instance.data.add(4.0);

        DoubleTensor expResult = new DoubleTensor(new int[]{3,2});
        expResult.data.add(1.0);
        expResult.data.add(5.0);
        expResult.data.add(7.0);
        expResult.data.add(-1.0);
        expResult.data.add(3.0);
        expResult.data.add(4.0);

        DoubleTensor result = instance.copy();
        assertArrayEquals(expResult.dims, result.dims);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of byDimAvg method, of class DoubleTensor.
     */
    @Test
    public void testByDimAvg() {
        System.out.println("byDimAvg");
        int aggDim = 1;

        DoubleTensor instance = new DoubleTensor(new int[]{4,3});
        instance.data.add(1.0);
        instance.data.add(5.0);
        instance.data.add(7.0);
        instance.data.add(-1.0);
        instance.data.add(3.0);
        instance.data.add(4.0);
        instance.data.add(12.0);
        instance.data.add(-5.0);
        instance.data.add(6.0);
        instance.data.add(7.0);
        instance.data.add(8.0);
        instance.data.add(9.0);
        
        DoubleTensor expResult = new DoubleTensor(new int[]{4});
        expResult.data.add(3.333333333333333);
        expResult.data.add(5.333333333333333);
        expResult.data.add(9.0);
        expResult.data.add(1.0);

        DoubleTensor result = instance.byDimAvg(aggDim);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of byDimStd method, of class DoubleTensor.
     */
    @Test
    public void testByDimStd() {
        System.out.println("byDimStd");
        int aggDim = 1;

        DoubleTensor instance = new DoubleTensor(new int[]{4,3});
        instance.data.add(1.0);
        instance.data.add(5.0);
        instance.data.add(7.0);
        instance.data.add(-1.0);
        instance.data.add(3.0);
        instance.data.add(4.0);
        instance.data.add(12.0);
        instance.data.add(-5.0);
        instance.data.add(6.0);
        instance.data.add(7.0);
        instance.data.add(8.0);
        instance.data.add(9.0);

        DoubleTensor expResult = new DoubleTensor(new int[]{4});
        expResult.data.add(2.51661147842358);
        expResult.data.add(1.52752523165195);
        expResult.data.add(2.64575131106459);
        expResult.data.add(7.21110255092798);

        DoubleTensor result = instance.byDimStd(aggDim);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }
    
    @Test
    public void testGetLowerDim(){
        System.out.println("getLowerDim");

        DoubleTensor instance = new DoubleTensor(new int[]{4,3});
        instance.data.add(1.0);
        instance.data.add(5.0);
        instance.data.add(7.0);
        instance.data.add(-1.0);
        instance.data.add(3.0);
        instance.data.add(4.0);
        instance.data.add(12.0);
        instance.data.add(-5.0);
        instance.data.add(6.0);
        instance.data.add(7.0);
        instance.data.add(8.0);
        instance.data.add(9.0);

        double[] indices = new double[]{0,1,1,2};

        DoubleTensor expResult = new DoubleTensor(new int[]{4});
        expResult.data.add(1.0);
        expResult.data.add(4.0);
        expResult.data.add(12.0);
        expResult.data.add(9.0);
        
        DoubleTensor result = instance.getLowerDim(1,new DoubleTensor(indices,1));
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    @Test
    public void testGetLowerDim2(){
        System.out.println("getByDim2");

        DoubleTensor instance = new DoubleTensor(3,3);
        instance.data.add(0.7);
        instance.data.add(0.2);
        instance.data.add(0.1);

        instance.data.add(0.3);
        instance.data.add(0.5);
        instance.data.add(0.2);

        instance.data.add(0.9);
        instance.data.add(0.05);
        instance.data.add(0.05);

        DoubleTensor y = new DoubleTensor(3);
        y.data.add(1);
        y.data.add(2);
        y.data.add(0);

        DoubleTensor expResult = new DoubleTensor(3);
        expResult.data.add(0.2);
        expResult.data.add(0.2);
        expResult.data.add(0.9);

        DoubleTensor result = instance.getLowerDim(0,y);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    @Test
    public void testIndex(){
        System.out.println("index");

        DoubleTensor instance = new DoubleTensor(new int[]{4,3});
        instance.data.add(0.0);
        instance.data.add(2.0);
        instance.data.add(1.0);
        instance.data.add(3.0);
        instance.data.add(3.0);
        instance.data.add(2.0);
        instance.data.add(0.0);
        instance.data.add(2.0);
        instance.data.add(1.0);
        instance.data.add(2.0);
        instance.data.add(1.0);
        instance.data.add(3.0);

        DoubleTensor expResult = new DoubleTensor(new int[]{4,4,3});
        expResult.data.add(1.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(1.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(1.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(0.0);

        expResult.data.add(1.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);

        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(0.0);
        expResult.data.add(1.0);

        DoubleTensor result = instance.index(4);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    @Test
    public void testGetByDim(){
        System.out.println("getByDim");

        DoubleTensor instance = new DoubleTensor(new int[]{3,3});
        instance.data.add(0.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        instance.data.add(3.0);
        instance.data.add(3.0);
        instance.data.add(2.0);

        instance.data.add(7.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(new int[]{3,2});

        expResult.data.add(0.0);
        expResult.data.add(2.0);
        expResult.data.add(1.0);

        expResult.data.add(7.0);
        expResult.data.add(2.0);
        expResult.data.add(1.0);

        DoubleTensor result = instance.getByDim(1,new TensorIndex(new int[]{0,2}));

        assertArrayEquals(expResult.dims, result.dims);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    @Test
    public void testSumAlli(){
        System.out.println("sumAlli");
        int aggDim = 1;
        DoubleTensor instance = new DoubleTensor(new int[]{3,3,2});
        instance.data.add(0.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        instance.data.add(3.0);
        instance.data.add(3.0);
        instance.data.add(2.0);

        instance.data.add(7.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        instance.data.add(0.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        instance.data.add(3.0);
        instance.data.add(3.0);
        instance.data.add(2.0);

        instance.data.add(7.0);
        instance.data.add(2.0);
        instance.data.add(1.0);

        DoubleTensor expResult = new DoubleTensor(new int[]{3});

        expResult.data.add(6.0);
        expResult.data.add(16.0);
        expResult.data.add(20.0);

        DoubleTensor result = new DoubleTensor(new int[]{3});
        instance.sumAlli(aggDim, result);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }
}