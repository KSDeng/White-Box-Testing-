// Jcoco tutorial: https://www.baeldung.com/jacoco
package com.test.jacoco.test;

import static org.junit.Assert.assertEquals;

/**
 * Created by superZh on 2019/10/1.
 */

import org.junit.Test;
import com.test.jacoco.HelloWorld;

public class HelloWorldTest {
    @Test
    public void testMethod1() {
        HelloWorld hw = new HelloWorld();
        String a = hw.Method1();
        assertEquals("Hello World", a);
    }

    @Test
    public void testMethod2() {
        HelloWorld hw = new HelloWorld();
        int a = hw.Method2(2, 1);
        assertEquals(3, a);
    }
    
    @Test
    public void testMethod3() {
    	/**
    	 * TODO：finish the test function
    	 */

    	HelloWorld hw = new HelloWorld();
    	// Branch 1
        int[][] testBranch1 = {
                {6, -1, 2},
                {6, -1, -2},
                {6, 1, 2},
                {6, 1, -2},
                {3, -1, 2},
                {3, -1, -2},
                {3, 1, 2},
                {3, 1, -2}
        };
    	for(int[] tc: testBranch1){
    	    hw.Method3(tc[0], tc[1], tc[2]);
        }

    	// Branch 2
        int[][] testBrach2 = {
                {3, 0, -3},
                {3, 0, 1},
                {8, 0, -3},
                {8, 0, 1}
        };
    	for(int[] tc: testBrach2){
    	    hw.Method3(tc[0], tc[1], tc[2]);
        }

    	// Branch 3
        hw.Method3(0,0,0);
    }
    /**
     * TODO: add the test function of other methods in HelloWorld.java
     */
    @Test
    public void testMethod4(){
        HelloWorld hw = new HelloWorld();
        hw.Method4(0,0,0,0,0);

        hw.Method4(5,5,6,6,1.0f);
        hw.Method4(1,1,6,6,1.0f);
        hw.Method4(5,5,6,5,1.0f);
        hw.Method4(1,1,6,5,1.0f);
        hw.Method4(5,2,6,6,1.0f);
        //hw.Method4(1,2,6,6,1.0f);
        //hw.Method4(5,2,6,5,1.0f);
        //hw.Method4(1,2,6,5,1.0f);

    }

    @Test
    public void testIsTriangle(){
        HelloWorld hw = new HelloWorld();
        int[] a_ts1 = {-1, 2};
        int[] b_ts1 = {-1, 2};
        int[] c_ts1 = {-1, 2};
        for(int i = 0; i < a_ts1.length; i++){
            for(int j = 0; j < b_ts1.length; j++){
                for(int k = 0; k < c_ts1.length; k++){
                    if(i == 1 && j == 1 && k == 1){
                        assert hw.isTriangle(a_ts1[i], b_ts1[j], c_ts1[k]);
                    }else{
                        assert !hw.isTriangle(a_ts1[i], b_ts1[j], c_ts1[k]);
                    }
                }
            }
        }

        assert hw.isTriangle(10,5,6);
        assert !hw.isTriangle(10,5,4);
        assert hw.isTriangle(4,10,7);
        assert !hw.isTriangle(4,10,4);
        assert hw.isTriangle(8,7,12);
        assert !hw.isTriangle(8,1,12);

    }
    @Test
    public void testIsBirthday(){
        HelloWorld hw = new HelloWorld();

        // Valid/invalid tests
        int[] years_ts1 = {1989, 1998, 2020};
        int[] months_ts1 = {-1, 6, 13};
        int[] days_ts1 = {-1, 20, 32};

        for(int i = 0; i < years_ts1.length; i++){
            for(int j = 0; j < months_ts1.length; j++){
                for(int k = 0; k < days_ts1.length; k++){
                    if(i == 1 && j == 1 && k == 1){
                        assert hw.isBirthday(years_ts1[i], months_ts1[j], days_ts1[k]);
                    }else {
                        assert !hw.isBirthday(years_ts1[i], months_ts1[j], days_ts1[k]);
                    }
                }
            }
        }

        // Big months tests
        assert hw.isBirthday(1990, 1, 31);
        assert hw.isBirthday(2019, 3, 31);
        assert !hw.isBirthday(1990, 4, 31);
        assert !hw.isBirthday(2019, 6, 31);
        assert !hw.isBirthday(2008, 9, 31);
        assert hw.isBirthday(2008, 9, 30);
        assert !hw.isBirthday(2008, 11, 31);
        assert hw.isBirthday(2006, 11, 30);

        // February tests
        assert !hw.isBirthday(1990, 2, 29);
        assert hw.isBirthday(1992, 2, 29);
        assert hw.isBirthday(2000, 2, 29);
        assert !hw.isBirthday(2019, 2, 29);
        assert hw.isBirthday(1990, 3, 29);
        assert hw.isBirthday(1992, 3, 29);
        assert hw.isBirthday(2000, 3, 29);
        assert hw.isBirthday(2019, 3, 20);
        assert hw.isBirthday(1990, 2, 20);
        assert hw.isBirthday(1992, 2, 20);
        assert hw.isBirthday(2000, 2, 20);
        assert hw.isBirthday(2019, 2, 20);
        assert hw.isBirthday(1990, 3, 20);
        assert hw.isBirthday(1992, 3, 20);
        assert hw.isBirthday(2000, 3, 20);
        assert hw.isBirthday(2019, 3, 20);

        // Border tests
        assert hw.isBirthday(1990, 1, 1);
        assert !hw.isBirthday(1989, 12, 31);
        assert hw.isBirthday(2019, 10, 1);
        assert !hw.isBirthday(2019, 10, 2);
        assert !hw.isBirthday(2019, 11, 2);
    }

    @Test
    public void testMiniCalculator(){
        HelloWorld hw = new HelloWorld();

        assert hw.miniCalculator(1, 2, '+') == 3;
        assert hw.miniCalculator(-1,3,'-') == -4;
        assert hw.miniCalculator(-2.5, 1.2, '*') == -3;
        assert hw.miniCalculator(6, 3, '/') == 2;
        assert hw.miniCalculator(4, 3, '&') == 0;
    }
}
