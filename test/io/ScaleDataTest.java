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
public class ScaleDataTest {

    public ScaleDataTest() {
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
     * Test of standardizei method, of class ScaleData.
     */
    @Test
    public void testStandardizei() {
        System.out.println("standardizei");
        int byDim = 1;
        DoubleTensor X = new DoubleTensor(new int[]{4,3});
        X.data.add(1.0);
        X.data.add(5.0);
        X.data.add(7.0);
        X.data.add(-1.0);
        X.data.add(3.0);
        X.data.add(4.0);
        X.data.add(12.0);
        X.data.add(-5.0);
        X.data.add(6.0);
        X.data.add(7.0);
        X.data.add(8.0);
        X.data.add(9.0);

        ScaleData instance = new ScaleData();
        DoubleTensor expResult = new DoubleTensor(new int[]{4,3});
        expResult.data.add(-0.927172649945531);
        expResult.data.add(-0.218217890235992);
        expResult.data.add(-0.755928946018454);
        expResult.data.add(-0.277350098112615);
        expResult.data.add(-0.132453235706504);
        expResult.data.add(-0.872871560943969);
        expResult.data.add(1.13389341902768);
        expResult.data.add(-0.832050294337844);
        expResult.data.add(1.05962588565204);
        expResult.data.add(1.09108945117996);
        expResult.data.add(-0.377964473009227);
        expResult.data.add(1.10940039245046);

        DoubleTensor result = instance.standardizei(byDim, X);
        
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of standardizeiWithCalculated method, of class ScaleData.
     */
    @Test
    public void testStandardizeiWithCalculated() {
        System.out.println("standardizeiWithCalculated");
        int byDim = 1;
        DoubleTensor X = new DoubleTensor(new int[]{4,3});
        X.data.add(1.0);
        X.data.add(5.0);
        X.data.add(7.0);
        X.data.add(-1.0);
        X.data.add(3.0);
        X.data.add(4.0);
        X.data.add(12.0);
        X.data.add(-5.0);
        X.data.add(6.0);
        X.data.add(7.0);
        X.data.add(8.0);
        X.data.add(9.0);

        ScaleData instance = new ScaleData();
        DoubleTensor expResult = new DoubleTensor(new int[]{4,3});
        expResult.data.add(-0.927172649945531);
        expResult.data.add(-0.218217890235992);
        expResult.data.add(-0.755928946018454);
        expResult.data.add(-0.277350098112615);
        expResult.data.add(-0.132453235706504);
        expResult.data.add(-0.872871560943969);
        expResult.data.add(1.13389341902768);
        expResult.data.add(-0.832050294337844);
        expResult.data.add(1.05962588565204);
        expResult.data.add(1.09108945117996);
        expResult.data.add(-0.377964473009227);
        expResult.data.add(1.10940039245046);

        instance.Xmean = new DoubleTensor(4);
        instance.Xmean.data.add(3.3333333333333);
        instance.Xmean.data.add(5.3333333333333);
        instance.Xmean.data.add(9.0);
        instance.Xmean.data.add(1.0);

        instance.Xstd = new DoubleTensor(4);
        instance.Xstd.data.add(2.51661147842358);
        instance.Xstd.data.add(1.52752523165195);
        instance.Xstd.data.add(2.64575131106459);
        instance.Xstd.data.add(7.21110255092798);

        DoubleTensor result = instance.standardizeiWithCalculated(byDim, X);
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of normalizationi method, of class ScaleData.
     */
    @Test
    public void testNormalizei() {
        System.out.println("normalizationi");
        int byDim = 1;
        DoubleTensor X = new DoubleTensor(new int[]{4,3});
        X.data.add(1.0);
        X.data.add(5.0);
        X.data.add(7.0);
        X.data.add(-1.0);
        X.data.add(3.0);
        X.data.add(4.0);
        X.data.add(12.0);
        X.data.add(-5.0);
        X.data.add(6.0);
        X.data.add(7.0);
        X.data.add(8.0);
        X.data.add(9.0);

        ScaleData instance = new ScaleData();
        DoubleTensor expResult = new DoubleTensor(new int[]{4,3});
        expResult.data.add(0.0);
        expResult.data.add(0.33333333333333);
        expResult.data.add(0.0);
        expResult.data.add(0.285714285714286);
        expResult.data.add(0.4);
        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(1.0);
        expResult.data.add(0.2);
        expResult.data.add(1.0);

        DoubleTensor result = instance.normalizei(byDim, X);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of normalizeiWithCalculated method, of class ScaleData.
     */
    @Test
    public void testNormalizeiWithCalculated() {
        System.out.println("normalizeiWithCalculated");
        int byDim = 1;
        DoubleTensor X = new DoubleTensor(new int[]{4,3});
        X.data.add(1.0);
        X.data.add(5.0);
        X.data.add(7.0);
        X.data.add(-1.0);
        X.data.add(3.0);
        X.data.add(4.0);
        X.data.add(12.0);
        X.data.add(-5.0);
        X.data.add(6.0);
        X.data.add(7.0);
        X.data.add(8.0);
        X.data.add(9.0);

        ScaleData instance = new ScaleData();
        DoubleTensor expResult = new DoubleTensor(new int[]{4,3});
        expResult.data.add(0.0);
        expResult.data.add(0.33333333333333);
        expResult.data.add(0.0);
        expResult.data.add(0.285714285714286);
        expResult.data.add(0.4);
        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(0.0);
        expResult.data.add(1.0);
        expResult.data.add(1.0);
        expResult.data.add(0.2);
        expResult.data.add(1.0);

        instance.Xmin = new DoubleTensor(4);
        instance.Xmin.data.add(1.0);
        instance.Xmin.data.add(4.0);
        instance.Xmin.data.add(7.0);
        instance.Xmin.data.add(-5.0);

        instance.Xdif = new DoubleTensor(4);
        instance.Xdif.data.add(5.0);
        instance.Xdif.data.add(3.0);
        instance.Xdif.data.add(5.0);
        instance.Xdif.data.add(14.0);

        DoubleTensor result = instance.normalizeiWithCalculated(byDim, X);
        
        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

}