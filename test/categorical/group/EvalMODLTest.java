/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categorical.group;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DiegoEugenio
 */
public class EvalMODLTest {
    
    public EvalMODLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of countEl method, of class EvalMODL.
     */
    @Test
    public void testCountEl() {
        System.out.println("countEl");
        int n = 5;
        int c = 5;
        EvalMODL instance = new EvalMODL();
        double expResult = 52.0;
        double result = instance.countEl(n, c);
        assertEquals(expResult, result, 1E-5);
    }
    
}
