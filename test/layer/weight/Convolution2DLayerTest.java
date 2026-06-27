/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package layer.weight;

import init.He;
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
public class Convolution2DLayerTest {

    public Convolution2DLayerTest() {
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
     * Test of fProp method, of class Convolution2DLayer.
     */
    @Test
    public void testFProp() {
        System.out.println("fProp");

        // kW,kH,c,f
        DoubleTensor input = new DoubleTensor(6,6,2,1);
        for(int i = 0; i < 72; i++){
            input.data.add(i+1);
        }

        Convolution2DLayer instance = new Convolution2DLayer(new He(123), 1,3,3);
        instance.setDimsOfInputsWOE(6,6,2);
        instance.initParams();
        instance.bias = new DoubleTensor(new double[]{1.0}, 1);
        instance.initSpaceInMemory(1);

        DoubleTensor expResult = new DoubleTensor(4,4,1,1);
        expResult.data.add(-24.8482039756795);
        expResult.data.add(-21.2469189094761);
        expResult.data.add(-17.6456338432727);
        expResult.data.add(-14.0443487770693);

        expResult.data.add(-3.24049357845901);
        expResult.data.add(0.360791487744422);
        expResult.data.add(3.96207655394784);
        expResult.data.add(7.56336162015128);

        expResult.data.add(18.3672168187616);
        expResult.data.add(21.968501884965);
        expResult.data.add(25.5697869511684);
        expResult.data.add(29.1710720173718);

        expResult.data.add(39.9749272159821);
        expResult.data.add(43.5762122821856);
        expResult.data.add(47.177497348389);
        expResult.data.add(50.7787824145924);

        DoubleTensor result = instance.fProp(input, false);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    @Test
    public void testFProp2() {
        System.out.println("fProp2");

        // kW,kH,c,f
        DoubleTensor input = new DoubleTensor(6,6,2,1);
        for(int i = 0; i < 72; i++){
            input.data.add(i+1);
        }

        Convolution2DLayer instance = new Convolution2DLayer(new He(123), 1,3,3,1,1,
                Convolution2DLayer.ConvolveMethod.FFT);
        instance.setDimsOfInputsWOE(6,6,2);
        instance.initParams();
        instance.bias = new DoubleTensor(new double[]{1.0}, 1);
        instance.initSpaceInMemory(1);

        DoubleTensor expResult = new DoubleTensor(4,4,1,1);
        expResult.data.add(-24.8482039756795);
        expResult.data.add(-21.2469189094761);
        expResult.data.add(-17.6456338432727);
        expResult.data.add(-14.0443487770693);

        expResult.data.add(-3.24049357845901);
        expResult.data.add(0.360791487744422);
        expResult.data.add(3.96207655394784);
        expResult.data.add(7.56336162015128);

        expResult.data.add(18.3672168187616);
        expResult.data.add(21.968501884965);
        expResult.data.add(25.5697869511684);
        expResult.data.add(29.1710720173718);

        expResult.data.add(39.9749272159821);
        expResult.data.add(43.5762122821856);
        expResult.data.add(47.177497348389);
        expResult.data.add(50.7787824145924);

        DoubleTensor result = instance.fProp(input, false);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of bProp method, of class Convolution2DLayer.
     */
    @Test
    public void testBProp() {
        System.out.println("bProp");
        DoubleTensor chainGrad = new DoubleTensor(4,4,1,1);
        DoubleTensor input = new DoubleTensor(6,6,2,1);
        for(int i = 0; i < 72; i++){
            input.data.add(i+1);
        }

        for(int i = 0; i < 16; i++){
            chainGrad.data.add(i+1);
        }

        Convolution2DLayer instance = new Convolution2DLayer(new He(123),
                1,3,3,1,1,Convolution2DLayer.ConvolveMethod.CONV2D);
        instance.setDimsOfInputsWOE(6,6,2);
        instance.initParams();
        instance.bias = new DoubleTensor(new double[]{1.0}, 1);
        instance.initSpaceInMemory(1);

        DoubleTensor expResult = new DoubleTensor(6,6,2,1);
        expResult.data.add(0.592297194843191);
        expResult.data.add(3.54607331544021);
        expResult.data.add(5.83568677886765);
        expResult.data.add(8.12530024229508);
        expResult.data.add(7.45342773150657);
        expResult.data.add(-2.65665062867834);
        expResult.data.add(3.23767972179913);
        expResult.data.add(16.7763406843231);
        expResult.data.add(18.7006295936981);
        expResult.data.add(23.2815691317514);
        expResult.data.add(21.1508651783001);
        expResult.data.add(-0.70387351449988);

        expResult.data.add(7.28278610077907);
        expResult.data.add(32.8279456327716);
        expResult.data.add(36.6428328151818);
        expResult.data.add(41.161593512092);
        expResult.data.add(32.6390339014196);
        expResult.data.add(4.56226303054905);
        expResult.data.add(13.0413203075825);
        expResult.data.add(45.6368518753632);
        expResult.data.add(54.7178756028224);
        expResult.data.add(59.2366362997325);
        expResult.data.add(44.9555424822566);
        expResult.data.add(9.82839957559798);

        expResult.data.add(8.73080220205173);
        expResult.data.add(7.63926687296221);
        expResult.data.add(30.3234161967562);
        expResult.data.add(32.5525634302389);
        expResult.data.add(22.6615630342392);
        expResult.data.add(28.3777892640386);
        expResult.data.add(7.42485392056851);
        expResult.data.add(-11.0056004759158);
        expResult.data.add(-1.12770102444752);
        expResult.data.add(-1.1898798655907);
        expResult.data.add(-10.9614830644004);
        expResult.data.add(13.2534377234819);

        expResult.data.add(0.198612179805616);
        expResult.data.add(1.72652511933285);
        expResult.data.add(2.21333809774256);
        expResult.data.add(2.70015107615226);
        expResult.data.add(2.19390315553389);
        expResult.data.add(-4.16439984447012);
        expResult.data.add(2.95680129499934);
        expResult.data.add(10.2562399238173);
        expResult.data.add(5.55358441194655);
        expResult.data.add(5.01532874454593);
        expResult.data.add(-7.12913852096154);
        expResult.data.add(-14.2463648737985);

        expResult.data.add(10.2700748709848);
        expResult.data.add(15.3224293938369);
        expResult.data.add(0.158588889331628);
        expResult.data.add(-0.758886741375073);
        expResult.data.add(-15.2513006376857);
        expResult.data.add(-19.7387451060142);
        expResult.data.add(13.5749382656039);
        expResult.data.add(17.1449071032257);
        expResult.data.add(-3.51131363349518);
        expResult.data.add(-4.42878926420188);
        expResult.data.add(-22.2260665551317);
        expResult.data.add(-25.2311253382298);

        expResult.data.add(13.5033946035277);
        expResult.data.add(-7.20574733915411);
        expResult.data.add(-17.1835619086198);
        expResult.data.add(-18.5878505177362);
        expResult.data.add(-36.005948405777);
        expResult.data.add(-9.90150634809484);
        expResult.data.add(-17.369777452587);
        expResult.data.add(-21.1821468407176);
        expResult.data.add(-7.79261241268536);
        expResult.data.add(-8.17183237599144);
        expResult.data.add(14.1632720217778);
        expResult.data.add(18.358339188451);

        instance.fProp(input, false);
        DoubleTensor result = instance.bProp(chainGrad);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    @Test
    public void testBProp2() {
        System.out.println("bProp");
        DoubleTensor chainGrad = new DoubleTensor(4,4,1,1);
        DoubleTensor input = new DoubleTensor(6,6,2,1);
        for(int i = 0; i < 72; i++){
            input.data.add(i+1);
        }

        for(int i = 0; i < 16; i++){
            chainGrad.data.add(i+1);
        }

        Convolution2DLayer instance = new Convolution2DLayer(new He(123),
                1,3,3,1,1,Convolution2DLayer.ConvolveMethod.FFT);
        instance.setDimsOfInputsWOE(6,6,2);
        instance.initParams();
        instance.bias = new DoubleTensor(new double[]{1.0}, 1);
        instance.initSpaceInMemory(1);

        DoubleTensor expResult = new DoubleTensor(6,6,2,1);
        expResult.data.add(0.592297194843191);
        expResult.data.add(3.54607331544021);
        expResult.data.add(5.83568677886765);
        expResult.data.add(8.12530024229508);
        expResult.data.add(7.45342773150657);
        expResult.data.add(-2.65665062867834);
        expResult.data.add(3.23767972179913);
        expResult.data.add(16.7763406843231);
        expResult.data.add(18.7006295936981);
        expResult.data.add(23.2815691317514);
        expResult.data.add(21.1508651783001);
        expResult.data.add(-0.70387351449988);

        expResult.data.add(7.28278610077907);
        expResult.data.add(32.8279456327716);
        expResult.data.add(36.6428328151818);
        expResult.data.add(41.161593512092);
        expResult.data.add(32.6390339014196);
        expResult.data.add(4.56226303054905);
        expResult.data.add(13.0413203075825);
        expResult.data.add(45.6368518753632);
        expResult.data.add(54.7178756028224);
        expResult.data.add(59.2366362997325);
        expResult.data.add(44.9555424822566);
        expResult.data.add(9.82839957559798);

        expResult.data.add(8.73080220205173);
        expResult.data.add(7.63926687296221);
        expResult.data.add(30.3234161967562);
        expResult.data.add(32.5525634302389);
        expResult.data.add(22.6615630342392);
        expResult.data.add(28.3777892640386);
        expResult.data.add(7.42485392056851);
        expResult.data.add(-11.0056004759158);
        expResult.data.add(-1.12770102444752);
        expResult.data.add(-1.1898798655907);
        expResult.data.add(-10.9614830644004);
        expResult.data.add(13.2534377234819);

        expResult.data.add(0.198612179805616);
        expResult.data.add(1.72652511933285);
        expResult.data.add(2.21333809774256);
        expResult.data.add(2.70015107615226);
        expResult.data.add(2.19390315553389);
        expResult.data.add(-4.16439984447012);
        expResult.data.add(2.95680129499934);
        expResult.data.add(10.2562399238173);
        expResult.data.add(5.55358441194655);
        expResult.data.add(5.01532874454593);
        expResult.data.add(-7.12913852096154);
        expResult.data.add(-14.2463648737985);

        expResult.data.add(10.2700748709848);
        expResult.data.add(15.3224293938369);
        expResult.data.add(0.158588889331628);
        expResult.data.add(-0.758886741375073);
        expResult.data.add(-15.2513006376857);
        expResult.data.add(-19.7387451060142);
        expResult.data.add(13.5749382656039);
        expResult.data.add(17.1449071032257);
        expResult.data.add(-3.51131363349518);
        expResult.data.add(-4.42878926420188);
        expResult.data.add(-22.2260665551317);
        expResult.data.add(-25.2311253382298);

        expResult.data.add(13.5033946035277);
        expResult.data.add(-7.20574733915411);
        expResult.data.add(-17.1835619086198);
        expResult.data.add(-18.5878505177362);
        expResult.data.add(-36.005948405777);
        expResult.data.add(-9.90150634809484);
        expResult.data.add(-17.369777452587);
        expResult.data.add(-21.1821468407176);
        expResult.data.add(-7.79261241268536);
        expResult.data.add(-8.17183237599144);
        expResult.data.add(14.1632720217778);
        expResult.data.add(18.358339188451);

        instance.fProp(input, false);
        DoubleTensor result = instance.bProp(chainGrad);

        for(int i = 0; i < expResult.size(); i++){
            assertEquals(expResult.data.getQuick(i), result.data.getQuick(i), 1E-7);
        }
    }

    /**
     * Test of updateLayerWGrad method, of class Convolution2DLayer.
     */
    @Test
    public void testUpdateLayerWGrad() {
        System.out.println("updateLayerWGrad");
        DoubleTensor chainGrad = new DoubleTensor(4,4,1,1);
        DoubleTensor input = new DoubleTensor(6,6,2,1);
        for(int i = 0; i < 72; i++){
            input.data.add(i+1);
        }

        for(int i = 0; i < 16; i++){
            chainGrad.data.add(i+1);
        }

        Convolution2DLayer instance = new Convolution2DLayer(new He(123),
                1,3,3,1,1,Convolution2DLayer.ConvolveMethod.CONV2D);
        instance.setDimsOfInputsWOE(6,6,2);
        instance.initParams();
        instance.bias = new DoubleTensor(new double[]{1.0}, 1);
        instance.initSpaceInMemory(1);

        DoubleTensor expResultWeightsG = new DoubleTensor(3,3,2,1);
        expResultWeightsG.data.add(2064);
        expResultWeightsG.data.add(2200);
        expResultWeightsG.data.add(2336);
        expResultWeightsG.data.add(2880);
        expResultWeightsG.data.add(3016);
        expResultWeightsG.data.add(3152);
        expResultWeightsG.data.add(3696);
        expResultWeightsG.data.add(3832);
        expResultWeightsG.data.add(3968);

        expResultWeightsG.data.add(6960);
        expResultWeightsG.data.add(7096);
        expResultWeightsG.data.add(7232);
        expResultWeightsG.data.add(7776);
        expResultWeightsG.data.add(7912);
        expResultWeightsG.data.add(8048);
        expResultWeightsG.data.add(8592);
        expResultWeightsG.data.add(8728);
        expResultWeightsG.data.add(8864);

        DoubleTensor expResultBiasG = new DoubleTensor(1);
        expResultBiasG.data.add(136);
        instance.fProp(input, false);
        instance.updateLayerWGrad(chainGrad);

        for(int i = 0; i < instance.weightsGrad.size(); i++){
            assertEquals(expResultWeightsG.data.getQuick(i), instance.weightsGrad.data.getQuick(i), 1E-7);
        }

        for(int i = 0; i < instance.biasGrad.size(); i++){
            assertEquals(expResultBiasG.data.getQuick(i), instance.biasGrad.data.getQuick(i), 1E-7);
        }
    }

    @Test
    public void testUpdateLayerWGrad2() {
        System.out.println("updateLayerWGrad2");
        DoubleTensor chainGrad = new DoubleTensor(4,4,1,1);
        DoubleTensor input = new DoubleTensor(6,6,2,1);
        for(int i = 0; i < 72; i++){
            input.data.add(i+1);
        }

        for(int i = 0; i < 16; i++){
            chainGrad.data.add(i+1);
        }

        Convolution2DLayer instance = new Convolution2DLayer(new He(123),
                1,3,3,1,1,Convolution2DLayer.ConvolveMethod.FFT);
        instance.setDimsOfInputsWOE(6,6,2);
        instance.initParams();
        instance.bias = new DoubleTensor(new double[]{1.0}, 1);
        instance.initSpaceInMemory(1);

        DoubleTensor expResultWeightsG = new DoubleTensor(3,3,2,1);
        expResultWeightsG.data.add(2064);
        expResultWeightsG.data.add(2200);
        expResultWeightsG.data.add(2336);
        expResultWeightsG.data.add(2880);
        expResultWeightsG.data.add(3016);
        expResultWeightsG.data.add(3152);
        expResultWeightsG.data.add(3696);
        expResultWeightsG.data.add(3832);
        expResultWeightsG.data.add(3968);

        expResultWeightsG.data.add(6960);
        expResultWeightsG.data.add(7096);
        expResultWeightsG.data.add(7232);
        expResultWeightsG.data.add(7776);
        expResultWeightsG.data.add(7912);
        expResultWeightsG.data.add(8048);
        expResultWeightsG.data.add(8592);
        expResultWeightsG.data.add(8728);
        expResultWeightsG.data.add(8864);

        DoubleTensor expResultBiasG = new DoubleTensor(1);
        expResultBiasG.data.add(136);
        instance.fProp(input, false);
        instance.updateLayerWGrad(chainGrad);

        for(int i = 0; i < instance.weightsGrad.size(); i++){
            assertEquals(expResultWeightsG.data.getQuick(i), instance.weightsGrad.data.getQuick(i), 1E-7);
        }

        for(int i = 0; i < instance.biasGrad.size(); i++){
            assertEquals(expResultBiasG.data.getQuick(i), instance.biasGrad.data.getQuick(i), 1E-7);
        }
    }
}